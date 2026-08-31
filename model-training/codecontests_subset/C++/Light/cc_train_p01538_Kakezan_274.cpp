#include<bits/stdc++.h>
using namespace std;
 
#define REP(i,s,n) for(int i=s;i<n;++i)
#define rep(i,n) REP(i,0,n)
#define SORT(c) sort((c).begin(),(c).end())
#define IINF INT_MAX
#define LLINF LLONG_MAX
#define DEBUG false
 
typedef long long ll;
typedef pair<int, int> ii;

int main() {
	
	ll q;
	cin >> q;
	while(q--){
		string n;
		cin >> n;
		ll ans = 0;
		while(n.size() > 1){
			if(ans > 10000) break;
			int maxi = 0;
			for(int pos = 1; pos < n.size(); pos++){
				int l = stoi(n.substr(0, pos));
				int r = stoi(n.substr(pos));
				maxi = max(maxi, l * r);
			}
			n = to_string(maxi);
			ans++;
		}
		
		if(ans > 10000) cout << -1 << endl;
		else cout << ans << endl;
		
	}
	
	return 0;
}
