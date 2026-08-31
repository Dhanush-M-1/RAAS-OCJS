#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
const int MAXN = 1e6 + 20;
string s[MAXN];
int _next_[MAXN];
vector<int> edge[MAXN];
vector<int> sta;
int n, r, c;
pair<int, pair<int, int> > ans(0, pair<int, int>(0, 0));
inline void dfs(int u) {
  sta.push_back(u);
  int now = (int((sta).size())) - 1;
  if (now < r) now = r;
  int pre = sta[now - r];
  ans = max(ans, make_pair(pre - u, pair<int, int>(u, pre)));
  for (auto v : edge[u]) dfs(v);
  sta.pop_back();
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL), cout.tie(NULL);
  cin >> n >> r >> c;
  for (register int i = (1); i <= (n); ++i) {
    cin >> s[i];
  }
  int rt = 1, tot = 0;
  for (register int i = (1); i <= (n); ++i) {
    if (tot == (int((s[i - 1]).size()))) {
      tot = (int((s[i]).size())), rt = i;
    } else if (tot == 0) {
      tot = (int((s[i]).size())), rt = i;
    } else
      tot -= (int((s[i - 1]).size())) + 1;
    while (rt < n && tot + (int((s[rt + 1]).size())) + 1 <= c) {
      tot += (int((s[rt + 1]).size())) + 1;
      ++rt;
    }
    if (tot <= c) {
      _next_[i] = rt + 1;
      edge[_next_[i]].push_back(i);
    }
  }
  dfs(n + 1);
  for (register int i = (1); i <= (n); ++i) {
    if ((int((s[i]).size())) > c) dfs(i);
  }
  int now = ans.second.first;
  while (now != ans.second.second) {
    for (register int i = (now); i <= (_next_[now] - 1); ++i) {
      cout << s[i] << (i == _next_[now] - 1 ? '\n' : ' ');
    }
    now = _next_[now];
    if (!now) break;
  }
  return 0;
}
