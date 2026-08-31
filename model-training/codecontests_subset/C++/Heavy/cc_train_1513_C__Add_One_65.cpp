#include<bits/stdc++.h>
#define mem(a,b) memset(a,b,sizeof(a))
#define mk make_pair
#define pb push_back
const int inf=0x3f3f3f3f;
const int maxn=2e5+10;
using namespace std;
typedef long long ll;
const ll mod=1e9+7;
void useiostream()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
}
ll num[15]={0};
ll nex[15]={0};
ll dp[15][maxn]={0};
void init1()
{
    ll ans=0;
    for(int i=0;i<=9;i++)
    {
        dp[i][0]=1;
    }
    for(int k=0;k<=9;k++)
    {
        for(int h=0;h<=9;h++)
        {
            if(h==k)num[h]=1;
            else num[h]=0;
        }
        ans=1;
        for(int j=1;j<maxn;j++)
        {
            for(int i=0;i<=9;i++)
            {
                if(i==1)
                {
                    nex[i]=(num[0]+num[9])%mod;
                }
                else if(i==0)nex[0]=num[9];
                else nex[i]=num[i-1];
            }
            ans=(ans+num[9])%mod;
            for(int i=0;i<=9;i++)
            {
                num[i]=nex[i];
            }
            dp[k][j]=ans;
        }
    }
}
int main()
{
    useiostream();
    int T;
    cin>>T;
    init1();
    while(T--)
    {
        string str;
        cin>>str;
        ll ans1=0;
        int m;
        cin>>m;
        for(int i=0;i<str.size();i++)
        {
            ans1=(ans1+dp[str[i]-'0'][m])%mod;
        }
        
        cout<<ans1<<endl;
    }
}