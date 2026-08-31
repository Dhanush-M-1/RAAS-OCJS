#include <bits/stdc++.h>
using namespace std;
int dc[] = {1, 0, -1, 0};
int dr[] = {0, 1, 0, -1};
string b[55];
int *nxt[4][55];
int main() {
  int m, n;
  cin >> m >> n;
  for (int i = 0; i < m; i++) {
    cin >> b[i];
    nxt[0][i] = new int[b[i].size()];
    nxt[1][i] = new int[b[i].size()];
    nxt[2][i] = new int[b[i].size()];
    nxt[3][i] = new int[b[i].size()];
  }
  for (int i = 0; i < m; i++)
    for (int j = b[i].size() - 1; j >= 0; j--)
      nxt[0][i][j] = (j == b[i].size() - 1)
                         ? j
                         : ((b[i][j] != b[i][j + 1]) ? j : nxt[0][i][j + 1]);
  for (int i = 0; i < m; i++)
    for (int j = b[i].size() - 1; j >= 0; j--)
      nxt[3][i][j] =
          (i == 0) ? i : ((b[i][j] != b[i - 1][j]) ? i : nxt[3][i - 1][j]);
  for (int i = 0; i < m; i++)
    for (int j = 0; j < b[i].size(); j++)
      nxt[2][i][j] =
          (j == 0) ? j : ((b[i][j] != b[i][j - 1]) ? j : nxt[2][i][j - 1]);
  for (int i = m - 1; i >= 0; i--)
    for (int j = b[i].size() - 1; j >= 0; j--)
      nxt[1][i][j] =
          (i == m - 1) ? i : ((b[i][j] != b[i + 1][j]) ? i : nxt[1][i + 1][j]);
  int r = 0, c = 0;
  int dp = 0;
  int cp = -1;
  for (int step = 0; step < n; step++) {
    if (dp == 0 || dp == 2) {
      c = nxt[dp][r][c];
      r = nxt[(dp + cp + 4) % 4][r][c];
    } else {
      r = nxt[dp][r][c];
      c = nxt[(dp + cp + 4) % 4][r][c];
    }
    int nextr = r + dr[dp];
    int nextc = c + dc[dp];
    if (nextr >= 0 && nextr < m && nextc >= 0 && nextc < b[0].size() &&
        b[nextr][nextc] != '0')
      r = nextr, c = nextc;
    else {
      if (cp == -1)
        cp = 1;
      else
        cp = -1, dp = (dp + 1) % 4;
    }
  }
  cout << b[r][c] << endl;
  return 0;
}
