#include <bits/stdc++.h>
using namespace std;
int n, tot, cnt, v[200001];
long long ans, c1[200001], c2[200001];
struct node {
  int x, v;
  inline bool operator<(const node &a) const { return x < a.x; }
} s[200001];
inline int read() {
  int k = 0, f = 1;
  char c;
  while ((c = getchar()) < '0' || c > '9')
    if (c == '-') f = -1;
  while (c >= '0' && c <= '9')
    k = (k << 1) + (k << 3) + (c ^ 48), c = getchar();
  return k * f;
}
inline void write(long long x) {
  if (x < 0) putchar('-'), x = -x;
  if (x / 10) write(x / 10);
  putchar(x % 10 + '0');
  return;
}
inline void add(int pos, int num, bool op) {
  for (; pos <= n; pos += pos & -pos)
    if (op)
      c1[pos] += num;
    else
      ++c2[pos];
}
inline long long sum(int pos, bool op) {
  long long res = 0;
  for (; pos; pos -= pos & -pos)
    if (op)
      res += c1[pos];
    else
      res += c2[pos];
  return res;
}
int main() {
  n = read();
  for (register int i = 1; i <= n; ++i) s[i].x = read();
  for (register int i = 1; i <= n; ++i) s[i].v = read(), v[i] = s[i].v;
  sort(v + 1, v + n + 1);
  cnt = unique(v + 1, v + n + 1) - v - 1;
  for (register int i = 1; i <= n; ++i)
    s[i].v = lower_bound(v + 1, v + cnt + 1, s[i].v) - v;
  sort(s + 1, s + n + 1);
  for (register int i = 1; i <= n; ++i) {
    long long sum1 = sum(s[i].v, 1), sum2 = sum(s[i].v, 0);
    ans += sum2 * s[i].x - sum1;
    add(s[i].v, s[i].x, 1);
    add(s[i].v, 1, 0);
  }
  write(ans);
  return 0;
}
