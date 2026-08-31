#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
//PROBLEM D
const ll N=5e3+5;
ll n,t,score[N],tag[N],wt[N],cache[N];
int32_t main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin>>t;
    while(t--)
    {
        cin>>n;
        for(ll i=1;i<=n;i++)
        cin>>tag[i];
        for(ll i=1;i<=n;i++)
        cin>>score[i];
        ll ans=0;
        memset(cache,0,sizeof(cache));
        for(ll i=2;i<=n;i++)
        {
            for(ll j=i-1;j>0;j--)
            {
                if(tag[i]==tag[j])
                continue;
                ll cachei=cache[i],cachej=cache[j];
                cache[j]=max(cache[j],cachei+abs(score[i]-score[j]));
                cache[i]=max(cache[i],cachej+abs(score[i]-score[j]));
            }
        }
        ans=*max_element(cache+1,cache+n+1);
        cout<<ans<<endl;
    }
    return 0;
}