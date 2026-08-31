#include <bits/stdc++.h>
using namespace std;
int n, baki, m;
string s[100];
int cnter, mni, mxi, mnj, mxj;
struct str {
  int mni, mxi, mnj, mxj;
};
int mark[100][100];
str b[100100];
int di[] = {0, 1, 0, -1};
int dj[] = {1, 0, -1, 0};
void dfs(int i, int j, int c) {
  if (i >= n || j >= m || i < 0 || j < 0 || mark[i][j] || s[i][j] != c) return;
  mark[i][j] = cnter;
  mxi = max(mxi, i);
  mni = min(mni, i);
  mxj = max(mxj, j);
  mnj = min(mnj, j);
  for (int k = 0; k < 4; k++) {
    int ni = i + di[k], nj = j + dj[k];
    dfs(ni, nj, c);
  }
}
void change(int curMark, pair<int, int> cur, int &i, int &j) {
  if (cur.first == 0 && cur.second == 0 || cur.first == 3 && cur.second == 1) {
    i = b[curMark].mni;
    j = b[curMark].mxj;
  } else if (cur.first == 0 && cur.second == 1 ||
             cur.first == 1 && cur.second == 0) {
    i = b[curMark].mxi;
    j = b[curMark].mxj;
  } else if (cur.first == 2 && cur.second == 0 ||
             cur.first == 1 && cur.second == 1) {
    i = b[curMark].mxi;
    j = b[curMark].mnj;
  } else {
    i = b[curMark].mni;
    j = b[curMark].mnj;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n >> baki;
  for (int i = 0; i < n; i++) cin >> s[i];
  m = s[0].size();
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++)
      if (!mark[i][j]) {
        mni = 1e9;
        mxi = 0;
        mnj = 1e9;
        mxj = 0;
        cnter++;
        dfs(i, j, s[i][j]);
        b[cnter].mnj = mnj;
        b[cnter].mxj = mxj;
        b[cnter].mni = mni;
        b[cnter].mxi = mxi;
      }
  }
  int i = 0, j = 0;
  pair<int, int> cur(0, 0);
  int curMark = mark[0][0];
  change(curMark, cur, i, j);
  while (baki--) {
    int ni = i + di[cur.first];
    int nj = j + dj[cur.first];
    if (ni >= n || nj >= m || ni < 0 || nj < 0 || s[ni][nj] == '0') {
      cur.second++;
      cur.second %= 2;
      if (cur.second == 0) cur.first++;
      (cur.first) %= 4;
      int curMark = mark[i][j];
      change(curMark, cur, i, j);
    } else {
      int curMark = mark[ni][nj];
      change(curMark, cur, i, j);
    }
  }
  cout << s[i][j] << '\n';
}
