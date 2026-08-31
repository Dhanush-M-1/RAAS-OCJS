#include <bits/stdc++.h>
using namespace std;
const int MAXN = 405, B = 60;
char c[MAXN][MAXN], mat[MAXN][MAXN];
long long red[MAXN][MAXN][7], bit[MAXN][26][7];
void setbit(int x, int y, int s) { bit[x][s][y / B] |= 1LL << (y % B); }
bool calc(int qr, int j, int i) {
  if ((1LL << (i % B)) & red[qr][j][i / B]) return true;
  return false;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < m; ++j) {
      cin >> c[i][j];
    }
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < m; ++j)
      for (int s = 0; s < 26; ++s) {
        if (c[i][j] - 'a' == s) setbit(j, i, s);
      }
  int r, s;
  cin >> r >> s;
  for (int i = 0; i < r; ++i)
    for (int j = 0; j < s; ++j) {
      cin >> mat[i][j];
    }
  for (int redak = 0; redak < r; ++redak)
    for (int j = 0; j < m; ++j) {
      for (int i = 0; i < 7; ++i) red[redak][j][i] = (long long)(1LL << 60) - 1;
      for (int stupac = 0; stupac < s; ++stupac) {
        if (mat[redak][stupac] == '?') continue;
        for (int i = 0; i < 7; ++i) {
          red[redak][j][i] &=
              bit[(j + stupac) % m][mat[redak][stupac] - 'a'][i];
        }
      }
    }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      bool mogu = true;
      for (int redak = 0; redak < r; ++redak) {
        mogu &= calc(redak, j, (i + redak) % n);
      }
      cout << mogu;
    }
    cout << endl;
  }
}
