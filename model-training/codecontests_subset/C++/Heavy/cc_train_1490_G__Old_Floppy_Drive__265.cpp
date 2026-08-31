#include <bits/stdc++.h>
using namespace std;
 
#define IOS ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define endl "\n"
#define ll long long
#define f first
#define s second
#define pii pair<int,int>
#define lui long unsigned int

const int N =2e5+5;
const int MOD = 998244353;
const ll M = 1e18;

ll qpow(ll a, ll b, ll m)
{
    ll  ans=1;
	while(b)
	{
		if(b&1)
			ans=(ans*a)%m;
		b/=2;
		a=(a*a)%m;
	}
	return ans;
}


int main()
{

#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif   

	IOS;
	
	int t=1; cin>>t;
	while(t--){
		int n, m; cin>>n>>m;
        ll sum = 0, mx = -1e18;
        map<ll, int>mm;
        int a, idx;
        for(int i=1; i<=n; i++){
            cin>>a;
            sum += a;
            if(sum>mx)
               mx = sum, idx = i;
            if(sum>0 && mm[sum] == 0){
                mm[sum] = i;
            }
        }

        if(mm.size()>1){
            auto it = mm.end();
            it--; it--;
            while(1){
                auto it1 = it; it1++;
                (*it).s = min((*it).s, (*it1).s);
                if(it == mm.begin())
                    break;
                it--; 
            }
        }
        
        int x;
        while(m--){
             cin>>x;
             if(mx<=0 ||(sum<=0 && x>mx)) cout<<-1<<" ";
             else if((sum<=0 && x<=mx) || x<=mx) {
                auto it = mm.lower_bound(x);
                int ans = (*it).s - 1;
                cout<<ans<<" ";
             }
             else{
                  ll ans = 0;
                  ll diff = x-mx;
                  ll k = ceil((float)diff/sum);
                  ans = k*n;
                  x = x - sum*k;
                  if(x){
                    auto it = mm.lower_bound(x);
                    ans += (*it).s;
                  }
                 // else ans -= n-idx; 
                  ans--;
                  cout<<ans<<" ";
             }
        }
        
        cout<<endl;
	}
}