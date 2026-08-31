#include <bits/stdc++.h>
using namespace std;
inline long long getint() {
  long long c, x;
  for (; !isdigit(c = getchar());)
    ;
  for (x = c - '0'; isdigit(c = getchar()); x = x * 10 + c - '0')
    ;
  return x;
}
void fail() {
  puts("NO");
  exit(0);
}
const long double inf = 1e18;
const long long Inf = 200000000000000000ll;
const int N = 300010;
int G[N], ne[N], to[N], da[N], n, xb;
long long a[N], b[N];
bool tst(long long x, long long y) { return fabsl((long double)x * y) > inf; }
long long dfs(int x) {
  long long ans = b[x] - a[x];
  for (int i = G[x]; ~i; i = ne[i]) {
    long long y = dfs(to[i]);
    if (y > 0)
      ans += y;
    else {
      if (tst(y, da[i])) fail();
      ans = ans + y * da[i];
      if (ans < -Inf) fail();
    }
  }
  return ans;
}
void add(int z, int y, int x) {
  ne[xb] = G[x];
  to[xb] = y;
  da[xb] = z;
  G[x] = xb++;
}
int main() {
  n = getint();
  memset(G, -1, sizeof G);
  for (int i = 1; i <= n; i++) b[i] = getint();
  for (int i = 1; i <= n; i++) a[i] = getint();
  for (int i = 2; i <= n; i++) add(getint(), i, getint());
  if (dfs(1) >= 0)
    puts("YES");
  else
    puts("NO");
  return 0;
}
