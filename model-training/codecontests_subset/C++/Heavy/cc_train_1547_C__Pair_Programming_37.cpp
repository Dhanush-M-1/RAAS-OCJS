#include <bits/stdc++.h>
using namespace std;
#define PI 3.14159265358979323
#define ll long long int
#define vi vector <int>
#define vl vector <ll>
#define all(v) (v).begin(),(v).end()
#define pb push_back
#define ff first
#define ss second
#define MOD 1000000007
ll power(ll a, ll b) { //a^b
	ll res = 1;
	a = a % MOD;
	while (b > 0) {
		if (b & 1) {res = (res * a) % MOD; b--;}
		a = (a * a) % MOD;
		b >>= 1;
	}
	return res;
}

ll gcd(ll a, ll b) {return (b == 0) ? a : gcd(b, a % b);}

int main() {
#ifndef ONLINE_JUDGE
	// for getting input from input.txt
	freopen("input.txt", "r", stdin);
	// for writing output to output.txt
	freopen("output.txt", "w", stdout);
#endif
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	ll t;
	cin >> t;
	while (t--) {
		ll k, n, m;
		cin >> k >> n >> m;
		vl a(n);
		for (auto &i : a)
			cin >> i;
		vl b(m);
		for (auto &i : b)
			cin >> i;
		int f = 0;
		vl ans;
		ll i, j;
		i = j = 0;
		while (i < n || j < m) {
			while (i < n && a[i] == 0) {
				ans.pb(0);
				i++;
				k++;
			}
			while (j < m && b[j] == 0) {
				ans.pb(0);
				j++;
				k++;
			}
			if (i < n && j < m) {
				if (a[i] <= b[j]) {
					if (a[i] > k) {
						f = 1;
						break;
					}
					ans.pb(a[i]);
					i++;
					continue;
				}
				else {
					if (b[j] > k) {
						f = 1;
						break;
					}
					ans.pb(b[j]);
					j++;
					continue;
				}
			}
			if (i < n) {
				if (a[i] > k) {
					f = 1;
					break;
				}
				ans.pb(a[i]);
				i++;
				continue;
			}
			if (j < m) {
				if (b[j] > k) {
					f = 1;
					break;
				}
				ans.pb(b[j]);
				j++;
				continue;
			}
		}
		if (f)
			cout << "-1\n";
		else {
			for (auto i : ans)
				cout << i << " ";
			cout << "\n";
		}
	}
}
