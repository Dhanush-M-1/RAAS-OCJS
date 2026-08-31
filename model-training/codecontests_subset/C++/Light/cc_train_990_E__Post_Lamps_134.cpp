#include <bits/stdc++.h>
using namespace std;
inline long long getnum() {
  char c = getchar();
  long long num, sign = 1;
  for (; c < '0' || c > '9'; c = getchar())
    if (c == '-') sign = -1;
  for (num = 0; c >= '0' && c <= '9';) {
    c -= '0';
    num = num * 10 + c;
    c = getchar();
  }
  return num * sign;
}
int X[1000005], A[1000005];
int nxt(int x) {
  if (X[x] == x) return x;
  return X[x] = nxt(X[x]);
}
int main() {
  int n = getnum(), m = getnum(), k = getnum();
  for (int i = 0; i < n; i++) X[i] = i;
  X[n] = n;
  for (int i = 1; i <= m; i++) {
    int x = getnum();
    X[x] = x + 1;
  }
  for (int i = 1; i <= k; i++) A[i] = getnum();
  long long ans = LLONG_MAX;
  for (int i = 1; i <= k; i++) {
    long long tot = 0;
    for (int j = n - 1; j >= 0;) {
      int y = j - i + 1;
      if (y < 0) y = 0;
      int x = nxt(y);
      if (x > j) {
        tot = LLONG_MAX;
        break;
      }
      tot += A[i];
      j = x - 1;
    }
    ans = min(ans, tot);
  }
  if (ans == LLONG_MAX) ans = -1;
  cout << ans << endl;
}
