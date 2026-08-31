#include <bits/stdc++.h>
using namespace std;
inline int Gcd(int X, int Y) { return Y ? Gcd(Y, X % Y) : X; }
inline long long Gcd(long long X, long long Y) { return Y ? Gcd(Y, X % Y) : X; }
inline int Pow(int base, long long exp, int _mod) {
  if (!(base %= _mod)) return 0;
  int _ans = 1;
  for (; exp; exp >>= 1, base = (long long)base * base % _mod)
    exp& 1 ? _ans = (long long)_ans * base % _mod : 0;
  return _ans;
}
inline long long Pow(long long base, long long exp, long long _mod) {
  if (!(base %= _mod)) return 0;
  long long _ans = 1;
  for (; exp; exp >>= 1, base = base * base % _mod)
    exp& 1 ? _ans = _ans * base % _mod : 0;
  return _ans;
}
const long long INF = 0x3f3f3f3f3f3f3f3f;
int n, m, k;
int s[1000005], a[1000005];
int ib[1000005], r[1000005];
long long Ans = INF;
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= (m); ++i) scanf("%d", s + i), ib[s[i] + 1] = 1;
  for (int i = 1; i <= (k); ++i) scanf("%d", a + i);
  r[n + 1] = n + 1;
  for (int i = n; i >= (1); --i) r[i] = ib[i] ? r[i + 1] : i;
  if (ib[1]) return 0 * puts("-1");
  for (int i = 1; i <= (k); ++i) {
    int now = n + 1, cnt = 0, ok = 1;
    while (now > 1) {
      int u = now - i >= 1 ? r[now - i] : 1;
      if (u < now)
        now = u, ++cnt;
      else {
        ok = 0;
        break;
      }
    }
    if (!ok) continue;
    Ans = min(Ans, (long long)cnt * a[i]);
  }
  printf("%I64d", Ans == INF ? -1 : Ans);
  return 0;
}
