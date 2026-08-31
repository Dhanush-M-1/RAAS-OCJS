#include <bits/stdc++.h>
inline int read() {
  int x = 0, f = 1;
  char c = getchar();
  while (c < '0' || c > '9') c = getchar();
  while (c <= '9' && c >= '0') x = x * 10 + c - '0', c = getchar();
  return x * f;
}
void print(int x) {
  if (x < 0) {
    putchar('-');
    x = -x;
  }
  if (x >= 10) print(x / 10);
  putchar(x % 10 + '0');
}
const int maxn = 5000007;
int n, m, k;
int d[maxn];
bool del[maxn];
using namespace std;
map<pair<int, int>, int> mp;
struct node {
  int v, next;
} edge[maxn];
int head[maxn], num = 0;
inline void add_edge(int u, int v) {
  edge[++num].v = v;
  edge[num].next = head[u];
  head[u] = num;
}
int ans;
int u[maxn], v[maxn];
int Ans[maxn];
queue<int> q;
void solve(int x) {
  if (d[x] >= k || del[x]) return;
  del[x] = 1;
  q.push(x);
  ans--;
  while (!q.empty()) {
    int U = q.front();
    q.pop();
    for (int i = head[U]; i; i = edge[i].next) {
      int V = edge[i].v;
      if (del[V]) continue;
      if (mp.count(make_pair(U, V)) == 0) d[V]--;
      if (d[V] < k) {
        del[V] = true;
        ans--;
        q.push(V);
      }
    }
  }
}
int main() {
  n = read(), m = read();
  k = read();
  for (int i = 1; i <= m; ++i) {
    u[i] = read(), v[i] = read();
    add_edge(u[i], v[i]);
    add_edge(v[i], u[i]);
    d[v[i]]++;
    d[u[i]]++;
  }
  ans = n;
  for (int i = 1; i <= n; ++i) solve(i);
  mp.clear();
  for (int i = m; i >= 1; --i) {
    Ans[i] = ans;
    if (!del[u[i]]) d[v[i]]--;
    if (!del[v[i]]) d[u[i]]--;
    mp[pair<int, int>(u[i], v[i])] = 1;
    mp[pair<int, int>(v[i], u[i])] = 1;
    solve(u[i]);
    solve(v[i]);
  }
  for (int i = 1; i <= m; ++i) print(Ans[i]), putchar('\n');
}
