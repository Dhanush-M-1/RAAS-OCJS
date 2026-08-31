#include <bits/stdc++.h>
using namespace std;
int xi, yi, xdes, ydes, n;
map<pair<int, int>, int> mp;
pair<int, int> d[8] = {make_pair(-1, -1), make_pair(+0, -1), make_pair(+1, -1),
                       make_pair(-1, +0), make_pair(+1, +0), make_pair(-1, +1),
                       make_pair(+0, +1), make_pair(+1, +1)};
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> xi >> yi >> xdes >> ydes >> n;
  int r, a, b;
  for (int i = 0; i < n; i++) {
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) {
      mp[make_pair(r, j)] = -1;
    }
  }
  queue<pair<int, int>> q;
  q.push({xi, yi});
  mp[make_pair(xi, yi)] = 0;
  mp[make_pair(xdes, ydes)] = -1;
  while (!q.empty()) {
    auto u = q.front();
    q.pop();
    for (int i = 0; i < 8; i++) {
      pair<int, int> v = {u.first + d[i].first, u.second + d[i].second};
      if (mp[v] == -1 || mp[v] > mp[u] + 1) {
        mp[v] = mp[u] + 1;
        q.push(v);
      }
    }
  }
  cout << mp[{xdes, ydes}];
  return 0;
}
