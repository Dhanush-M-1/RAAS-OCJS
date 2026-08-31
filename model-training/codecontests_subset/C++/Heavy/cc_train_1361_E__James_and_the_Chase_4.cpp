#include <bits/stdc++.h>
using namespace std;
template <typename tp>
inline void read(tp& x) {
  x = 0;
  char tmp;
  bool key = 0;
  for (tmp = getchar(); !isdigit(tmp); tmp = getchar()) key = (tmp == '-');
  for (; isdigit(tmp); tmp = getchar()) x = (x << 3) + (x << 1) + (tmp ^ '0');
  if (key) x = -x;
}
template <typename tp>
inline void ckmn(tp& x, tp y) {
  x = x < y ? x : y;
}
template <typename tp>
inline void ckmx(tp& x, tp y) {
  x = x < y ? y : x;
}
const int N = 100010;
struct edge {
  int la, b;
} con[N << 1];
int tot, first[N];
void add_edge(int from, int to) {
  con[++tot] = (edge){first[from], to};
  first[from] = tot;
}
int n, m;
vector<int> ans;
void clear() {
  tot = 0;
  for (int i = (1); i <= (n); ++i) first[i] = 0;
}
int key = 0;
int dep[N], vis[N], inp[N], num[N], mnv[N], dp[N];
void dfs(int pos) {
  vis[pos] = 1;
  inp[pos] = 1;
  mnv[pos] = pos;
  for (int i = first[pos]; i; i = con[i].la) {
    if (vis[con[i].b]) {
      if (inp[con[i].b]) {
        if (dep[con[i].b] < dep[mnv[pos]]) mnv[pos] = con[i].b;
        ++num[pos];
        --num[con[i].b];
      } else
        key = 1;
    } else {
      dep[con[i].b] = dep[pos] + 1;
      dfs(con[i].b);
      num[pos] += num[con[i].b];
      if (dep[mnv[con[i].b]] < dep[mnv[pos]]) mnv[pos] = mnv[con[i].b];
    }
  }
  inp[pos] = 0;
}
void fsd(int pos) {
  vis[pos] = 1;
  if (dep[pos] > 0) {
    if (num[pos] == 1) {
      dp[pos] = dp[mnv[pos]];
    }
  }
  for (int i = first[pos]; i; i = con[i].la)
    if (!vis[con[i].b]) fsd(con[i].b);
}
bool doit(int rt) {
  key = 0;
  for (int i = (1); i <= (n); ++i) vis[i] = 0;
  for (int i = (1); i <= (n); ++i) num[i] = 0;
  dfs(rt);
  if (key) return false;
  for (int i = (1); i <= (n); ++i) dp[i] = 0;
  dp[rt] = 1;
  for (int i = (1); i <= (n); ++i) vis[i] = 0;
  fsd(rt);
  for (int i = (1); i <= (n); ++i)
    if (dp[i]) ans.push_back(i);
  return true;
}
void solve() {
  int x, y;
  int sed = 0;
  read(n), read(m);
  for (int i = (1); i <= (m); ++i) {
    read(x), read(y);
    add_edge(x, y);
    sed = (sed + (long long)233 * x) % 998244353;
  }
  srand(sed);
  ans.clear();
  for (int _ = (1); _ <= (100); ++_) {
    int rt = ((rand() << 16ll) | rand()) % n + 1;
    if (doit(rt)) break;
  }
  if ((int)ans.size() * 5 < n) {
    puts("-1");
  } else {
    for (int i = (0); i <= ((int)ans.size() - 1); ++i) printf("%d ", ans[i]);
    puts("");
  }
  clear();
}
int main() {
  int T;
  read(T);
  while (T--) solve();
  return 0;
}
