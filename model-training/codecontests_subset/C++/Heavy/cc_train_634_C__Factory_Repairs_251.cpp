#include <bits/stdc++.h>
using namespace std;
template <typename T, typename U>
inline void smin(T &a, U b) {
  if (a > b) a = b;
}
template <typename T, typename U>
inline void smax(T &a, U b) {
  if (a < b) a = b;
}
int bx[200010], by[200010];
int a, b;
int calc1(int u) {
  int ans = 0;
  if (u == 0) return 0;
  for (; u; u -= u & -u) ans += bx[u];
  return ans;
}
void add1(int u, int x) {
  int tmp = calc1(u) - calc1(u - 1);
  x = min(a, tmp + x) - tmp;
  for (; u < 200010; u += u & -u) bx[u] += x;
}
int calc2(int u) {
  int ans = 0;
  if (u == 0) return 0;
  for (; u; u -= u & -u) ans += by[u];
  return ans;
}
void add2(int u, int x) {
  int tmp = calc2(u) - calc2(u - 1);
  x = min(b, tmp + x) - tmp;
  for (; u < 200010; u += u & -u) by[u] += x;
}
int main() {
  int n, k, q;
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    int f;
    scanf("%d", &f);
    if (f == 1) {
      int id, val;
      scanf("%d %d", &id, &val);
      add1(id, val);
      add2(id, val);
    } else {
      int id;
      scanf("%d", &id);
      int ans = 0;
      ans = calc2(id - 1) + calc1(n) - calc1(id + k - 1);
      printf("%d\n", ans);
    }
  }
  return 0;
}
