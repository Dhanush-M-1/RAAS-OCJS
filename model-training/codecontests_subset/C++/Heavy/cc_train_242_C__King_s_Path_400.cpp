#include <bits/stdc++.h>
using namespace std;
pair<int, int> st, en;
int n;
set<pair<int, int> > vis;
set<pair<int, int> > ok;
queue<pair<int, int> > q;
map<pair<int, int>, int> ans;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> st.first >> st.second >> en.first >> en.second;
  cin >> n;
  int r, a, b;
  for (int i = (0); i < (n); ++i) {
    cin >> r >> a >> b;
    for (int j = (a); j < (b + 1); ++j) ok.insert({r, j});
  }
  q.push(st);
  pair<int, int> cur;
  bool done = 0;
  while (!q.empty()) {
    cur = q.front();
    q.pop();
    if (cur == en) {
      cout << ans[cur] << '\n';
      done = 1;
      break;
    }
    for (int i = (-1); i < (2); ++i) {
      for (int j = (-1); j < (2); ++j) {
        pair<int, int> chi = {cur.first + i, cur.second + j};
        if (vis.find(chi) != vis.end()) continue;
        if (ok.find(chi) == ok.end()) continue;
        ans.insert({chi, ans[cur] + 1});
        vis.insert(chi);
        q.push(chi);
      }
    }
  }
  if (!done) cout << -1 << '\n';
  return 0;
}
