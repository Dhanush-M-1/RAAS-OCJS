#include <bits/stdc++.h>
using namespace std;
int a[100005];
int s[100005];
int c[100005];
int main() {
  int n, d;
  cin >> n >> d;
  for (int i = 1; i <= n; ++i) {
    cin >> a[i];
    s[i] = s[i - 1] + a[i];
    c[i] = s[i];
  }
  int add = 0;
  for (int i = n - 1; i > 0; --i) {
    c[i] = max(c[i], c[i + 1]);
  }
  int res = 0;
  int ans = 0;
  for (int i = 1; i <= n; ++i) {
    ans += a[i];
    if (ans > d) {
      cout << -1;
      return 0;
    }
    if (ans < 0 && a[i] == 0) {
      c[i] += add;
      int t = max(0, min(d - c[i], d - ans));
      ans += t;
      add += t;
      ++res;
      if (ans < 0) {
        cout << -1;
        return 0;
      }
    }
  }
  cout << res;
  return 0;
}
