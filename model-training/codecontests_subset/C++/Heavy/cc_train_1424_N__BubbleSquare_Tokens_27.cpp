#include <bits/stdc++.h>
using namespace std;
template <typename T>
void chmin(T &x, const T &y) {
  if (x > y) x = y;
}
template <typename T>
void chmax(T &x, const T &y) {
  if (x < y) x = y;
}
int read() {
  char c;
  while ((c = getchar()) < '-')
    ;
  if (c == '-') {
    int x = (c = getchar()) - '0';
    while ((c = getchar()) >= '0') x = x * 10 + c - '0';
    return -x;
  }
  int x = c - '0';
  while ((c = getchar()) >= '0') x = x * 10 + c - '0';
  return x;
}
const int N = 12500 + 5, M = 1e6 + 5;
struct Edge {
  int to, id;
};
vector<Edge> lk[N];
pair<int, int> e[M];
int s[N], ans[M];
bool w[N], mark[N];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) s[i] = w[i] = 1;
  for (int i = 1; i <= m; ++i) {
    int x = read(), y = read();
    e[i] = {x, y};
    if (x > y) swap(x, y);
    lk[y].push_back({x, i});
    ++s[x];
    ++s[y];
    ans[i] = 1;
  }
  for (int x = 1; x <= n; ++x) {
    int c1 = 0, m = lk[x].size();
    for (const auto &e : lk[x]) c1 += w[e.to];
    int c0 = m - c1;
    for (int i = 0; i <= m; ++i) mark[i] = 0;
    int p = s[x];
    for (const auto &e : lk[x])
      if (s[e.to] >= p - c0 && s[e.to] <= p + c1) mark[s[e.to] - (p - c0)] = 1;
    int r = 0;
    while (mark[r]) ++r;
    r -= c0;
    s[x] += r;
    for (const auto &e : lk[x])
      if (r > 0 && w[e.to]) {
        --r;
        w[e.to] = 0;
        ans[e.id] = 2;
      } else if (r < 0 && !w[e.to]) {
        ++r;
        w[e.to] = 1;
        ans[e.id] = 0;
      }
  }
  int c1 = 0;
  for (int i = 1; i <= n; ++i) c1 += w[i];
  printf("%d\n", c1);
  if (c1) {
    for (int i = 1; i <= n; ++i)
      if (w[i]) printf("%d%c", i, " \n"[--c1 == 0]);
  }
  for (int i = 1; i <= m; ++i)
    printf("%d %d %d\n", e[i].first, e[i].second, ans[i]);
}
