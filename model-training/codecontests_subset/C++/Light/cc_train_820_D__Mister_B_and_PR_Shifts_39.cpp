#include <bits/stdc++.h>
using namespace std;
int rd() {
  int x = 0, f = 1;
  char c = getchar();
  while (c > '9' || c < '0') f = c == '-' ? -1 : 1, c = getchar();
  while (c >= '0' && c <= '9') x = x * 10 + c - 48, c = getchar();
  return x * f;
}
void wt(long long x) {
  if (x >= 10) wt(x / 10);
  putchar(x % 10 + 48);
}
const int N = 1e6 + 10;
priority_queue<int, vector<int>, greater<int>> q;
int a[N], n, tot, Ans;
long long ans, u;
int main() {
  n = rd();
  for (int i = 1; i <= n; i++) a[i] = rd();
  for (int i = 1; i <= n; i++) {
    if (a[i] >= i)
      tot++;
    else
      q.push(i - a[i]);
    ans += abs(a[i] - i);
  }
  u = ans;
  for (int k = 1; k <= n; k++) {
    tot--;
    u += n - 2 * a[k] + 1;
    u += tot, u -= q.size();
    q.push(n - a[k] + k);
    while (!q.empty()) {
      if (q.top() - k == 0)
        q.pop(), tot++;
      else
        break;
    }
    if (u < ans) ans = u, Ans = n - k;
  }
  wt(ans), putchar(32), wt(Ans);
  return 0;
}
