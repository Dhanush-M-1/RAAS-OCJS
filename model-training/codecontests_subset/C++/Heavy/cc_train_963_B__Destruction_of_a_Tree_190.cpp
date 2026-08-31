#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1e9 + 7;
vector<vector<int> > g;
vector<int> s, d, ans;
deque<int> cur;
bool nope = false;
void dfs(const int pre, const int me) {
  for (const int son : g[me]) {
    dfs(me, son);
    if (nope) return;
  }
  if (s[me] % 2 == 0 && pre != -1) {
    d[pre] += d[me] + 1;
    ++s[pre];
    cur.push_front(me + 1);
  } else if ((s[me] % 2 == 0 && pre == -1) || (s[me] % 2 == 1 && pre != -1)) {
    ans.push_back(me + 1);
    while (d[me] > 0) {
      --d[me];
      ans.push_back(cur.front());
      cur.pop_front();
    }
  } else
    nope = true;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, a, r;
  cin >> n;
  g.resize(n);
  s.resize(n, 0);
  d.resize(n, 0);
  for (int i = 0; i < (int)n; ++i) {
    cin >> a;
    --a;
    if (a == -1)
      r = i;
    else
      g[a].push_back(i);
  }
  dfs(-1, r);
  if (nope)
    cout << "NO" << endl;
  else {
    cout << "YES" << endl;
    for (int i = 0; i < (int)(int)(ans).size(); ++i) cout << ans[i] << endl;
  }
  return 0;
}
