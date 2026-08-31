#include <bits/stdc++.h>
using namespace std;
int main() {
  int r, a, b, i, n, j, u, v;
  int x0, y0, x1, y1;
  cin >> x0 >> y0 >> x1 >> y1;
  cin >> n;
  set<pair<int, int> > mp;
  for (i = 0; i < n; i++) {
    cin >> r >> a >> b;
    for (j = a; j < b + 1; j++) mp.insert(pair<int, int>(r, j));
  }
  int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};
  int dy[] = {1, 1, 0, -1, -1, -1, 0, 1};
  queue<pair<int, pair<int, int> > > q;
  int ans = 0;
  bool flag = false;
  q.push(make_pair(ans, pair<int, int>(x0, y0)));
  mp.erase(mp.find(pair<int, int>(x0, y0)));
  while (!q.empty()) {
    pair<int, pair<int, int> > x = q.front();
    q.pop();
    if (x.second.first == x1 && x.second.second == y1) {
      flag = true;
      cout << x.first << endl;
      break;
    }
    for (i = 0; i < 8; i++) {
      ans = x.first;
      u = x.second.first + dx[i];
      v = x.second.second + dy[i];
      if (mp.find(pair<int, int>(u, v)) != mp.end()) {
        q.push(make_pair(ans + 1, pair<int, int>(u, v)));
        mp.erase(mp.find(pair<int, int>(u, v)));
      }
    }
  }
  if (flag == false) cout << -1 << endl;
  return 0;
}
