#include <iostream>
#include <string>
#include <cmath>
#include <algorithm>
#include <vector>
#include <utility>
#include <cstring>
using namespace std;

#define rep(i,n) for(int i=0; i<n; i++)
typedef long long ll;

int main() {
	int q;
	cin >> q;
	while(q--) {
		int n, cnt=0;
		cin >> n;
		while(n>=10 && cnt<10000) {
			int b = floor(log(n) / log(10.0));
			int maxi = 0;
			for(int i=0; i<b; i++) {
				int p = pow(10,i+1);
				int x = n % p;
				int y = (n-x) / p;
				maxi = max(maxi, x*y);
			}
			n = maxi;
			cnt++;
		}
		cout << (cnt==10000 ? -1 : cnt) << endl;
	}
	return 0;
}