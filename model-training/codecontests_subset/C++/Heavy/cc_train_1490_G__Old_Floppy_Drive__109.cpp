#include<bits/stdc++.h>
#define ll long long
using namespace std;
const int maxn=3e5+10;

ll sum[maxn];
ll arr[maxn],xrr[maxn];
ll ans[maxn];
#define PII pair<ll,int>
int main()
{
    int T;cin>>T;
    while(T--)
    {
        int n,m;cin>>n>>m;
        ll mx=-(1e12);
        for(int i=1;i<=n;i++) cin>>arr[i];
        for(int i=1;i<=m;i++) cin>>xrr[i];
        for(int i=1;i<=n;i++) sum[i]=sum[i-1]+arr[i];
        vector<PII> v;v.clear();
        for(int i=1;i<=n;i++) if(sum[i]>mx) v.push_back({sum[i],i}),mx=sum[i];
        // sort(v.begin(),v.end(),[](PII a,PII b){if(a.first!=b.first) return a.first<b.first;
        //                                        else return a.second<b.second;});
                            
        vector<ll> lowv;lowv.clear();
        for(auto x:v) lowv.push_back(x.first);
        for(int i=1;i<=m;i++)
        {
            ll cur=xrr[i];
            int pos=lower_bound(lowv.begin(),lowv.end(),cur)-lowv.begin();
            if(pos!=lowv.size())
            {
                if(lowv[pos]>=cur) ans[i]=v[pos].second-1;
            } 
           
            else
            {
                if(sum[n]<=0 ) ans[i]=-1;
                else
                {
                    // ll lst=cur-mx;
                    // ll k=0;
                    // if(lst%sum[n]==0) k=lst/sum[n];
                    // else k=lst/sum[n]+1;
                    ll k=(cur-mx-1)/sum[n]+1;
                    ll tmp_lst=k*sum[n];
                    pos=lower_bound(lowv.begin(),lowv.end(),cur-tmp_lst)-lowv.begin();
                    if(pos!=lowv.size()) ans[i]=v[pos].second-1+k*n;
                    else ans[i]=-1;
                }
                
            }
            
            
        }
        for(int i=1;i<=m;i++) cout<<ans[i]<<" ";
        cout<<endl;
    }
    return 0;
}