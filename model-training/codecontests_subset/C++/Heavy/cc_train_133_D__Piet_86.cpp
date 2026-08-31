#include <bits/stdc++.h>
using namespace std;
vector<int> move(const vector<string> &f, int bpx, int bpy, int cp, int dp) {
  int dx, dy;
  switch (cp) {
    case 0:
      dx = 1;
      dy = 0;
      break;
    case 1:
      dx = 0;
      dy = 1;
      break;
    case 2:
      dx = -1;
      dy = 0;
      break;
    case 3:
      dx = 0;
      dy = -1;
      break;
  }
  while (1) {
    int nx = bpx + dx;
    int ny = bpy + dy;
    if (nx < 0 || f[0].size() <= nx || ny < 0 || f.size() <= ny ||
        f[ny][nx] != f[bpy][bpx]) {
      break;
    }
    bpx = nx;
    bpy = ny;
  }
  int ddx, ddy;
  switch (dp) {
    case 0:
      ddx = dy;
      ddy = -dx;
      break;
    case 1:
      ddx = -dy;
      ddy = dx;
      break;
  }
  while (1) {
    int nx = bpx + ddx;
    int ny = bpy + ddy;
    if (nx < 0 || f[0].size() <= nx || ny < 0 || f.size() <= ny ||
        f[ny][nx] != f[bpy][bpx]) {
      break;
    }
    bpx = nx;
    bpy = ny;
  }
  int nx = bpx + dx;
  int ny = bpy + dy;
  if (nx < 0 || f[0].size() <= nx || ny < 0 || f.size() <= ny ||
      f[ny][nx] == '0') {
    if (dp == 1) {
      cp = (cp + 1) % 4;
    }
    dp = (dp + 1) % 2;
  } else {
    bpx = nx;
    bpy = ny;
  }
  vector<int> v(4);
  v[0] = bpx;
  v[1] = bpy;
  v[2] = cp;
  v[3] = dp;
  return v;
}
int solve(const vector<string> &f, int n, int bpx, int bpy, int cp, int dp) {
  static map<vector<int>, int> before;
  vector<int> v(4);
  v[0] = bpx;
  v[1] = bpy;
  v[2] = cp;
  v[3] = dp;
  if (before.find(v) != before.end()) {
    int sub = before[v] - n;
    n %= sub;
  }
  before[v] = n;
  if (n == 0) return f[bpy][bpx] - '0';
  vector<int> next = move(f, bpx, bpy, cp, dp);
  return solve(f, n - 1, next[0], next[1], next[2], next[3]);
}
int main(int argc, char *argv[]) {
  int m, n;
  cin >> m >> n;
  vector<string> vs(m);
  for (int i = 0; i < m; i++) {
    cin >> vs[i];
  }
  int bpx = 0;
  int bpy = 0;
  int cp = 0;
  int dp = 0;
  int res = solve(vs, n, bpx, bpy, cp, dp);
  cout << res << endl;
  return 0;
}
