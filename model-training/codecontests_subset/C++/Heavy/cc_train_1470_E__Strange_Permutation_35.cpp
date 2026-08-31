#include <bits/stdc++.h>
using namespace std;

#define rep(i,a,n) for (int i=a;i<n;i++)
#define per(i,a,n) for (int i=n-1;i>=a;i--)
#define pb push_back
#define mp make_pair
#define all(x) (x).begin(),(x).end()
#define fi first
#define se second
#define SZ(x) ((int)(x).size())
typedef long long ll;
typedef double db;
typedef vector<int> VI;
typedef pair<int,int> PII;
typedef pair<long long,int> PLI;
typedef pair<long long,long long> PLL;
const ll mod=1000000007;
//mt19937_64 mrand(random_device{}()); 
//int rnd(int x) { return mrand() % x;}
ll powmod(ll a,ll b) {ll res=1;a%=mod; assert(b>=0); for(;b;b>>=1){if(b&1)res=res*a%mod;a=a*a%mod;}return res;}
ll gcd(ll a,ll b) {return b?gcd(b,a%b):a;}

struct Node
{
	int l,r;
	ll w;
};

Node dq[5][400066];
int n,c,q;
int p[30066];
int sum[5][200066];
ll sumw[5][400066];
int l[5],r[5];
vector<PII>vec;

ll f_eq(int len,int c)
{
	if(len<=1)return c==0;
	if(len-1<c)return 0;
	ll ret=1;
	for(int i=len-1;i>=len-c;i--)ret*=i;
	for(int i=c;i>1;i--)ret/=i;
	return ret;
}

ll f(int len,int c)
{
	ll ret=0;
	for(int i=0;i<=c;i++)ret+=f_eq(len,i);
	return ret;
}

bool cmp(Node&lhs,Node&rhs)
{
	return p[lhs.r]<p[rhs.r];
}

Node F(int i,int c,ll rank)
{
	//printf("____%d %d %lld\n",i,c,rank);
	int L=l[c]+sum[c][i],R=r[c]-1;
	while(L<R)
	{
		int mid=(L+R)>>1;
		if(sumw[c][mid]-sumw[c][sum[c][i]+l[c]-1]>=rank)
			R=mid;
		else L=mid+1;
	}
	//printf("??? %d %d\n",L,sum[c][i]);
	return Node{dq[c][L].l,dq[c][L].r,sumw[c][L-1]-sumw[c][sum[c][i]+l[c]-1]};
}

int main()
{
	int _;
	scanf("%d",&_);
	while(_--)
	{
		scanf("%d%d%d",&n,&c,&q);
		//printf("%lld\n",f(n,c));
		for(int i=1;i<=n;i++)scanf("%d",&p[i]);

		for(int i=0;i<=c;i++)
			for(int j=0;j<=n;j++)sum[i][j]=0;

		for(int s=1;s<=c;s++)
		{
			l[s]=200033,r[s]=200033;
			dq[s][r[s]++]=Node{n,n,1};

			
			for(int i=n-1;i>0;i--)
			{
				int L=0,R=0;
				for(int j=i+1;j<=min(n,i+s);j++)
				{
					if(p[j]<p[i])
					{
						L++;
						dq[s][l[s]-L]=Node{i,j,f(n-j,s-(j-i))};
						sum[s][i+1]++;
					}
					else
					{
					
						dq[s][r[s]+R]=Node{i,j,f(n-j,s-(j-i))};
						R++;
					}
				}
				l[s]-=L;
				sort(dq[s]+l[s],dq[s]+l[s]+L,cmp);
				r[s]+=R;
				sort(dq[s]+r[s]-R,dq[s]+r[s],cmp);
			}
				
			for(int i=1;i<=n;i++)sum[s][i]+=sum[s][i-1];
			sumw[s][l[s]-1]=0;
			for(int i=l[s];i<r[s];i++)
				sumw[s][i]=sumw[s][i-1]+dq[s][i].w;
		}
		// int tmp=4;
		// for(int i=l[tmp];i<r[tmp];i++)
		// 	printf("%d %d %lld____\n",dq[tmp][i].l,dq[tmp][i].r,dq[tmp][i].w);
		// puts("_____");
		// tmp=3;
		// for(int i=l[tmp];i<r[tmp];i++)
		// 	printf("%d %d %lld____\n",dq[tmp][i].l,dq[tmp][i].r,dq[tmp][i].w);

	//	printf("%lld ((\n",sumw[4][200023]);
		ll lim=f(n,c);
		while(q--)
		{
			int x;
			ll y;
			scanf("%d%lld",&x,&y);
			vec.clear();

			if(y>lim){puts("-1");continue;}

			int pos=1,w=c;
			while(pos<n&&w>0)
			{
				auto node=F(pos,w,y);
				//puts("@@@");
				vec.pb(mp(node.l,node.r));
				pos=node.r+1;
				w-=(node.r-node.l);
				y-=node.w;
			}

			bool ok=false;

			//for(auto node:vec)printf("%d %d__\n",node.fi,node.se);
			for(auto node:vec)
			{
				if(node.fi<=x&&node.se>=x)
				{
					ok=true;
					int ans=p[node.fi+node.se-x];
					printf("%d\n",ans);
					break;
				}
			}
			if(!ok)printf("%d\n",p[x]);
		}
	}
	return 0;
}

/*
1
3 1 4
1 2 3
1 1
2 1
3 1
1 2


1
6 4 1
6 5 4 3 1 2
3 14


*/