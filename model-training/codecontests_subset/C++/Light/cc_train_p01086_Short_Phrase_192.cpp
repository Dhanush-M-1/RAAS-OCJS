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

int phrase[] = {5, 7, 5, 7, 7};

int main() {

	int n;
	while(cin >> n, n){
		vector<int> w(n);
		rep(i, n){
			string s;
			cin >> s;
			w[i] = s.size();
		}
		
		int ans = -1;
		rep(i, n){
			if(ans != -1) break;
			int pos = 0;
			int cnt = 0;
			REP(j, i, n){
				if(cnt + w[j] > phrase[pos]) break;
				else if(cnt + w[j] == phrase[pos]){
					pos++;
					cnt = 0;
				}
				else cnt += w[j];
				
				if(pos == 5) {
					ans = i + 1;
					break;
				}
			}
		}
		cout << ans << endl;
		
		
	}

	return 0;
}