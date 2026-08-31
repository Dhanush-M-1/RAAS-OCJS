#include <iostream>
#include <cmath>
using namespace std;
int n, m, mn, mj, a[55], b[55], c[55], d[55];
int main() {
	int i, j, x;
	cin>>n>>m;
	for(i=1; i<=n; i++) cin>>a[i]>>b[i];
	for(j=1; j<=m; j++) cin>>c[j]>>d[j];
	for(i=1; i<=n; i++) {
		mn = 2e9;
		for(j=1; j<=m; j++) {
			x = (int)abs(a[i]-c[j]) + (int)abs(b[i]-d[j]);
			if(x<mn) mn = x, mj = j;
		}
		cout<<mj<<endl;
	}
	return 0;
}