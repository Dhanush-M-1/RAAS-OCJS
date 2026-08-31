#include <bits/stdc++.h>
using namespace std;
const int maxn = 55;
int n, m;
int t;
string ss[maxn];
bool mark[maxn][maxn][8];
int d[maxn][maxn][8];
int cp, bpx, bpy, dp;
int it;
bool isvalid(int i, int j) {
  return i >= 0 && j >= 0 && i < n && j < m && ss[i][j] != '0';
}
void next(int& nx, int& ny, int di) {
  if (di == 0) nx--;
  if (di == 1) ny++;
  if (di == 2) nx++;
  if (di == 3) ny--;
}
bool bo;
void mov() {
  if (t == it) {
    cout << ss[bpx][bpy] << endl;
    exit(0);
  }
  int nx, ny;
  while (true) {
    nx = bpx;
    ny = bpy;
    next(nx, ny, dp);
    if (!isvalid(nx, ny) || ss[nx][ny] != ss[bpx][bpy]) break;
    bpx = nx;
    bpy = ny;
  }
  while (true) {
    nx = bpx;
    ny = bpy;
    next(nx, ny, (4 + dp + (cp * 2 - 1)) % 4);
    if (!isvalid(nx, ny) || ss[nx][ny] != ss[bpx][bpy]) break;
    bpx = nx;
    bpy = ny;
  }
  if (mark[bpx][bpy][cp * 4 + dp] && !bo) {
    int tim = d[bpx][bpy][cp * 4 + dp];
    int ans = (t - tim) % (it - tim);
    it = 0;
    t = ans;
    if (t == 0) {
      cout << ss[bpx][bpy] << endl;
      exit(0);
    }
    bo = true;
  }
  mark[bpx][bpy][cp * 4 + dp] = true;
  d[bpx][bpy][cp * 4 + dp] = it++;
  nx = bpx;
  ny = bpy;
  next(nx, ny, dp);
  if (isvalid(nx, ny)) {
    bpx = nx;
    bpy = ny;
  } else {
    if (cp) dp = (dp + 1) % 4;
    cp = !cp;
  }
}
int main() {
  ios::sync_with_stdio(false);
  dp = 1;
  cin >> n >> t;
  for (int i = 0; i < n; ++i) cin >> ss[i];
  m = ss[0].size();
  while (mov(), true)
    ;
  return 0;
}
