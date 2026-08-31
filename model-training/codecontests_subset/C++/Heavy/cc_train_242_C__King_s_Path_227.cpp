#include <bits/stdc++.h>
using namespace std;
int alowed[3] = {0, 1, -1};
int ans = 0;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  map<pair<int, int>, int> s;
  int x1, y1, x2, y2;
  cin >> x1 >> y1 >> x2 >> y2;
  int m;
  cin >> m;
  int r, a, b;
  while (m--) {
    cin >> r >> a >> b;
    for (int i = a; i <= b; i++) {
      s[make_pair(r, i)]++;
    }
  }
  queue<pair<int, int>> bfs;
  bfs.push(make_pair(x1, y1));
  while (!bfs.empty()) {
    int x = bfs.size();
    while (x--) {
      pair<int, int> cor = bfs.front();
      bfs.pop();
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          if (i == 0 && j == 0) continue;
          int xH = cor.first + alowed[i];
          int yH = cor.second + alowed[j];
          pair<int, int> s2 = make_pair(xH, yH);
          if (s.count(s2)) {
            s.erase(s2);
            bfs.push(s2);
            if (xH == x2 && yH == y2) return cout << ans + 1, 0;
          }
        }
      }
    }
    ans++;
  }
  cout << -1 << endl;
  return 0;
}
