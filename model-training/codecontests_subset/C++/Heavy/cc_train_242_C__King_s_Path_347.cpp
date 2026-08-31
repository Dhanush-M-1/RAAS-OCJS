#include <bits/stdc++.h>
using namespace std;
const long long OO = (long long)1e18 + 9;
const int oo = 2147483647;
const double EPS = 1e-9;
const double PI = acos(-1.0);
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};
int dX[] = {1, 0, -1, 0, 1, -1, 1, -1};
int dY[] = {0, 1, 0, -1, 1, 1, -1, -1};
char letters[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                  'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                  's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
int dot(int x, int y, int x2, int y2) { return x * x2 + y * y2; }
long long gcd(long long x, long long y) { return !y ? x : gcd(y, x % y); }
int ord(int r, int c, int nCol) { return (nCol * r) + c + 1; }
int cmpDouble(long double d1, long double d2) {
  return fabs(d1 - d2) <= EPS ? 0 : d1 > d2 ? 1 : -1;
}
int main() {
  int ans = 0, r, c1, c2, n, x0, y0, x1, y1;
  cin >> x0 >> y0 >> x1 >> y1 >> n;
  set<pair<int, int> > st;
  for (int i = 0; i < n; i++) {
    cin >> r >> c1 >> c2;
    for (int i = c1; i < c2 + 1; i++) st.insert(make_pair(r, i));
  }
  map<pair<int, int>, int> mp;
  queue<pair<int, int> > q;
  q.push(make_pair(x0, y0));
  int dep = 0, sz = 1;
  pair<int, int> cur = make_pair(x0, y0);
  bool ok = true;
  mp[cur] = 1;
  for (; ok && !q.empty(); ++dep, sz = q.size()) {
    while (ok && sz--) {
      cur = q.front(), q.pop();
      for (int i = 0; i < 8; i++)
        if (st.count(make_pair(cur.first + dX[i], cur.second + dY[i])) &&
            !mp[make_pair(cur.first + dX[i], cur.second + dY[i])]) {
          q.push(make_pair(cur.first + dX[i], cur.second + dY[i])),
              mp[make_pair(cur.first + dX[i], cur.second + dY[i])] = 1,
                                                           ans = max(ans,
                                                                     dep + 1);
          if (cur.first + dX[i] == x1 && cur.second + dY[i] == y1) {
            ok = false;
            break;
          }
        }
    }
  }
  if (ok)
    cout << -1 << endl;
  else
    cout << ans << endl;
  return 0;
}
