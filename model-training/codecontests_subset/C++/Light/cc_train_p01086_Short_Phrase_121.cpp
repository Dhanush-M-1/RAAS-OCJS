#include <bits/stdc++.h>
using namespace std;
#define rep(i, n) for (int i = 0; i < n; i++)

int a[5] = {5,7,5,7,7};
signed main() {
	int n;
	while (cin >> n && n) {
	    vector<int> v(n);
	    rep(i, n) {
	        string s; cin >> s;
	        v[i] = s.size();
	    }
	    rep(i, n) {
	        bool ok = true;
	        int idx = 0;
	        int sum = 0;
	        rep(j, 5) {
	            while (i + idx < n && sum < a[j]) {
	                sum += v[i + idx++];
	              }
	            if (sum > a[j]) {
	                ok = false;
	                break;
	            }
	            sum = 0;
	        }
	        if (ok) {
	            cout << i + 1 << endl;
	            break;
	        }
	    }
    }
}