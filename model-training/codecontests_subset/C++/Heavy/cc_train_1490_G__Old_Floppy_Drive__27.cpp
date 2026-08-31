#include"bits/stdc++.h"
#define int long long
#define mod 1000000007
#define pf push_forward
#define pb push_back
#define mp make_pair
#define all(v) v.begin(),v.end()
#define f(i,in,n) for(i=in; i<n; ++i)
#define scant int t,t2055; cin>>t2055;for(t=1;t<=t2055;t++)
using namespace std;
int32_t main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif
	scant {
		int n, m, i, j;
		cin >> n >> m;
		int a[n];
		for (i = 0; i < n; i++) {
			cin >> a[i];
		}
		int sum = 0; map<int, int>m1;
		for (i = 0; i < n; i++) {
			sum += a[i];
			if (m1.empty()) {
				m1[sum] = i;
			}
			auto x = m1.end(); x--;
			if (x->first < sum) {
				m1[sum] = i;
			}
		}
		while (m--) {
			int x; cin >> x;
			auto lb = m1.lower_bound(x);
			if (lb != m1.end()) {
				cout << lb->second << " "; continue;
			}
			if (sum <= 0) {
				cout << -1 << " "; continue;
			}
			int mx; auto temp = m1.end(); temp--;
			mx = temp->first;
			x -= mx;
			int turns = x / sum;
			int left = x % sum;
			left += mx;
			if (left > mx) {
				turns++;
				left -= sum;
			}
			turns *= n;
			turns--;
			// cout << m1.lower_bound(left)-> << endl;
			if (left > 0) {
				lb = m1.lower_bound(left);
				turns += lb->second;
				// cout << m1[1];
				turns++;
			}
			cout << turns  << " ";
		}
		cout << endl;
	}
}