#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
#define int ll


#define lp3(i,s,n) for(int i = s;i < int(n); ++i)
#define lp(i, n) lp3(i,0,n)
#define pb push_back
#define debug(x) cout<<"[" << #x << " is: " << x << "] "<<endl;

#define file freopen("input.in","r",stdin);
#define fastIO std::ios::sync_with_stdio(false); cin.tie(0);

#define x first
#define y second

void solve(){
	int n, m;
	cin>>n>>m;

	int all = 0;
	vector<int> v(n);
	vector<pair<int, int>> up;
	lp(i, n){
		cin>>v[i];
		all+=v[i];
		if(all > 0 && (up.empty() || all>up.back().x))
			up.push_back({all, i});
	}
	
	while(m--){
		//debug(m)
		int k; cin>>k;
		if(up.empty() || k > up.back().x && all <= 0)
			cout<<-1<<" ";
		else{
			int ans = 0;
			if(all > 0 && k > up.back().x ){
				int z = (k-up.back().x+all-1)/all;
				k -= z*all;
				ans = z * n;
			}

			if(k == 0){
				cout<<ans-1<<" ";
				continue;
			}
			int lo = 0, hi = int(up.size())-1;
			int best = 0;
			while(lo <= hi){
				int md = lo + (hi - lo)/2;
				if(up[md].x >= k){
					hi = md-1;
					best = up[md].y;
				}
				else{
					lo = md+1;
				}
			}

			cout<<best+ans<<" ";
		}
	}

	cout<<endl;
}

int32_t main() {  fastIO
    
    int t; cin>>t;
    while(t--){
        solve();
    }
    
    return 0;
}