#include <bits/stdc++.h>
using namespace std;
const double PI = 3.14159265358979323846;
const double eps = (1e-9);
const int MOD = 1000000007;
int dcmp(double x, double y) { return fabs(x - y) <= eps ? 0 : x > y ? -1 : 1; }
set<pair<int, int> > can;
map<pair<int, int>, bool> visit;
int di[] = {-1, -1, -1, 0, 0, 1, 1, 1};
int dj[] = {-1, 0, 1, -1, 1, -1, 0, 1};
bool valid(int i, int j) {
  if (i < 1 || j < 1 || i > 1000000000 || j > 1000000000 ||
      can.find({i, j}) == can.end())
    return false;
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  int sti, stj, endi, endj;
  cin >> sti >> stj >> endi >> endj;
  pair<int, int> goal = {endi, endj};
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    int row, l, r;
    cin >> row >> l >> r;
    for (int j = l; j <= r; ++j) {
      can.insert({row, j});
    }
  }
  queue<pair<int, int> > q;
  q.push({sti, stj});
  if (q.front() == goal) {
    cout << 0 << endl;
    return 0;
  }
  int sz, depth;
  visit[{sti, stj}] = 1;
  for (sz = (int)(q).size(), depth = 0; !q.empty();
       ++depth, sz = (int)(q).size()) {
    while (sz--) {
      pair<int, int> cur = q.front();
      q.pop();
      for (int i = 0, j = 0; i < 8; ++i, ++j) {
        pair<int, int> to = {cur.first + di[i], cur.second + dj[j]};
        if (valid(cur.first + di[i], cur.second + dj[j])) {
          if (!visit[{cur.first + di[i], cur.second + dj[j]}]) {
            if (to == goal) {
              cout << depth + 1 << endl;
              return 0;
            }
            q.push({cur.first + di[i], cur.second + dj[j]});
            visit[{cur.first + di[i], cur.second + dj[j]}] = 1;
          }
        }
      }
    }
  }
  cout << -1 << endl;
  return 0;
}
