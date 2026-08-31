#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cerr << name << " : " << arg1 << std::endl;
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cerr.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
const int N = 2e5 + 5;
int n;
vector<int> adj[N];
int root;
int degree[N], removed[N], level[N];
void dfs(int u, int p) {
  for (auto v : adj[u]) {
    if (v == p) continue;
    level[v] = level[u] + 1;
    dfs(v, u);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    if (x == 0) {
      root = i;
      continue;
    }
    adj[x].push_back(i);
    adj[i].push_back(x);
    degree[i]++, degree[x]++;
  }
  if (n % 2 == 0) {
    cout << "NO\n";
    return 0;
  }
  dfs(root, 0);
  set<pair<int, int> > s;
  for (int i = 1; i <= n; i++) {
    if (degree[i] % 2 == 0) s.insert({level[i], i});
  }
  vector<int> ans;
  while (!s.empty()) {
    auto top = *s.rbegin();
    s.erase(prev(s.end()));
    int node = top.second;
    for (auto v : adj[node]) {
      if (removed[v]) continue;
      degree[v]--;
      if (degree[v] % 2 == 1) {
        s.erase(s.find({level[v], v}));
      } else {
        s.insert({level[v], v});
      }
    }
    ans.push_back(node);
    removed[node] = 1;
  }
  if (ans.size() == n) {
    cout << "YES\n";
    for (auto i : ans) cout << i << "\n";
  } else
    cout << "NO\n";
  return 0;
}
