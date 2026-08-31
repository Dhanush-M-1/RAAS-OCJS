#include <bits/stdc++.h>
using namespace std;
const int N = 200000;
int n, m;
int a[N + 1];
vector<int> nums;
void discrete() {
  sort(nums.begin(), nums.end());
  nums.resize(unique(nums.begin(), nums.end()) - nums.begin());
  for (int i = 1; i <= n; i++)
    a[i] = lower_bound(nums.begin(), nums.end(), a[i]) - nums.begin();
}
int val_to[N], pos_to[N + 1];
vector<pair<int, int> > nei[N + 1];
vector<bool> ban[N + 1];
vector<int> pa;
vector<vector<int> > ans;
bool vis[N + 1];
int now[N + 1];
void dfs(int x) {
  vis[x] = true;
  for (int &i = now[x]; i < nei[x].size(); i++)
    if (!ban[x][i]) {
      int y = nei[x][i].first, y0 = nei[x][i].second;
      ban[x][i] = true;
      dfs(y);
      pa.push_back(y0);
    }
}
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) scanf("%d", a + i), nums.push_back(a[i]);
  discrete();
  nums.clear();
  for (int i = 1; i <= n; i++) nums.push_back(a[i]);
  sort(nums.begin(), nums.end());
  for (int i = 0; i < n; i++) {
    if (!val_to[nums[i]]) val_to[nums[i]] = i + 1;
    pos_to[i + 1] = val_to[nums[i]];
  }
  int cnt = 0;
  for (int i = 1; i <= n; i++)
    if (pos_to[i] != val_to[a[i]])
      cnt++, nei[pos_to[i]].push_back(make_pair(val_to[a[i]], i)),
          ban[pos_to[i]].push_back(false);
  if (cnt > m) return puts("-1"), 0;
  for (int i = 1; i <= n; i++)
    if (!vis[i] && nei[i].size()) pa.clear(), dfs(i), ans.push_back(pa);
  if (min(int(ans.size()), m - cnt) > 1) {
    pa.clear();
    for (int i = 0; i + 1 < min(int(ans.size()), m - cnt); i++)
      swap(a[ans[i][0]], a[ans[i + 1][0]]);
    for (int i = 0; i < min(int(ans.size()), m - cnt); i++)
      pa.push_back(ans[i][0]);
    ans.clear();
    ans.push_back(pa);
  } else
    ans.clear();
  for (int i = 1; i <= n; i++)
    nei[i].clear(), ban[i].clear(), vis[i] = now[i] = 0;
  for (int i = 1; i <= n; i++)
    if (pos_to[i] != val_to[a[i]])
      nei[pos_to[i]].push_back(make_pair(val_to[a[i]], i)),
          ban[pos_to[i]].push_back(false);
  for (int i = 1; i <= n; i++)
    if (!vis[i] && nei[i].size()) pa.clear(), dfs(i), ans.push_back(pa);
  cout << ans.size() << "\n";
  for (int i = 0; i < ans.size(); i++) {
    printf("%d\n", int(ans[i].size()));
    for (int j = ans[i].size() - 1; ~j; j--) printf("%d ", ans[i][j]);
    puts("");
  }
  return 0;
}
