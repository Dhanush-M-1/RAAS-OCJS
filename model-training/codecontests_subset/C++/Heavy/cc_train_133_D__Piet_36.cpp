#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:268435456")
using namespace std;
template <class T>
T abs(T &x) {
  return (x >= 0) ? (x) : (-x);
}
template <class T>
T sqr(T &x) {
  return (x) * (x);
}
template <class T>
T min(T &a, T &b) {
  return (a < b) ? (a) : (b);
}
template <class T>
T max(T &a, T &b) {
  return (a > b) ? (a) : (b);
}
const int INF = 1000 * 1000 * 1000;
const int dx[4] = {0, 1, 0, -1};
const int dy[4] = {1, 0, -1, 0};
const int leftCP = 0, rightCP = 1;
const int rightDP = 0, downDP = 1, leftDP = 2, upDP = 3;
int n, m, cnt;
int a[52][52];
int precDP[52][52];
int precCP[52][52];
int precX[52][52][4][2];
int precY[52][52][4][2];
inline bool good(int x, int y) {
  return x >= 0 && x < n && y >= 0 && y < m && a[x][y] > 0;
}
inline pair<int, int> get(int x, int y, int DP, int CP) {
  return pair<int, int>(precX[x][y][DP][CP], precY[x][y][DP][CP]);
}
int main() {
  cin >> n >> cnt;
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    m = ((int)((s).size()));
    for (int j = 0; j < m; j++) {
      a[i + 1][j + 1] = s[j] - '0';
    }
  }
  n += 2;
  m += 2;
  for (int i = 1; i < n - 1; i++)
    for (int j = 1; j < m - 1; j++)
      for (int DP = 0; DP < 4; DP++)
        for (int CP = 0; CP < 2; CP++) {
          int x = i;
          int y = j;
          int color = a[x][y];
          while (a[x + dx[DP]][y + dy[DP]] == color) {
            x += dx[DP];
            y += dy[DP];
          }
          if (CP == leftCP) {
            int newDP = (DP - 1 + 4) % 4;
            while (a[x + dx[newDP]][y + dy[newDP]] == color) {
              x += dx[newDP];
              y += dy[newDP];
            }
          } else {
            int newDP = (DP + 1) % 4;
            while (a[x + dx[newDP]][y + dy[newDP]] == color) {
              x += dx[newDP];
              y += dy[newDP];
            }
          }
          precX[i][j][DP][CP] = x;
          precY[i][j][DP][CP] = y;
        }
  int x = 1, y = 1;
  int DP = 0, CP = 0;
  while (cnt--) {
    pair<int, int> p = get(x, y, DP, CP);
    int nx = p.first;
    int ny = p.second;
    if (good(nx + dx[DP], ny + dy[DP])) {
      x = nx + dx[DP];
      y = ny + dy[DP];
    } else {
      if (CP == leftCP) {
        CP = rightCP;
      } else {
        CP = leftCP;
        DP = (DP + 1) % 4;
      }
    }
  }
  cout << a[x][y] << endl;
}
