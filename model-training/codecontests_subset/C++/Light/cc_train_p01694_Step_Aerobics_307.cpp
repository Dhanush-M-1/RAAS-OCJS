#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {
	int n;
	while(cin >> n && n != 0) {
		vector<string> s(n);
		for(int i=0;i<n;i++) cin >> s[i];
		int lc = 0, rc = 0, ans = 0;
		for(int i=0;i<n-1;i++) {
			if(s[i]=="lu" and s[i+1]=="ru") {
				ans++;
			}else if(s[i]=="ru" and s[i+1]=="lu") {
				ans++;
			}else if(s[i]=="ld" and s[i+1]=="rd") {
				ans++;
			}else if(s[i]=="rd" and s[i+1]=="ld") {
				ans++;
			}
		}
		cout << ans << endl;
	}
}
