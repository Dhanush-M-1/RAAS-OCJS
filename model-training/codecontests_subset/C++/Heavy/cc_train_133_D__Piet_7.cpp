#include <bits/stdc++.h>
struct ip_t {
  int x, y;
  int dir1, dir2;
} ip;
char in[80][80];
int m, n, w;
int tops[80][80];
int lefts[80][80];
int rights[80][80];
int bottoms[80][80];
int ndir1[4][4] = {{4, 1, 4, 0}, {1, 4, 2, 4}, {4, 2, 4, 3}, {0, 4, 3, 4}};
int ndir2[4][4] = {{4, 0, 4, 1}, {2, 4, 1, 4}, {4, 3, 4, 2}, {3, 4, 0, 4}};
bool valid(int x, int y) {
  if (x < 0 || x >= w) return false;
  if (y < 0 || y >= m) return false;
  if (in[y][x] == 0) return false;
  return true;
}
int step() {
  if (ip.dir2 == 0) ip.y = tops[ip.y][ip.x];
  if (ip.dir2 == 1) ip.x = rights[ip.y][ip.x];
  if (ip.dir2 == 2) ip.y = bottoms[ip.y][ip.x];
  if (ip.dir2 == 3) ip.x = lefts[ip.y][ip.x];
  int cx = ip.x, cy = ip.y;
  if (ip.dir1 == 0) {
    ip.y = tops[ip.y][ip.x];
    cy = ip.y - 1;
  }
  if (ip.dir1 == 1) {
    ip.x = rights[ip.y][ip.x];
    cx = ip.x + 1;
  }
  if (ip.dir1 == 2) {
    ip.y = bottoms[ip.y][ip.x];
    cy = ip.y + 1;
  }
  if (ip.dir1 == 3) {
    ip.x = lefts[ip.y][ip.x];
    cx = ip.x - 1;
  }
  if (valid(cx, cy)) {
    ip.x = cx;
    ip.y = cy;
    return 1;
  } else {
    int d1 = ip.dir1, d2 = ip.dir2;
    ip.dir1 = ndir1[d1][d2];
    ip.dir2 = ndir2[d1][d2];
    return 0;
  }
}
int main() {
  scanf("%d%d", &m, &n);
  char asdf;
  scanf("%c", &asdf);
  for (int i = 0; i < (m); ++i) {
    gets(in[i]);
  }
  w = strlen(in[0]);
  for (int i = 0; i < (m); ++i)
    for (int j = 0; j < (w); ++j) in[i][j] -= '0';
  for (int i = 0; i < (80); ++i) {
    tops[0][i] = 0;
    lefts[i][0] = 0;
    rights[i][w - 1] = w - 1;
    bottoms[m - 1][i] = m - 1;
  }
  for (int x = 0; x < (w); ++x) {
    for (int i = (m - 2); i >= (0); --i) {
      if (in[i][x] == in[i + 1][x])
        bottoms[i][x] = bottoms[i + 1][x];
      else
        bottoms[i][x] = i;
    }
    for (int i = (1); i <= (m - 1); ++i) {
      if (in[i][x] == in[i - 1][x])
        tops[i][x] = tops[i - 1][x];
      else
        tops[i][x] = i;
    }
  }
  for (int y = 0; y < (m); ++y) {
    for (int i = (w - 2); i >= (0); --i) {
      if (in[y][i] == in[y][i + 1])
        rights[y][i] = rights[y][i + 1];
      else
        rights[y][i] = i;
    }
    for (int i = (1); i <= (w - 1); ++i) {
      if (in[y][i] == in[y][i - 1])
        lefts[y][i] = lefts[y][i - 1];
      else
        lefts[y][i] = i;
    }
  }
  ip.x = ip.y = 0;
  ip.dir1 = 1;
  ip.dir2 = 0;
  while (n) {
    step();
    --n;
  }
  printf("%d\n", (int)in[ip.y][ip.x]);
  return 0;
}
