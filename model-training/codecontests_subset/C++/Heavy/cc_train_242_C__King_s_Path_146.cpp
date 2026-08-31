#include <bits/stdc++.h>
using namespace std;
int x, y, fx, fy;
queue<pair<int, int> > b;
map<pair<int, int>, int> d;
map<pair<int, int>, bool> q;
map<pair<int, int>, bool> w;
int n;
int main() {
  cin >> x >> y >> fx >> fy;
  cin >> n;
  int tx, ty, tz;
  for (int i = 0; i < n; i++) {
    scanf("%d %d %d", &tx, &ty, &tz);
    for (int j = ty; j <= tz; j++) {
      q[make_pair(tx, j)] = true;
      d[make_pair(tx, j)] = (1 << 30);
    }
  }
  pair<int, int> tmp = make_pair(x, y);
  w[tmp] = true;
  b.push(tmp);
  d[tmp] = 0;
  int dx[] = {-1, 0, 1}, dy[] = {-1, 0, 1}, mm;
  while (b.size() > 0) {
    tmp = b.front();
    b.pop();
    tx = tmp.first;
    ty = tmp.second;
    mm = d[tmp];
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1) continue;
        tmp = make_pair(tx + dx[i], ty + dy[j]);
        if (q[tmp] && !w[tmp])
          if (d[tmp] > mm + 1) {
            w[tmp] = true;
            d[tmp] = mm + 1;
            b.push(tmp);
          }
      }
  }
  tmp = make_pair(fx, fy);
  int val = d[tmp];
  if (val == (1 << 30))
    cout << -1;
  else
    cout << val;
  return 0;
}
