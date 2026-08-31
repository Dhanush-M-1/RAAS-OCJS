#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int n = 0;
  char c;
  for (c = getchar(); c < '0' || c > '9'; c = getchar())
    ;
  for (; c >= '0' && c <= '9'; c = getchar()) n = n * 10 + c - 48;
  return n;
}
const int maxn = 2e5 + 5;
int i, j, n, s, a[maxn], f[maxn], p[maxn], cnt, sum;
vector<int> an[maxn];
bool bz[maxn];
pair<int, int> b[maxn];
int get(int x) { return f[x] ? f[x] = get(f[x]) : x; }
void merge(int x, int y) {
  x = get(x), y = get(y);
  if (x != y) f[x] = y;
}
int main() {
  n = read(), s = read();
  for (i = 1; i <= n; i++) a[i] = read(), b[i] = make_pair(a[i], i);
  sort(b + 1, b + 1 + n);
  for (i = 1; i <= n; i++) p[b[i].second] = i;
  for (i = 1; i <= n; i++)
    if (a[i] == b[i].first && p[i] != i) {
      p[b[i].second] = p[i];
      b[p[i]].second = b[i].second;
      p[i] = i, b[i].second = i;
    }
  for (i = 1; i <= n; i++)
    if (p[i] != i) merge(p[i], i);
  int x = 0;
  for (i = 1; i <= n; i++) {
    int y = b[i].second;
    if (p[y] == y) continue;
    if (a[x] == a[y]) {
      if (get(x) == get(y)) continue;
      merge(x, y);
      swap(p[x], p[y]);
    }
    x = y;
  }
  for (i = 1; i <= n; i++)
    if (p[i] != i && !bz[i]) {
      cnt++, x = i;
      for (; !bz[x]; x = p[x]) sum++, bz[x] = 1, an[cnt].push_back(x);
    }
  if (s < sum) return puts("-1"), 0;
  s -= sum;
  s = min(s, cnt);
  if (s <= 2) {
    printf("%d\n", cnt);
    for (i = 1; i <= cnt; i++) {
      printf("%d\n", an[i].size());
      for (j = 0; j < an[i].size(); j++) printf("%d ", an[i][j]);
      puts("");
    }
    return 0;
  }
  printf("%d\n", cnt - s + 2);
  for (i = 1; i <= cnt - s; i++) {
    printf("%d\n", an[i].size());
    for (j = 0; j < an[i].size(); j++) printf("%d ", an[i][j]);
    sum -= an[i].size();
    puts("");
  }
  printf("%d\n", sum);
  for (i = cnt - s + 1; i <= cnt; i++)
    for (j = 0; j < an[i].size(); j++) printf("%d ", an[i][j]);
  puts("");
  printf("%d\n", s);
  for (i = cnt; i >= cnt - s + 1; i--) printf("%d ", an[i][0]);
  puts("");
}
