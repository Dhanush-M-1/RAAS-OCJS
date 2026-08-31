#include<bits/stdc++.h>
using namespace std;
#define Go_ ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#define ll long long int
#define llu long long unsigned int
#define pii pair<int ,int>
#define PII pair<ll ,ll>

const int Max=1e9+100;
const ll  MAX=1e18+500;
const ll sz=2e5+100;

map<ll,ll> mp;

int main()
{
    Go_
    ll a,b,c,i,j,k,q,p,x,y,ct,ct1,m,l,r,x1,y1,mn,h,sum1,in,z,mid,n,mx;
    char ch;
    double d;
    string str1,str2,str;
    bool bl,bl1;
    int t,cs=1;
    
    cin>>t;
    while(t--)
    {
        cin>>n>>m;
        mp.clear();
        
        ll sum=0;
        vector<ll> test;

        for(ll i=1;i<=n;i++)
        {
            cin>>x;
            sum+=x;
            if(mp.count(sum)==0){
                test.push_back(sum);
                mp[sum]=i-1;
            }
        }

        sort(test.begin(), test.end());
        ll siz=test.size();
        ll mn[siz];

        if(siz>0) mn[siz-1]=mp[test[siz-1]];
        for(ll i=siz-2;i>=0;i--){
            mn[i]=min(mn[i+1], mp[test[i]]);
        }

        vector<ll> ans;
        
        for(ll i=1;i<=m;i++)
        {
            cin>>x;
            auto it=lower_bound(test.begin(), test.end(), x);
            if(it != test.end()){
                ll pos=it-test.begin();
                pos=mn[pos];
                ans.push_back(pos);
            }
            else{
                if(sum<=0) ans.push_back(-1ll);
                else{
                    ll p=(x/sum);
                    if(p<0ll) {
                        ans.push_back(-1ll);
                        continue;
                    }

                    p=((x-test[siz-1]))/sum+((x-test[siz-1])%sum>0ll);
                    
                    ll le=(p * (n-1))+max(0ll, p-1);

                    ll rem=(x-(p*sum));
                    if(rem>0ll){
                       ++le;
                       ll pos=lower_bound(test.begin(), test.end(), rem)-test.begin();
                       le+=mn[pos];
                    }
                    ans.push_back(le);
                }
            }
        }


        for(auto xx: ans) cout<<xx<<" ";
        cout<<'\n';
    }
   
}
