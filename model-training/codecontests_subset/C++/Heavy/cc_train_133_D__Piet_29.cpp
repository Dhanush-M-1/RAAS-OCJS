#include <bits/stdc++.h>
using namespace std;
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
char ady[55][55];
int CP[4][2] = {{3, 1}, {0, 2}, {3, 1}, {0, 2}};
struct Point {
  Point() {}
  int x, y;
  Point(int xx, int yy) : x(xx), y(yy) {}
} memo[52][52][4][4];
int h, w;
void pre() {
  for (int i = 0; i < h; ++i) {
    for (int j = 0; j < w; ++j) {
      char color = ady[i][j];
      for (int dp = 0; dp < 4; ++dp) {
        int q = 1;
        int nx, ny;
        nx = i;
        ny = j;
        while (1) {
          for (int cp = 0; cp < 4; ++cp) {
            int k = 1, nxx, nyy;
            nxx = nx;
            nyy = ny;
            while (1) {
              nxx = k * dx[cp] + nx;
              nyy = k * dy[cp] + ny;
              if (nxx >= 0 && nyy >= 0 && nxx < h && nyy < w &&
                  color == ady[nxx][nyy] && ady[nxx][nyy] != '0') {
                k++;
              } else {
                int xx = memo[i][j][dp][cp].x, yy = memo[i][j][dp][cp].y;
                if (cp == 0 && xx >= (nxx - dx[cp])) {
                  memo[i][j][dp][cp].x = nxx - dx[cp];
                  memo[i][j][dp][cp].y = nyy - dy[cp];
                }
                if (cp == 2 && xx <= (nxx - dx[cp])) {
                  memo[i][j][dp][cp].x = nxx - dx[cp];
                  memo[i][j][dp][cp].y = nyy - dy[cp];
                }
                if (cp == 3 && yy >= (nyy - dy[cp])) {
                  memo[i][j][dp][cp].x = nxx - dx[cp];
                  memo[i][j][dp][cp].y = nyy - dy[cp];
                }
                if (cp == 1 && yy <= (nyy - dy[cp])) {
                  memo[i][j][dp][cp].x = nxx - dx[cp];
                  memo[i][j][dp][cp].y = nyy - dy[cp];
                }
                break;
              }
            }
          }
          nx = q * dx[dp] + i;
          ny = q * dy[dp] + j;
          if (nx >= 0 && ny >= 0 && nx < h && ny < w && color == ady[nx][ny] &&
              ady[nx][ny] != '0') {
            q++;
          } else
            break;
        }
      }
    }
  }
}
void init() {
  for (int i = 0; i < h; ++i)
    for (int j = 0; j < w; ++j)
      for (int dp = 0; dp < 4; ++dp)
        for (int cp = 0; cp < 4; ++cp)
          memo[i][j][dp][cp].x = i, memo[i][j][dp][cp].y = j;
}
int main() {
  int m, dp, cp, color;
  char c;
  cin >> h >> m;
  for (int i = 0; i < h; ++i) cin >> ady[i];
  w = strlen(ady[0]);
  init();
  pre();
  dp = 1;
  cp = 0;
  c = ady[0][0];
  int x, y, nx, ny, ax, ay, cp_fx, cp_fy;
  x = y = 0;
  int DP[55][55];
  memset(DP, -1, sizeof(DP));
  int i = 0;
  for (; i < m; ++i) {
    x = memo[x][y][dp][cp].x;
    y = memo[x][y][dp][cp].y;
    nx = x + dx[dp];
    ny = y + dy[dp];
    if (dp == 1 && (ny >= w || ady[nx][ny] == '0')) {
      if (cp == 0)
        cp = 2;
      else {
        dp = (dp + 1) % 4;
        cp = 1;
      }
    } else if (dp == 2 && (nx >= h || ady[nx][ny] == '0')) {
      if (cp == 1) {
        cp = 3;
      } else {
        dp = (dp + 1) % 4;
        cp = 2;
      }
    } else if (dp == 3 && (ny < 0 || ady[nx][ny] == '0')) {
      if (cp == 2)
        cp = 0;
      else {
        cp = 3;
        dp = (dp + 1) % 4;
      }
    } else if (dp == 0 && (nx < 0 || ady[nx][ny] == '0')) {
      if (cp == 3)
        cp = 1;
      else {
        cp = 0;
        dp = (dp + 1) % 4;
      }
    } else {
      x = nx;
      y = ny;
      c = ady[nx][ny];
    }
  }
  cout << c << endl;
  return 0;
}
