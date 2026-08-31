#include <bits/stdc++.h>
using namespace std;
struct pkt {
  int x, y;
};
const int INF = 1000000000;
int main() {
  ios_base::sync_with_stdio(0);
  int n, m, k;
  cin >> n >> k;
  vector<string> a(n);
  for (int i = 0; i < n; ++i) cin >> a[i];
  m = a[0].size();
  pkt f[50][50][4][2];
  vector<vector<bool> > odw(n, vector<bool>(m, false));
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      if (!odw[i][j] && a[i][j] != '0') {
        int minix = i, maxix = i;
        int miniy = j, maxiy = j;
        while (maxix < n && a[maxix][j] == a[i][j]) ++maxix;
        --maxix;
        while (maxiy < m && a[i][maxiy] == a[i][j]) ++maxiy;
        --maxiy;
        for (int l = minix; l <= maxix; ++l) {
          for (int o = miniy; o <= maxiy; ++o) {
            odw[l][o] = true;
            f[l][o][0][0] = {minix - 1, maxiy};
            f[l][o][0][1] = {minix - 1, miniy};
            f[l][o][1][0] = {maxix, maxiy + 1};
            f[l][o][1][1] = {minix, maxiy + 1};
            f[l][o][2][0] = {maxix + 1, miniy};
            f[l][o][2][1] = {maxix + 1, maxiy};
            f[l][o][3][0] = {minix, miniy - 1};
            f[l][o][3][1] = {maxix, miniy - 1};
          }
        }
      }
    }
  }
  pkt akt = {0, 0};
  int kier1 = 1, kier2 = 1;
  for (int i = 0; i < k; ++i) {
    pkt nast = f[akt.x][akt.y][kier1][kier2];
    if (nast.x >= 0 && nast.x < n && nast.y >= 0 && nast.y < m &&
        a[nast.x][nast.y] != '0')
      akt = nast;
    else {
      if (kier2 == 1)
        kier2 = 0;
      else {
        kier2 = 1;
        kier1 = (kier1 + 1) % 4;
      }
    }
  }
  cout << a[akt.x][akt.y];
  return 0;
}
