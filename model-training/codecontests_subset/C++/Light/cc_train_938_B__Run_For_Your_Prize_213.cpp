#include <bits/stdc++.h>
using namespace std;
const int maxn = 1000000 + 10;
const int maxm = 1000000 + 10;
const int mod = (int)1e9 + 7;
const int INF = 0x3f3f3f3f;
const long long LINF = (1LL << 62);
const double eps = 1e-9;
const double PI = acos(-1.0);
int a[maxn];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  a[0] = 1;
  a[n + 1] = 1e6;
  int ans = INF;
  for (int i = 0; i <= n; i++) {
    ans = min(ans, max(a[i] - 1, (int)1e6 - a[i + 1]));
  }
  printf("%d\n", ans);
  return 0;
}
