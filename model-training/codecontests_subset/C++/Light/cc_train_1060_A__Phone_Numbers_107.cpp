#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f, mod = 1000000007;
const long long INF = 0x3f3f3f3f3f3f3f3fLL;
const double pi = acosl(-1.), eps = 1e-9;
inline int power(int a, int b, int m = mod, int ans = 1) {
  for (; b; b >>= 1, a = 1LL * a * a % m)
    if (b & 1) ans = 1LL * ans * a % m;
  return ans;
}
int cnt;
int main() {
  int n;
  cin >> n;
  for (int i = 0, d; i < n; i++) {
    scanf("%1d", &d);
    if (d == 8) cnt++;
  }
  int ans = 0;
  for (int i = 1; i <= cnt; i++) {
    if ((n - i) >= i * 10) ans = i;
  }
  cout << ans << endl;
  return 0;
}
