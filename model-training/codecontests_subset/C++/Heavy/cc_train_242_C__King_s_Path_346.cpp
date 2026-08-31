#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:100000000,100000000")
using namespace std;
const long long inf = 1e18 + 7;
const long long mod = 1e9 + 7;
const double eps = 1e-10;
const double PI = 2 * acos(0.0);
const double E = 2.71828;
int main(void) {
  long long x0, y0, x1, oh_my_humble_y1;
  cin >> x0 >> y0;
  cin >> x1 >> oh_my_humble_y1;
  map<long long, map<long long, long long> > M;
  long long n;
  cin >> n;
  for (long long(i) = 0; (i) < (long long)(n); (i)++) {
    long long r1, a, b;
    cin >> r1 >> a >> b;
    for (long long i = a; i <= b; i++) {
      M[r1][i] = 1;
    }
  }
  map<long long, map<long long, long long> > dist, was;
  queue<pair<long long, long long> > Q;
  long long dx[] = {0, 0, 1, -1, -1, 1, 1, -1};
  long long dy[] = {1, -1, 0, 0, 1, -1, 1, -1};
  Q.push(make_pair(x0, y0));
  dist[x0][y0] = 0;
  was[x0][y0] = 1;
  while (!Q.empty()) {
    long long x = Q.front().first, y = Q.front().second;
    Q.pop();
    if (x == x1 && y == oh_my_humble_y1) cout << dist[x][y] << endl, exit(0);
    for (long long(i) = 0; (i) < (long long)(8); (i)++) {
      long long X = x + dx[i], Y = y + dy[i];
      if (X > 0 && X <= 1e9 && Y > 0 && Y <= 1e9 && M[X][Y] == 1 &&
          was[X][Y] == 0) {
        dist[X][Y] = dist[x][y] + 1;
        was[X][Y] = 1;
        Q.push(make_pair(X, Y));
      }
    }
  }
  cout << -1 << endl;
  return 0;
}
