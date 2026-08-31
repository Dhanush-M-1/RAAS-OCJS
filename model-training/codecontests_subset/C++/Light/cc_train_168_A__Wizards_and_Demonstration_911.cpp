#include <bits/stdc++.h>
const long long INF = 1000000007;
const double cp = 2 * asin(1.0);
const double eps = 1e-9;
const long long mod = 1000000007;
using namespace std;
int main() {
  cin.tie(NULL);
  ios_base::sync_with_stdio(false);
  int n, x;
  double y, P;
  scanf("%d %d %lf", &n, &x, &P);
  int ans = max(0, (int)(ceil(P / 100.0 * (double)n) + 0.005) - x);
  printf("%d\n", ans);
  return 0;
}
