#include <bits/stdc++.h>
using namespace std;
const int OO = (int)1e6;
set<pair<int, int> > nods;
map<pair<int, int>, bool> vis;
pair<int, int> fr, sc;
int n, r, a, p, ans, sz;
bool ok = true;
int rx[] = {1, 1, 1, 0, 0, -1, -1, -1};
int ry[] = {1, 0, -1, 1, -1, 1, 0, -1};
bool val(pair<int, int> per) { return nods.find(per) != nods.end(); }
void fun(pair<int, int> pos) {
  pair<int, int> cur;
  queue<pair<int, int> > q;
  ans = 0;
  q.push(pos);
  vis[pos] = true;
  sz = 1;
  ok = true;
  for (; !q.empty() && ok; sz = q.size(), ans++) {
    while (ok && sz--) {
      pos = q.front();
      q.pop();
      for (int i = 0; ok && i < 8; i++) {
        cur.first = (pos.first) + rx[i];
        cur.second = (pos.second) + ry[i];
        if (val(cur) && !vis[cur]) {
          q.push(cur);
          vis[cur] = true;
          if (cur == sc) ok = false;
        }
      }
    }
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> fr.first >> fr.second >> sc.first >> sc.second >> n;
  for (int i = 0; i < n; i++) {
    cin >> r >> a >> p;
    for (int j = a; j <= p; j++) {
      nods.insert({r, j});
      vis[{r, j}] = false;
    }
  }
  fun(fr);
  if (!ok)
    cout << ans << endl;
  else
    cout << -1 << endl;
  return 0;
}
