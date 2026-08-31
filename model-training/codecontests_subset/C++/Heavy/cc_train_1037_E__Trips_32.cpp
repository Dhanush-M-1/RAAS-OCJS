#include <bits/stdc++.h>
#pragma GCC optimize(3, "Ofast", "inline")
using namespace std;
bool Finish_read;
template <class T>
inline void read(T &x) {
  Finish_read = 0;
  x = 0;
  int f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    if (ch == EOF) return;
    ch = getchar();
  }
  while (isdigit(ch)) x = x * 10 + ch - '0', ch = getchar();
  x *= f;
  Finish_read = 1;
}
template <class T>
inline void print(T x) {
  if (x / 10 != 0) print(x / 10);
  putchar(x % 10 + '0');
}
template <class T>
inline void writeln(T x) {
  if (x < 0) putchar('-');
  x = abs(x);
  print(x);
  putchar('\n');
}
template <class T>
inline void write(T x) {
  if (x < 0) putchar('-');
  x = abs(x);
  print(x);
}
const int maxn = 200005;
set<int> G[maxn];
queue<int> q;
int n, m, k, u[maxn], v[maxn], d[maxn], vis[maxn];
vector<int> res;
inline void calc() {
  int tmp = n;
  for (int i = m; i; --i) {
    while (!q.empty()) {
      int x = q.front();
      q.pop();
      --tmp;
      for (int y : G[x]) {
        if (G[y].find(x) == G[y].end()) continue;
        G[y].erase(x);
        d[y]--;
        if (d[y] < k && !vis[y]) q.push(y), vis[y] = 1;
      }
    }
    res.push_back(tmp);
    int x = u[i], y = v[i];
    if (G[x].find(y) == G[x].end()) goto nxt;
    G[x].erase(y);
    --d[x];
    if (d[x] < k && !vis[x]) q.push(x), vis[x] = 1;
  nxt:;
    if (G[y].find(x) == G[y].end()) continue;
    G[y].erase(x);
    --d[y];
    if (d[y] < k && !vis[y]) q.push(y), vis[y] = 1;
  }
}
inline void input() {
  read(n), read(m), read(k);
  for (int i = 1; i <= m; ++i) {
    read(u[i]), read(v[i]);
    G[u[i]].insert(v[i]);
    G[v[i]].insert(u[i]);
    d[u[i]]++, d[v[i]]++;
  }
}
int main() {
  input();
  for (int i = 1; i <= n; ++i)
    if (d[i] < k) q.push(i), vis[i] = 1;
  calc();
  for (int i = 0; i < (int)res.size(); ++i)
    printf("%d\n", res[res.size() - i - 1]);
}
