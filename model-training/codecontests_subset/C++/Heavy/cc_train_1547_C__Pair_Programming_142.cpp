#include <bits/stdc++.h>  
using namespace std;
#define fast_cin() ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL)
#define forn(i,n) for(ll i = 0; i < n; i++)

typedef long long ll;
const int MOD = 1e9 + 7;
//const int MOD = 998244353;

void solve() {
	int k, n, m; cin >> k >> n >> m;
	vector<int> a(n), b(m);
	for(int i = 0; i < n; i++) cin >> a[i];
	for(int i = 0; i < m; i++) cin >> b[i];
	int i = 0, j = 0;
	vector<int> c(n + m);
	for(int l = 0; l < m + n; l++) {
		if(i < n && a[i] == 0) {
			i++;
			k++;
		} else if(j < m && b[j] == 0) {
			j++;
			k++;
		} else {
			if(i == n) {
				if(j < m && b[j] <= k) {
					c[l] = b[j];
					j++;
				} else {
					cout << -1 << endl;
					return;
				}
			} else if(j == m) {
				if(i < n && a[i] <= k) {
					c[l] = a[i];
					i++;
				} else {
					cout << -1 << endl;
					return;
				}
			}
			else if (i < n && j < m && a[i] <= b[j]) {
				if(i < n && a[i] <= k) {
					c[l] = a[i];
					i++;
				} else {
					cout << -1 << endl;
					return;
				}
			} else {
				if(j < m && b[j] <= k) {
					c[l] = b[j];
					j++;
				} else {
					cout << -1 << endl;
					return;
				}
			}
		}
	}
	if (i == n && j == m) {
		for(int l = 0; l < m + n; l++)
			cout << c[l] << " ";
		cout << endl;
	}
	else {
		cout << -1 << endl;
		return;
	}
}
 
int main() {
	#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
	#endif
	fast_cin();
	int t = 1;
	cin >> t;
	while(t--) {
		solve();
	}
	return 0;
}