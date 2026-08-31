#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9;
const long long Inf = 1e18;
const int N = 2e5 + 10;
const int mod = 0;
int gi() {
  int x = 0, o = 1;
  char ch = getchar();
  while ((ch < '0' || ch > '9') && ch != '-') ch = getchar();
  if (ch == '-') o = -1, ch = getchar();
  while (ch >= '0' && ch <= '9') x = x * 10 + ch - '0', ch = getchar();
  return x * o;
}
template <typename T>
bool chkmax(T &a, T b) {
  return a < b ? a = b, 1 : 0;
};
template <typename T>
bool chkmin(T &a, T b) {
  return a > b ? a = b, 1 : 0;
};
int add(int a, int b) { return a + b >= mod ? a + b - mod : a + b; }
int sub(int a, int b) { return a - b < 0 ? a - b + mod : a - b; }
void inc(int &a, int b) { a = (a + b >= mod ? a + b - mod : a + b); }
void dec(int &a, int b) { a = (a - b < 0 ? a - b + mod : a - b); }
int n, s, a[N];
bool vis[N];
map<int, int> cnt;
map<int, vector<int>> E;
vector<int> cycle;
vector<vector<int>> ans;
void dfs(int u) {
  while (!E[u].empty()) {
    int v = E[u].back();
    E[u].pop_back();
    vis[v] = 1;
    dfs(a[v]);
    cycle.push_back(v);
  }
}
int main() {
  cin >> n >> s;
  for (int i = 1; i <= n; i++) a[i] = gi(), cnt[a[i]]++;
  int now = 1;
  for (pair<int, int> x : cnt) {
    for (int j = now; j < now + x.second; j++)
      if (a[j] != x.first) E[x.first].push_back(j);
    now += x.second;
  }
  for (int i = 1; i <= n; i++)
    if (!vis[i]) {
      cycle.clear(), dfs(a[i]);
      if (!cycle.empty())
        reverse(cycle.begin(), cycle.end()), ans.push_back(cycle),
            s -= int(cycle.size());
    }
  if (s < 0) return puts("-1"), 0;
  if (s <= 2 || int(ans.size()) <= 2) {
    printf("%d\n", int(ans.size()));
    for (vector<int> cycle : ans) {
      printf("%d\n", int(cycle.size()));
      for (int x : cycle) printf("%d ", x);
      puts("");
    }
  } else {
    s = min(s, int(ans.size()));
    printf("%d\n", int(ans.size()) - s + 2);
    while (int(ans.size()) > s) {
      vector<int> cycle = ans.back();
      ans.pop_back();
      printf("%d\n", int(cycle.size()));
      for (int x : cycle) printf("%d ", x);
      puts("");
    }
    printf("%d\n", s);
    int sum = 0;
    for (auto cycle : ans)
      printf("%d ", cycle.back()), sum += int(cycle.size());
    puts("");
    printf("%d\n", sum);
    reverse(ans.begin(), ans.end());
    for (auto cycle : ans)
      for (int x : cycle) printf("%d ", x);
    puts("");
  }
  return 0;
}
