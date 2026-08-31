#include <bits/stdc++.h>
using namespace std;
int main(int argc, char** argv) {
  int x0, y0, x, y, n;
  int i, j, r, a, b;
  set<pair<int, int> > s;
  queue<pair<int, pair<int, int> > > q;
  cin >> x0 >> y0 >> x >> y >> n;
  for (i = 0; i < n; i++) {
    cin >> r >> a >> b;
    for (j = a; j <= b; j++) s.insert(make_pair(r, j));
  }
  q.push(make_pair(0, make_pair(x0, y0)));
  while (!q.empty()) {
    int cr = q.front().first;
    int cx = q.front().second.first;
    int cy = q.front().second.second;
    q.pop();
    for (int i = -1; i <= 1; i++)
      for (int j = -1; j <= 1; j++) {
        if (cx + i == x && cy + j == y) {
          cout << cr + 1 << endl;
          return 0;
        }
        if (i == 0 && j == 0) continue;
        if (s.count(make_pair(cx + i, cy + j)) > 0) {
          q.push(make_pair(cr + 1, make_pair(cx + i, cy + j)));
          s.erase(make_pair(cx + i, cy + j));
        }
      }
  }
  cout << -1 << endl;
  return 0;
}
