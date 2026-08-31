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
	
	int q;
	cin >> q;
	while(q--){
		string s;
		cin >> s;
		
		int ans = 0;
		while(s.size() != 1){
			int maxi = 0;
			REP(i, 1, s.size()){
				int a = stoi(s.substr(0, i));
				int b = stoi(s.substr(i));
				maxi = max(maxi, a * b);
			}
			s = to_string(maxi);
			ans++;
		}
		
		cout << ans << endl;
		
	}
	
	return 0;
}