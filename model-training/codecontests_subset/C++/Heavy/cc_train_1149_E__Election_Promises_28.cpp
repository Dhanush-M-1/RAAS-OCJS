#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
int rd() {
  int x = 0, w = 1;
  char ch = 0;
  while (ch < '0' || ch > '9') {
    if (ch == '-') w = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + (ch ^ 48);
    ch = getchar();
  }
  return x * w;
}
int to[N], nt[N], hd[N], dg[N], tot = 1;
void adde(int x, int y) { ++tot, to[tot] = y, nt[tot] = hd[x], hd[x] = tot; }
int n, m, sg[N], sm[N], a[N], sq[N], ts, vs[N], ti;
queue<int> q;
int main() {
  n = rd(), m = rd();
  for (int i = 1; i <= n; ++i) a[i] = rd();
  for (int i = 1; i <= m; ++i) {
    int x = rd(), y = rd();
    adde(x, y), ++dg[y];
  }
  for (int i = 1; i <= n; ++i)
    if (!dg[i]) q.push(i);
  while (!q.empty()) {
    int x = q.front();
    q.pop();
    sq[++ts] = x;
    for (int i = hd[x]; i; i = nt[i]) {
      int y = to[i];
      --dg[y];
      if (!dg[y]) q.push(y);
    }
  }
  for (int i = n; i; --i) {
    int x = sq[i];
    ++ti;
    for (int j = hd[x]; j; j = nt[j]) vs[sg[to[j]]] = ti;
    while (vs[sg[x]] == ti) ++sg[x];
  }
  for (int i = 1; i <= n; ++i) sm[sg[i]] ^= a[i];
  for (int i = n; ~i; --i)
    if (sm[i]) {
      int x = 1;
      while (sg[x] != i || (a[x] ^ sm[i]) > a[x]) ++x;
      a[x] = a[x] ^ sm[i];
      ++ti;
      for (int j = hd[x]; j; j = nt[j]) {
        int y = to[j];
        if (sg[y] >= i || vs[sg[y]] == ti) continue;
        vs[sg[y]] = ti, a[y] = a[y] ^ sm[sg[y]];
      }
      puts("WIN");
      for (int j = 1; j <= n; ++j) printf("%d ", a[j]);
      exit(0);
    }
  puts("LOSE");
  return 0;
}
