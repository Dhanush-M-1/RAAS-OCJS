#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0, t = 1;
  char ch = getchar();
  while ((ch < '0' || ch > '9') && ch != '-') ch = getchar();
  if (ch == '-') t = -1, ch = getchar();
  while (ch <= '9' && ch >= '0') x = x * 10 + ch - 48, ch = getchar();
  return x * t;
}
int n, K;
int a[200];
int main() {
  n = read();
  K = read();
  int ans = 1e9;
  for (int i = 1; i <= n; ++i) {
    int x = read();
    if (K % x == 0) ans = min(ans, K / x);
  }
  cout << ans << endl;
  return 0;
}
