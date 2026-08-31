#include <bits/stdc++.h>
#pragma GCC optimize(3, "Ofast", "inline")
using namespace std;
const int maxn = (long long)2e5 + 5;
const int mod = 1000000007;
const int inf = 0x3f3f3f3f;
vector<int> v[maxn];
vector<int> ans;
int in[maxn];
bool del[maxn];
int pre[maxn];
void dfs2(int x) {
  ans.push_back(x);
  del[x] = true;
  for (auto &i : v[x]) {
    --in[i];
    if ((!del[i]) && (!(in[i] & 1))) dfs2(i);
  }
}
void dfs(int x) {
  for (auto &i : v[x])
    if (!del[i]) dfs(i);
  if (!(in[x] & 1)) {
    --in[pre[x]];
    dfs2(x);
  }
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  int root;
  int n;
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    int x;
    cin >> x;
    pre[i] = x;
    if (x == 0)
      root = i;
    else {
      v[x].push_back(i);
      ++in[x], ++in[i];
    }
  }
  dfs(root);
  if (ans.size() == n) {
    cout << "YES" << '\n';
    for (auto &i : ans) cout << i << '\n';
  } else
    cout << "NO";
  return 0;
}
