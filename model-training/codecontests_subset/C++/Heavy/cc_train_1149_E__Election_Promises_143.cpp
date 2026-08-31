#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline void read(T &x) {
  x = 0;
  char c = getchar();
  bool flag = false;
  while (!isdigit(c)) {
    if (c == '-') flag = true;
    c = getchar();
  }
  while (isdigit(c)) {
    x = (x << 1) + (x << 3) + (c ^ 48);
    c = getchar();
  }
  if (flag) x = -x;
}
int n, m;
int v[200010], w[200010], s[200010], d[200010], tag[200010];
vector<int> ve[200010];
struct edge {
  int to, nxt;
} e[200010];
int head[200010], edge_cnt;
void add(int from, int to) {
  e[++edge_cnt] = {to, head[from]}, head[from] = edge_cnt;
}
void topo() {
  queue<int> q;
  for (int i = 1; i <= n; ++i)
    if (!d[i]) q.push(i);
  while (!q.empty()) {
    int x = q.front();
    q.pop();
    for (int i = head[x]; i; i = e[i].nxt)
      if (--d[e[i].to] == 0) q.push(e[i].to);
    for (int i = 0; i < ve[x].size(); ++i) tag[w[ve[x][i]]] = x;
    while (tag[w[x]] == x) w[x]++;
    s[w[x]] ^= v[x];
  }
}
int main() {
  read(n), read(m);
  for (int i = 1; i <= n; ++i) read(v[i]);
  for (int i = 1; i <= m; ++i) {
    int x, y;
    read(x), read(y);
    ve[x].push_back(y), add(y, x), d[x]++;
  }
  topo();
  for (int i = n; i >= 0; --i) {
    if (!s[i]) continue;
    int pos;
    for (int j = 1; j <= n; ++j)
      if (w[j] == i && v[j] > (v[j] ^ s[i])) pos = j;
    v[pos] ^= s[i];
    for (int j = 0; j < ve[pos].size(); ++j) {
      int x = ve[pos][j];
      v[x] ^= s[w[x]], s[w[x]] = 0;
    }
    puts("WIN");
    for (int j = 1; j <= n; ++j) printf("%d ", v[j]);
    return 0;
  }
  puts("LOSE");
  return 0;
}
