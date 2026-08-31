#include <bits/stdc++.h>
using namespace std;
const int N = 1000005;
int n, a[N], K, sum;
map<int, int> mp;
map<int, vector<int> > g;
vector<vector<int> > ans;
vector<int> vec;
inline void dfs(const int x) {
  register int i;
  while (!g[x].empty())
    i = g[x].back(), g[x].pop_back(), dfs(a[i]), vec.push_back(i);
  g.erase(x);
}
int main() {
  scanf("%d%d", &n, &K);
  register int i;
  for (i = 1; i <= n; ++i) scanf("%d", &a[i]), ++mp[a[i]];
  for (const auto &x : mp)
    for (i = sum + 1, sum += x.second; i <= sum; ++i)
      if (a[i] ^ x.first) g[x.first].push_back(i);
  while (!g.empty())
    vec.clear(), dfs((*g.begin()).first), std::reverse(vec.begin(), vec.end()),
        ans.push_back(vec), K -= vec.size();
  if (K < 0) return puts("-1"), 0;
  ans.size() < K ? K = ans.size() : 0,
                   printf("%d\n", ans.size() - (K > 2 ? K - 2 : 0));
  if (K < 3) {
    for (const auto &o : ans) {
      printf("%d\n", o.size());
      for (const int &i : o) printf("%d ", i);
      puts("");
    }
    return 0;
  }
  register int len = 0;
  for (i = 0; i < K; ++i) len += ans[i].size();
  printf("%d\n", len);
  for (i = 0; i < K; ++i)
    for (const int &j : ans[i]) printf("%d ", j);
  printf("\n%d\n", K);
  for (i = K - 1; ~i; --i) printf("%d ", ans[i][0]);
  puts("");
  for (i = K; i < ans.size(); ++i) {
    printf("%d\n", ans[i].size());
    for (const int &j : ans[i]) printf("%d ", j);
    puts("");
  }
  return 0;
}
