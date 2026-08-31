#include <bits/stdc++.h>
using namespace std;
const int di[4] = {-1, 0, 1, 0};
const int dj[4] = {0, 1, 0, -1};
const int dxi[4][2] = {{0, 0}, {-1, 1}, {0, 0}, {1, -1}};
const int dxj[4][2] = {{-1, 1}, {0, 0}, {1, -1}, {0, 0}};
int Set[100][100], n, m, k, cc, u[3000][5][3];
string second[100];
void Dfs(int i, int j) {
  if (Set[i][j]) return;
  Set[i][j] = cc;
  for (int k = 0; k < 4; ++k) {
    int ii = i + di[k], jj = j + dj[k];
    if (!(0 <= ii && ii < n && 0 <= jj && jj < m)) continue;
    if (second[ii][jj] != second[i][j]) continue;
    Dfs(ii, jj);
  }
}
int main() {
  cin >> n >> k;
  for (int i = 0; i < n; ++i) {
    cin >> second[i];
  }
  m = second[0].size();
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < m; ++j)
      if (second[i][j] != '0' && !Set[i][j]) {
        cc++;
        Dfs(i, j);
      }
  int bp = Set[0][0];
  int dp = 1;
  int cp = 0;
  int i = 0, j = 0;
  int len = 0;
  string path = "";
  while (!u[bp][dp][cp]) {
    u[bp][dp][cp] = ++len;
    char cur = second[i][j];
    while (true) {
      int ii = i + di[dp];
      int jj = j + dj[dp];
      if (!(0 <= ii && ii < n && 0 <= jj && jj < m)) break;
      if (second[ii][jj] != cur) break;
      i = ii;
      j = jj;
    }
    while (true) {
      int ii = i + dxi[dp][cp];
      int jj = j + dxj[dp][cp];
      if (!(0 <= ii && ii < n && 0 <= jj && jj < m)) break;
      if (second[ii][jj] != cur) break;
      i = ii;
      j = jj;
    }
    int ii = i + di[dp];
    int jj = j + dj[dp];
    if ((0 <= ii && ii < n && 0 <= jj && jj < m && second[ii][jj] != '0')) {
      i = ii;
      j = jj;
      bp = Set[i][j];
    } else {
      if (cp == 0)
        cp = 1;
      else {
        cp = 0;
        dp = (dp + 1) % 4;
      }
    }
    path += second[i][j];
  }
  int cur = 0;
  for (int i = 0; i < k - 1; ++i) {
    cur++;
    if (cur == path.size()) cur = u[bp][dp][cp] - 1;
  }
  cout << path[cur];
  return 0;
}
