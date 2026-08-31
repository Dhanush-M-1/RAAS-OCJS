#include <bits/stdc++.h>
using namespace std;
int n, K, a[200100];
map<int, int> mp1;
map<int, vector<int> > mp2;
vector<vector<int> > ans;
vector<int> vec;
void dfs(int x) {
  for (int i; !mp2[x].empty(); vec.push_back(i)) {
    i = mp2[x].back();
    mp2[x].pop_back();
    dfs(a[i]);
  }
  mp2.erase(x);
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> K;
  for (int i = 1; i <= n; ++i) cin >> a[i], mp1[a[i]]++;
  int sum = 1;
  for (auto i : mp1) {
    for (int j = sum; j < sum + i.second; ++j)
      if (a[j] != i.first) mp2[i.first].push_back(j);
    sum += i.second;
  }
  for (; !mp2.empty();) {
    vec.clear();
    dfs(mp2.begin()->first);
    reverse(vec.begin(), vec.end());
    ans.push_back(vec);
    K -= vec.size();
  }
  if (K < 0) {
    cout << -1 << '\n';
    return 0;
  }
  K = min(K, (int)ans.size());
  cout << (ans.size() - max(0, K - 2)) << '\n';
  if (K >= 3) {
    int len = 0;
    for (int i = 0; i < K; ++i) len += ans[i].size();
    cout << len << '\n';
    for (int i = 0; i < K; ++i)
      for (int j : ans[i]) cout << j << ' ';
    cout << '\n' << K << '\n';
    for (int i = K - 1; ~i; --i) cout << ans[i][0] << ' ';
    cout << '\n';
  } else
    K = 0;
  for (int i = K; i < (int)ans.size(); ++i) {
    cout << ans[i].size() << '\n';
    for (int j : ans[i]) cout << j << ' ';
    cout << '\n';
  }
  return 0;
}
