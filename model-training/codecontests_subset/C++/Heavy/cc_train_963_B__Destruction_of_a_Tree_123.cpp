#include <bits/stdc++.h>
using namespace std;
void boost() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
const int N = 1e6;
const long long inf = 1e9 + 9;
const long double PI = acos(-1);
long long bin_pow(long long x, long long y) {
  long long res = 1, base = x;
  while (y) {
    if (y & 1) {
      res *= base;
      res %= inf;
    }
    base *= base;
    base %= inf;
    y /= 2;
  }
  return res;
}
int n;
vector<int> g[N];
int sz[N], cnt[N];
bool used[N];
queue<int> q;
void dfs(int v, int pr = -1) {
  sz[v] = 1;
  for (int i = 0; i < g[v].size(); i++) {
    int to = g[v][i];
    if (to == pr) {
      continue;
    }
    dfs(to, v);
    sz[v] += sz[to];
    if (sz[to] % 2 == 0) {
      cnt[v]++;
    }
  }
  if (v != 1 && (sz[v] & 1)) {
    cnt[v]++;
  }
}
int main() {
  boost();
  cin >> n;
  if (n % 2 == 0) {
    cout << "NO";
    return 0;
  }
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    if (x != 0) {
      g[x].push_back(i);
      g[i].push_back(x);
    }
  }
  dfs(1);
  vector<int> ans;
  for (int i = 1; i <= n; i++) {
    if (cnt[i] == 0) {
      q.push(i);
    }
  }
  while (!q.empty()) {
    int v = q.front();
    q.pop();
    ans.push_back(v);
    used[v] = 1;
    for (int i = 0; i < g[v].size(); i++) {
      int to = g[v][i];
      if (used[to]) {
        continue;
      }
      cnt[to]--;
      if (cnt[to] == 0) {
        q.push(to);
      }
    }
  }
  cout << "YES\n";
  for (int i = 0; i < ans.size(); i++) {
    cout << ans[i] << "\n";
  }
}
