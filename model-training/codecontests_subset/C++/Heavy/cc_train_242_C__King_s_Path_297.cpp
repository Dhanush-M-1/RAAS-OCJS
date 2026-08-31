#include <bits/stdc++.h>
using namespace std;
const long long int INF = 1e18;
const long long int mxn = 1e5 + 1;
const string fuck = "fuck";
void solve() {
  long long int x1, x2, y1, y2, n;
  set<pair<long long int, long long int> > pos;
  cin >> x1 >> y1 >> x2 >> y2;
  cin >> n;
  for (long long int i = 0; i < n; i++) {
    long long int a, b, r;
    cin >> r >> a >> b;
    for (a = a; a <= b; a++) {
      pos.insert(pair<long long int, long long int>(r, a));
    }
  }
  vector<pair<long long int, long long int> > move;
  move.push_back(pair<long long int, long long int>(-1, -1));
  move.push_back(pair<long long int, long long int>(-1, 1));
  move.push_back(pair<long long int, long long int>(-1, 0));
  move.push_back(pair<long long int, long long int>(0, -1));
  move.push_back(pair<long long int, long long int>(0, 1));
  move.push_back(pair<long long int, long long int>(1, -1));
  move.push_back(pair<long long int, long long int>(1, 0));
  move.push_back(pair<long long int, long long int>(1, 1));
  queue<pair<long long int, long long int> > q;
  pair<long long int, long long int> start = {x1, y1};
  pair<long long int, long long int> end = {x2, y2};
  q.push(start);
  map<pair<long long int, long long int>, bool> used;
  map<pair<long long int, long long int>, long long int> dis;
  set<pair<long long int, long long int> > par;
  dis[start] = 0;
  while (!q.empty()) {
    pair<long long int, long long int> top = q.front();
    q.pop();
    if (pair<long long int, long long int>(top) ==
        pair<long long int, long long int>(end)) {
      cout << dis[end];
      return;
    }
    if (used[pair<long long int, long long int>(top)]) continue;
    used[pair<long long int, long long int>(top)] = true;
    for (pair<long long int, long long int> x : move) {
      pair<long long int, long long int> cur =
          pair<long long int, long long int>(top.first + x.first,
                                             top.second + x.second);
      if (!used[pair<long long int, long long int>(cur)] &&
          pos.find(pair<long long int, long long int>(cur)) != pos.end() &&
          !dis[cur]) {
        dis[pair<long long int, long long int>(cur)] =
            dis[pair<long long int, long long int>(top)] + 1;
        q.push(pair<long long int, long long int>(cur));
      }
    }
  }
  cout << -1;
  return;
}
int main() {
  long long int cse = 1;
  while (cse--) {
    solve();
    cout << endl;
  }
}
