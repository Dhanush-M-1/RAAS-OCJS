#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
const int MOD = 1000000007;
vector<int> vec[200005];
int d[200005], deg[200005];
void dfs(int node, int p) {
  for (auto it : vec[node])
    if (it != p) d[it] = d[node] + 1, dfs(it, node);
}
struct cmp {
  bool operator()(pair<pair<int, int>, int> a,
                  pair<pair<int, int>, int> b) const {
    if ((a.first.first & 1) != (b.first.first & 1))
      return (a.first.first & 1) < (b.first.first & 1);
    else if (a.first.second != b.first.second)
      return a.first.second > b.first.second;
    else
      return a.second < b.second;
  }
};
set<pair<pair<int, int>, int>, cmp> myset;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, a;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> a, a--;
    if (a == -1) continue;
    vec[i].push_back(a);
    vec[a].push_back(i);
  }
  dfs(0, 0);
  for (int i = 0; i < n; ++i) {
    myset.insert({{(long long)vec[i].size(), d[i]}, i});
    deg[i] = (long long)vec[i].size();
  }
  vector<int> ans;
  while (!myset.empty()) {
    auto it = myset.begin();
    if (it->first.first & 1) {
      cout << "NO\n";
      return 0;
    }
    ans.push_back(it->second);
    for (auto node : vec[it->second])
      if (myset.find({{deg[node], d[node]}, node}) != myset.end()) {
        myset.erase({{deg[node], d[node]}, node});
        deg[node]--;
        myset.insert({{deg[node], d[node]}, node});
      }
    myset.erase(it);
  }
  cout << "YES\n";
  for (auto it : ans) cout << it + 1 << "\n";
  return 0;
}
