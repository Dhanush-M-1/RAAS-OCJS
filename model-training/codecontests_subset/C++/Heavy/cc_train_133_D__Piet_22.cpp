#include <bits/stdc++.h>
using namespace std;
int n, m, p;
int col[50][50];
int mat[50][50][8];
void leggi() {
  cin >> n >> p;
  string s;
  for (int i = 0; i < n; i += 1) {
    cin >> s;
    m = s.size();
    for (int j = 0; j < m; j += 1) {
      col[i][j] = s[j] - '0';
    }
  }
}
void elabora() {
  for (int i = 0; i < n; i += 1) {
    for (int j = 0; j < m; j += 1) {
      if (col[i][j] != 0 && col[i][j] < 10) {
        int h = 0;
        for (int k = 0; i + k < n && col[i + k][j] == col[i][j]; k += 1) {
          h += 1;
        }
        int w = 0;
        for (int k = 0; j + k < m && col[i][j + k] == col[i][j]; k += 1) {
          w += 1;
        }
        for (int a = i; a < i + h; a += 1) {
          for (int b = j; b < j + w; b += 1) {
            mat[a][b][0] = (((i) << 8) + (j + w));
            mat[a][b][1] = (((i + h - 1) << 8) + (j + w));
            mat[a][b][2] = (((i + h) << 8) + (j + w - 1));
            mat[a][b][3] = (((i + h) << 8) + (j));
            mat[a][b][4] = (((i + h - 1) << 8) + (j - 1));
            mat[a][b][5] = (((i) << 8) + (j - 1));
            mat[a][b][6] = (((i - 1) << 8) + (j));
            mat[a][b][7] = (((i - 1) << 8) + (j + w - 1));
            col[a][b] += 10;
          }
        }
      }
    }
  }
  int old_i = 0;
  int old_j = 0;
  int dir = 0;
  for (int i = 0; i < p; i += 1) {
    int new_i = ((mat[old_i][old_j][dir]) >> 8);
    int new_j = ((mat[old_i][old_j][dir]) % 256);
    if (0 <= new_i && new_i < n && 0 <= new_j && new_j < m &&
        col[new_i][new_j] != 0) {
      old_i = new_i;
      old_j = new_j;
    } else {
      dir += 1;
      dir %= 8;
    }
  }
  cout << col[old_i][old_j] - 10 << endl;
}
int main() {
  leggi();
  elabora();
}
