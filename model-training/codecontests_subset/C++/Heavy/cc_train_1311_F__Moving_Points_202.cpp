#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const int MX = 4e5 + 7;
int n;
long long c[MX][2];
int v[MX];
struct p {
  int x, v;
  inline bool operator<(const p& w) const { return x < w.x; }
} a[MX];
inline int lowbit(int x) { return x & -x; }
void add(int pos, long long k) {
  while (pos <= n) {
    c[pos][0]++;
    c[pos][1] += k;
    pos += lowbit(pos);
  }
}
long long sum(int pos, int k) {
  long long res = 0;
  while (pos) {
    res += c[pos][k];
    pos -= lowbit(pos);
  }
  return res;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%d", &a[i].x);
  for (int i = 1; i <= n; ++i) scanf("%d", &a[i].v), v[i] = a[i].v;
  sort(a + 1, a + 1 + n);
  sort(v + 1, v + 1 + n);
  int m = unique(v + 1, v + 1 + n) - v - 1;
  long long res = 0;
  for (int i = 1; i <= n; ++i) {
    int pos = lower_bound(v + 1, v + 1 + m, a[i].v) - v;
    res += a[i].x * sum(pos, 0) - sum(pos, 1);
    add(pos, a[i].x);
  }
  printf("%lld\n", res);
  return 0;
}
