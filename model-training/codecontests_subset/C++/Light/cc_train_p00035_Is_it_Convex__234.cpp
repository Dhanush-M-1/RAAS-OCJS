#define _CRT_SECURE_NO_WARNINGS
#include"bits/stdc++.h"
#include<cassert>
using namespace std;
#define int long long
#define rep(i,n) for(int i=0;i<n;i++)
const long long mod = 998244353;
const long long inf = 1ll << 61;
const double eps = 0.000000000001;
typedef pair<int, int> P;
typedef pair<P, int>PP;
struct edge { int to; int cost; };

double det(double x11,double x12,double x21,double x22) {
	return x11*x22 - x12*x21;
}

signed main() {
	double x[4],y[4];
	while (~scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&x[0],&y[0],&x[1],&y[1],&x[2],&y[2],&x[3],&y[3])) {
		double ans[4];
		rep(i, 4) {
			ans[i] = det(x[(i + 1) % 4] - x[i], y[(i + 1) % 4] - y[i], x[(i + 2) % 4] - x[i], y[(i + 2) % 4] - y[i]);
		}
		rep(i, 3)ans[0] *= ans[i + 1];
		if (ans[0] > 0)puts("YES");
		else puts("NO");
	}
}

