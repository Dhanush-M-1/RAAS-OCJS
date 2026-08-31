#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void chkmax(T &a, T b) {
  if (a < b) a = b;
}
template <class T>
inline void chkmin(T &a, T b) {
  if (a > b) a = b;
}
inline int read() {
  int s = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch) && ch != '-') ch = getchar();
  if (ch == '-') ch = getchar(), f = -1;
  while (isdigit(ch)) s = s * 10 + ch - '0', ch = getchar();
  return ~f ? s : -s;
}
const int maxn = 3e5 + 20;
vector<int> ed[maxn];
int h[maxn];
int n, m, sg[maxn], rd[maxn];
int rk[maxn], tp;
inline void get_topx() {
  queue<int> q;
  for (int i = (1), _end_ = (n); i <= _end_; i++)
    if (!rd[i]) q.push(i);
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    rk[++tp] = u;
    for (int v : ed[u])
      if (!(--rd[v])) q.push(v);
  }
}
inline void init() {
  n = read();
  m = read();
  for (int i = (1), _end_ = (n); i <= _end_; i++) h[i] = read();
  for (int i = (1), _end_ = (m); i <= _end_; i++) {
    int u = read(), v = read();
    ed[u].push_back(v);
    rd[v]++;
  }
  get_topx();
}
int vis[maxn];
int sum[maxn];
inline void doing() {
  for (int i = (n), _end_ = (1); i >= _end_; i--) {
    int x = rk[i];
    for (int y : ed[x]) vis[sg[y]]++;
    while (vis[sg[x]]) ++sg[x];
    for (int y : ed[x]) vis[sg[y]]--;
  }
  for (int i = (1), _end_ = (n); i <= _end_; i++) sum[sg[i]] ^= h[i];
  for (int i = (n), _end_ = (0); i >= _end_; i--)
    if (sum[i]) {
      puts("WIN");
      for (int j = (1), _end_ = (n); j <= _end_; j++)
        if (sg[j] == i && (h[j] ^ sum[i]) < h[j]) {
          h[j] = h[j] ^ sum[i];
          for (int k : ed[j])
            if (sum[sg[k]]) h[k] ^= sum[sg[k]], sum[sg[k]] = 0;
          break;
        }
      for (int j = (1), _end_ = (n); j <= _end_; j++) printf("%d ", h[j]);
      return;
    }
  puts("LOSE");
}
int main() {
  init();
  doing();
  return 0;
}
