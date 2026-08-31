
/*                          AUTHOR
                            (_|_)
                             \_/
_______________________ÃMIT SÃRKER KISHÕR_______________________
----------------------------------------------------------------
_____DEPARTMENT OF CSE, CITY UNIVERSITY, DHAKA, BANGLADESH______
----------------------------------------------------------------
*/
#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define ci std ::cin
#define co std ::cout
#define sd(n) scanf("%d",&n)
#define sdd(n,m) scanf("%d%d",&n,&m)
#define sl(n) scanf("%lld",&n)
#define sll(n,m) scanf("%lld%lld",&n,&m)
#define pd(n) printf("%d",n)
#define pdd(n,m) printf("%d%d",n,m)
#define pl(n) printf("%lld",n)
#define pll(n,m) printf("%lld%lld",n,m)
#define p_line printf("\n")
#define line cout<<"\n"
#define cas(n) printf("Case %d: ",n++)
#define task return
#define loop(x,n)  for(int x = 0 ; x < n ; x++)
#define constloop(x,a,n) for(int x = a ; x < n ; x++)
#define revloop(x,a,n)  for(int x = a ; x >= n ; x--)
#define REP(i,a,b) for (int i = a; i <= b; i++)
#define F first
#define S second
#define pb push_back
#define mkp make_pair
#define pi acos(-1)
const ll mx=100000;
const ll mod=1e9+7;
/*
ll P[mx+5],cnt=1;
bool nP[mx+5];
void sieve(void)
{
    P[0]=2;
    nP[0]=true;
    nP[1]=true;
    for(ll i=3 ; i<=mx ; i+=2)
    {
        if(nP[i]==true)
            continue;
        for(ll j=i+i ; j<=mx ; j+=i)
            nP[j]=true;
        P[cnt++]=i;
    }
}
*/
/*
ll bigMod(ll a, ll b)
{
    if(b<=0)
    {
        return 1;
    }
    ll value=bigMod(a,b/2);
    value=(value*value)%mod;
    if(b%2==1)
        value=(value*a)%mod;
    return value;
}
*/
/*
struct st
{
    int value;
    int pos; 
};
*/
/*
bool cmp(st n,st m)
{
    return n.a>m.a;
}
*/
/*
bool cmp(int n,int m)
{
    return m>n;
}
*/
void solve()
{
    //Code here
    int t=1;
    ci>>t;
    while(t--)
    {
        int k,n,m,a[105],b[105];
        cin>>k>>n>>m;
        for(int i=0 ; i<n ; i++)
        	cin>>a[i];
        for(int j=0 ; j<m ; j++)
        {
        	cin>>b[j];
        }
        int i=0,j=0,ans[500],ck=1,pos=0;
        while(i<n || j<m)
        {
        	if(i<n && a[i]==0)
        	{
        		ans[pos]=0;
        		i++,pos++;
        		k++;
        	}
        	else if(j<m && b[j]==0)
        	{
        		ans[pos]=0;
        		j++,pos++;
        		k++;
        	}
        	else
        	{
        		if(i<n && a[i]<=k)
        		{
        			ans[pos]=a[i];
        			i++,pos++;
        		}
        		else if(j<m && b[j]<=k)
        		{
        			ans[pos]=b[j];
        			j++,pos++;
        		}
        		else
        		{
        			ck=0;
        			break;
        		}
        	}
        }
        if(ck)
        {
        	for(int ii=0 ; ii<pos ; ii++)
        	{
        		cout<<ans[ii]<<" ";
        	}
        }
        else
        	cout<<-1;
        line;
    }
}
void I_O()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
}
int main()
{
    I_O();
    solve();
    //line;
    return 0;
}