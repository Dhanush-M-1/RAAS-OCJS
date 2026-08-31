#include<bits/stdc++.h>
using namespace std;
#define pb push_back
#define ff first
#define ss second
#define mp make_pair
#define IN insert
#define ALL(a) a.begin(),a.end()
typedef long long int ll;



int main() {
	// ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output56.txt", "w", stdout);
#endif
	ll t; cin >> t;
	while (t--) {
		ll k, n, m; cin >> k >> n >> m;
		ll a[n];
		for (int i = 0; i < n; i++) {
			cin >> a[i];
		}
		ll b[m];
		for (int i = 0; i < m; i++) {
			cin >> b[i];
		}
		vector<ll> ans;
		int i = 0; int j = 0;
		int k0 = 0;
		while (i < n && j < m) {
			// cout << "d";
			if (a[i] <= b[j]) {
				if (a[i] > k) {k0 = 1; break;}
				ans.push_back(a[i]);
				if (a[i] == 0)k++;
				i++;
			}
			else {
				if (b[j] > k) {k0 = 1; break;}
				ans.push_back(b[j]);
				if (b[j] == 0)k++;
				j++;
			}
		}
		while (i < n) {
			if (a[i] > k) {k0 = 1; break;}
			ans.push_back(a[i]);
			if (a[i] == 0)k++;
			i++;
		}
		while (j < m) {
			if (b[j] > k) {k0 = 1; break;}
			ans.push_back(b[j]);
			if (b[j] == 0)k++;
			j++;
		}
		if (k0) {
			cout << "-1\n";
		}
		else {
			for (auto i : ans) {
				cout << i << " ";
			}
			cout << endl;
		}

	}
}