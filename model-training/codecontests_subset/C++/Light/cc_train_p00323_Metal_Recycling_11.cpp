#include <iostream>
#include <set>
#include <map>
#include <queue>
using namespace std;
using llong = long long;

int n;
int a[100005];
int b[100005];
map<llong, llong> mp;

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i] >> b[i];
		mp[a[i] + b[i]]++;
	}
	
	llong x = -100;
	while (mp.upper_bound(x) != mp.end()) {
		x = mp.upper_bound(x)->first;
		
		if (mp[x] >= 2) {
			mp[x + 1] += mp[x] / 2;
			mp[x] %= 2;
		}
		
		if (mp[x] == 0) {
			mp.erase(x);
		}
	}
	
	for (auto p:mp) {
		cout << p.first << ' ' << 0 << endl;
	}
	
	return 0;
}
