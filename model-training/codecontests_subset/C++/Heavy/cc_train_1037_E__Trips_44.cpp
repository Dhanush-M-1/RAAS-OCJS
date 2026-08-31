#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline void read(T& x) {
  char c = getchar();
  bool f = false;
  for (x = 0; !isdigit(c); c = getchar()) {
    if (c == '-') {
      f = true;
    }
  }
  for (; isdigit(c); c = getchar()) {
    x = x * 10 + c - '0';
  }
  if (f) {
    x = -x;
  }
}
template <typename T>
inline bool checkMax(T& a, const T& b) {
  return a < b ? a = b, true : false;
}
template <typename T>
inline bool checkMin(T& a, const T& b) {
  return a > b ? a = b, true : false;
}
const int N = 2e5 + 10;
int n, m, k, degree[N], ans[N], bl, avalib[N];
vector<pair<int, int> > G[N];
pair<int, int> f[N];
int main() {
  read(n), read(m), read(k), bl = n;
  for (register int i = 1; i <= m; ++i) {
    int u, v;
    read(u), read(v);
    ++degree[u], ++degree[v];
    G[u].push_back(make_pair(v, i));
    G[v].push_back(make_pair(u, i));
    f[i] = pair<int, int>(u, v);
  }
  queue<int> Q;
  for (register int i = 1; i <= n; ++i) {
    if (degree[i] < k) {
      --bl, Q.push(i);
    }
  }
  for (register int i = m; i; --i) {
    while (!Q.empty()) {
      int x = Q.front();
      Q.pop();
      for (auto v : G[x]) {
        if (!avalib[v.second]) {
          if (--degree[v.first] == k - 1) {
            --bl, Q.push(v.first);
          }
          avalib[v.second] = 1;
        }
      }
    }
    ans[i] = bl;
    if (!avalib[i]) {
      if (--degree[f[i].first] == k - 1) {
        --bl, Q.push(f[i].first);
      }
      if (--degree[f[i].second] == k - 1) {
        --bl, Q.push(f[i].second);
      }
      avalib[i] = 1;
    }
  }
  for (register int i = 1; i <= m; ++i) {
    printf("%d\n", ans[i]);
  }
  return 0;
}
