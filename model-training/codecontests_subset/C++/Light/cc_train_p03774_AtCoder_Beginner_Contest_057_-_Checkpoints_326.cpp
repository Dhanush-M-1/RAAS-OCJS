#include "bits/stdc++.h"
using namespace std;
 
int main(void) {
	int n, m;
	cin >> n >> m;

	vector<int> f(n,300000000);
	int a[n], b[n], c[m], d[m], ans[n];

	for(int i=0;i<n;i++) cin >> a[i] >> b[i];
	for(int i=0;i<m;i++) cin >> c[i] >> d[i];

	int dif;

	for(int i=0;i<n;i++) {
		for(int j=0;j<m;j++) {
			dif = abs(a[i]-c[j])+abs(b[i]-d[j]);
			if(dif < f[i]) {
				f[i] = dif;
				ans[i] = j+1;
			}
		}
	}

	for(int i=0;i<n;i++) cout << ans[i] << endl;

}
