#include <bits/stdc++.h>
using namespace std;
const int max_N = 2e5 + 10;
int x[max_N], y[max_N];
set<int> E[max_N];
void remove(int u);
int N, M, K;
int ans = 0;
int active[max_N];
int main() {
  cin >> N >> M >> K;
  for (int i = 1; i <= M; ++i) {
    cin >> x[i] >> y[i];
    E[x[i]].insert(y[i]);
    E[y[i]].insert(x[i]);
  }
  for (int i = 1; i <= N; ++i) {
    active[i] = 1;
  }
  ans = N;
  for (int i = 1; i <= N; ++i) {
    remove(i);
  }
  vector<int> ans;
  for (int i = M; i >= 1; --i) {
    ans.push_back(::ans);
    int u = x[i], v = y[i];
    E[u].erase(v);
    E[v].erase(u);
    remove(u);
    remove(v);
  }
  reverse(ans.begin(), ans.end());
  for (auto &x : ans) {
    cout << x << '\n';
  }
}
void remove(int u) {
  if (E[u].size() >= K || !active[u]) {
    return;
  }
  active[u] = 0;
  ans--;
  for (auto &v : E[u]) {
    E[v].erase(u);
    remove(v);
  }
}
