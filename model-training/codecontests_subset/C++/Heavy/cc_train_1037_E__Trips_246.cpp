#include <bits/stdc++.h>
using namespace std;
const int inf32 = 1e9 + 9;
const long long inf64 = 1e18 + 18;
const int N = 2e5 + 5;
const long long mod = 1e9 + 9;
vector<int> gr[N];
set<pair<int, int> > deg;
int pw[N];
bool used[N];
void solve() {
  int n, m, k;
  scanf("%d%d%d", &n, &m, &k);
  vector<pair<int, int> > edges(m);
  vector<int> ans(m);
  for (int i = 0; i < m; ++i) {
    scanf("%d%d", &edges[i].first, &edges[i].second);
    --edges[i].first, --edges[i].second;
    gr[edges[i].first].push_back(edges[i].second);
    gr[edges[i].second].push_back(edges[i].first);
  }
  for (int i = 0; i < n; ++i) {
    deg.insert({gr[i].size(), i});
    pw[i] = gr[i].size();
  }
  memset(used, true, N);
  set<pair<int, int> > usedP;
  for (int i = m - 1; i >= 0; --i) {
    while (!deg.empty() && deg.begin()->first < k) {
      pair<int, int> p = *deg.begin();
      used[deg.begin()->second] = false;
      deg.erase(deg.begin());
      for (auto &x : gr[p.second]) {
        if (used[x] &&
            !(usedP.count({x, p.second}) || usedP.count({p.second, x}))) {
          deg.erase({pw[x], x});
          deg.insert({--pw[x], x});
        }
      }
    }
    ans[i] = deg.size();
    if (!ans[i]) break;
    if (used[edges[i].first] && used[edges[i].second]) {
      deg.erase({pw[edges[i].first], edges[i].first});
      deg.insert({--pw[edges[i].first], edges[i].first});
      deg.erase({pw[edges[i].second], edges[i].second});
      deg.insert({--pw[edges[i].second], edges[i].second});
      usedP.insert({edges[i].first, edges[i].second});
    }
  }
  for (auto &x : ans) printf("%d\n", x);
}
int main() {
  solve();
  return 0;
}
