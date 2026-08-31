#include <bits/stdc++.h>
using namespace std;
const int N=30050;

int t,n,c,q;
unsigned long long a[N][5],presum[N][5],nxtsum[N][5];
int p[N],ch[N][6];
int main()
{
	scanf("%d",&t);
	while(t--)
	{
		scanf("%d%d%d",&n,&c,&q);
		for(int i=1;i<=n;i++)
		{
			scanf("%d",&p[i]);
			a[i][0]=1;
			ch[i][0]=0;
		}
		for(int j=0;j<=c;j++) a[n+1][j]=1;
		for(int j=1;j<=c;j++)
		{
			for(int i=n;i>=1;i--)
			{
				a[i][j]=0;
				for(int k=0;k<=j&&i+k<=n;k++)
					a[i][j]+=a[i+k+1][j-k];
				assert(a[i][j]<=1e18);
			}
		}

		pair<int,int> temp[6];
		for(int i=1;i<=n;i++)
		{
			temp[0].first=0;
			for(int j=0;j<=c&&i+j<=n;j++)
				temp[++temp[0].first]=make_pair(p[i+j],j);
			sort(temp+1,temp+temp[0].first+1);
			ch[i][0]=temp[0].first;
			memcpy(presum+i,presum+i-1,5*sizeof(unsigned long long));
			memcpy(nxtsum+i,nxtsum+i-1,5*sizeof(unsigned long long));
			bool flag=false;
			for(int j=1;j<=temp[0].first;j++)
			{
				ch[i][j]=temp[j].second;
				if(ch[i][j]==0) {flag=true;continue;}
				if(!flag)
				{
					for(int k=ch[i][j];k<=c;k++)
						presum[i][k]+=a[i+ch[i][j]+1][k-ch[i][j]];
				}
				else
				{
					for(int k=ch[i][j];k<=c;k++)
						nxtsum[i][k]+=a[i+ch[i][j]+1][k-ch[i][j]];
				}
			}
		}

		while(q--)
		{
			int x;
			unsigned long long y;
			scanf("%d%llu",&x,&y);
			vector<pair<int,int> > v;
			int pos=1,nowc=c;
			if(y>a[1][c]) {puts("-1");continue;}
			while(pos<=n)
			{
				if(nowc==0||presum[n][nowc]-presum[pos-1][nowc]+1==y) break;
				else if(presum[n][nowc]-presum[pos-1][nowc]>=y)
				{
					int l=pos,r=n;
					while(l<r)
					{
						int mid=(l+r)>>1;
						if(presum[mid][nowc]-presum[pos-1][nowc]>=y) r=mid;
						else l=mid+1;
					}
					y-=presum[l-1][nowc]-presum[pos-1][nowc];
					pos=l;
					for(int i=1;i<=ch[pos][0];i++)
						if(nowc<ch[pos][i]) continue;
						else if(a[pos+ch[pos][i]+1][nowc-ch[pos][i]]<y)
							y-=a[pos+ch[pos][i]+1][nowc-ch[pos][i]];
						else
						{
							v.push_back(make_pair(pos,ch[pos][i]));
							nowc-=ch[pos][i];
							pos+=ch[pos][i]+1;
							break;
						}
				}
				else
				{
					y-=presum[n][nowc]-presum[pos-1][nowc]+1;
					int l=pos,r=n+1;
					while(l<r)
					{
						int mid=(l+r)>>1;
						if(nxtsum[n][nowc]-nxtsum[mid-1][nowc]<y) r=mid;
						else l=mid+1;
					}
					y-=nxtsum[n][nowc]-nxtsum[l-1][nowc];
					pos=l-1;
					bool flag=false;
					for(int i=1;i<=ch[pos][0];i++)
						if(ch[pos][i]==0) flag=true;
						else if(flag)
						{
							if(nowc<ch[pos][i]) continue;
							else if(a[pos+ch[pos][i]+1][nowc-ch[pos][i]]<y)
								y-=a[pos+ch[pos][i]+1][nowc-ch[pos][i]];
							else
							{
								v.push_back(make_pair(pos,ch[pos][i]));
								nowc-=ch[pos][i];
								pos+=ch[pos][i]+1;
								break;
							}
						}
				}
			}

			int ans=p[x];
			for(auto u:v)
			{
				if(x>=u.first&&x<=u.first+u.second)
					ans=p[u.first+u.first+u.second-x];
			}
			printf("%d\n",ans);
		}
	}
	return 0;
}