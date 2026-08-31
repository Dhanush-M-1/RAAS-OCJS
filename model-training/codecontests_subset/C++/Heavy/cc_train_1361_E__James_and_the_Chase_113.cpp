#include <bits/stdc++.h>
using namespace std;
int n, m;
int dfn;
vector<int> g[100010];
int intr[100010];
int dep[100010];
int vis[100010];
int uplink[100010];
int st[100010], en[100010];
mt19937 rng(chrono::high_resolution_clock::now().time_since_epoch().count());
struct Min2 {
  pair<int, int> a, b;
  Min2() : a({1e9, -1}), b({1e9, -1}) {}
  inline int size() {
    if (a.first == 1e9)
      return 0;
    else if (b.first == 1e9)
      return 1;
    else
      return 2;
  }
  inline void push(const pair<int, int>& cur) {
    if (cur < a) {
      b = a;
      a = cur;
    } else if (cur < b) {
      b = cur;
    }
  }
  inline void push(const Min2& o) {
    push(o.a);
    push(o.b);
  }
} up[100010];
int rTime;
inline bool dfs(int x, int TIME) {
  st[x] = ++dfn;
  en[x] = n;
  vis[x] = TIME;
  up[x] = Min2();
  for (auto ch : g[x]) {
    if (vis[ch] == TIME) {
      if (en[ch] >= st[x] && st[x] > st[ch]) {
        up[x].push({dep[ch], ch});
      } else {
        return false;
      }
    } else {
      dep[ch] = dep[x] + 1;
      if (!dfs(ch, TIME)) return false;
      up[x].push(up[ch]);
    }
  }
  if (up[x].b.first >= dep[x]) {
    uplink[x] = up[x].a.second;
  } else {
    uplink[x] = -1;
    intr[x] = 0;
  }
  en[x] = dfn;
  return true;
}
int sum;
inline void dfs1(int x) {
  if (dep[x] == 1) {
    sum += intr[x] = 1;
  } else if (uplink[x] != -1) {
    sum += intr[x] = intr[uplink[x]];
  }
  for (auto ch : g[x]) {
    if (st[ch] > st[x] && en[ch] <= en[x]) {
      dfs1(ch);
    }
  }
}
int N;
inline bool tst(int x) {
  ++N;
  dfn = 0;
  dep[x] = 1;
  if (dfs(x, N)) {
    sum = 0;
    dfs1(x);
    return true;
  }
  return false;
}
int main() {
  int TT;
  for (scanf("%d", &TT); TT; TT--) {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; i++) {
      intr[i] = -1;
      g[i].clear();
    }
    for (int i = 1; i <= m; i++) {
      int a, b;
      scanf("%d%d", &a, &b);
      g[a].push_back(b);
    }
    bool found = false;
    for (int i = 1; i <= 100; i++) {
      int x = rng() % n + 1;
      if (tst(x)) {
        found = true;
        break;
      }
    }
    if (!found || sum * 5 < n)
      puts("-1");
    else {
      for (int i = 1; i <= n; i++) {
        if (intr[i] == 1) printf("%d ", i);
      }
      puts("");
    }
  }
  return 0;
}
