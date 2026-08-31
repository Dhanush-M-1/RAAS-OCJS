#include <bits/stdc++.h>
using namespace std;
bool calced[60][60][4][2];
bool possible[60][60][4][2];
pair<int, int> Go[60][60][4][2];
int field[60][60];
int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};
int main() {
  memset(calced, 0, sizeof(calced));
  memset(possible, 0, sizeof(possible));
  int M, N;
  string s;
  scanf("%d%d", &M, &N);
  for (int i = 0; i < M; i++) {
    cin >> s;
    field[i + 1][0] = 0;
    field[i + 1][s.size() + 1] = 0;
    for (int j = 0; j < s.size(); j++) field[i + 1][j + 1] = s[j] - '0';
  }
  for (int i = 0; i < 60; i++) field[0][i] = field[M + 1][i] = 0;
  pair<int, int> current = make_pair(1, 1);
  int dp = 0;
  int cp = 0;
  for (int z = 0; z < N; z++) {
    pair<int, int> temp = current;
    if (calced[current.first][current.second][dp][cp]) {
      if (possible[current.first][current.second][dp][cp]) {
        current = Go[current.first][current.second][dp][cp];
        continue;
      } else {
        if (cp == 1) {
          cp = 0;
          dp = (dp + 1) % 4;
        } else
          cp = 1;
        continue;
      }
    }
    while (field[current.first + dx[dp]][current.second + dy[dp]] ==
           field[temp.first][temp.second]) {
      current.first += dx[dp];
      current.second += dy[dp];
    }
    int ddx, ddy;
    if (dp == 0)
      ddx = -1, ddy = 0;
    else if (dp == 1)
      ddx = 0, ddy = 1;
    else if (dp == 2)
      ddx = 1, ddy = 0;
    else
      ddx = 0, ddy = -1;
    if (cp == 1) {
      ddx *= -1;
      ddy *= -1;
    }
    while (field[current.first + ddx][current.second + ddy] ==
           field[temp.first][temp.second]) {
      current.first += ddx;
      current.second += ddy;
    }
    calced[temp.first][temp.second][dp][cp] = true;
    if (field[current.first + dx[dp]][current.second + dy[dp]] == 0) {
      possible[temp.first][temp.second][dp][cp] = false;
      if (cp == 1) {
        cp = 0;
        dp = (dp + 1) % 4;
      } else
        cp = 1;
      continue;
    } else {
      possible[temp.first][temp.second][dp][cp] = true;
      current.first += dx[dp];
      current.second += dy[dp];
      Go[temp.first][temp.second][dp][cp] = current;
      continue;
    }
  }
  printf("%d", field[current.first][current.second]);
  return 0;
}
