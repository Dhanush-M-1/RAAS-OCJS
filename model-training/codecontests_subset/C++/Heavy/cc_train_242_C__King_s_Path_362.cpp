#include <bits/stdc++.h>
using namespace std;
const int INFI = (1 << 30);
const long long INFL = (1LL << 62);
const long long md = 1000000007;
int main() {
  int x0, y0, x1, y1;
  cin >> x0 >> y0 >> x1 >> y1;
  int n;
  cin >> n;
  map<int, map<int, bool> > m;
  for (int i = 1; i <= n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) m[r][j] = 1;
  }
  queue<int> q1, q2, q3;
  q1.push(x0);
  q2.push(y0);
  q3.push(0);
  m[x0][y0] = 0;
  int ve[8][2] = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1},
                  {-1, 0},  {0, 1},  {1, 0}, {0, -1}};
  while (!q1.empty()) {
    int x = q1.front();
    int y = q2.front();
    int s = q3.front();
    q1.pop();
    q2.pop();
    q3.pop();
    for (int q = 0; q < 8; q++) {
      if (x + ve[q][0] > 0 && y + ve[q][1] > 0 &&
          m[x + ve[q][0]][y + ve[q][1]] == 1) {
        m[x + ve[q][0]][y + ve[q][1]] = 0;
        if (x + ve[q][0] == x1 && y + ve[q][1] == y1) {
          cout << s + 1;
          return 0;
        }
        q1.push(x + ve[q][0]);
        q2.push(y + ve[q][1]);
        q3.push(s + 1);
      }
    }
  }
  cout << -1;
  return 0;
}
