#include <bits/stdc++.h>
using namespace std;
const int MAXN = 400;
char f[MAXN + 1][MAXN + 1];
bitset<400> pos[400][26], good[400];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cin >> f[i][j];
      pos[i][f[i][j] - 'a'][j] = true;
      good[i][j] = true;
    }
  }
  int r, c;
  cin >> r >> c;
  for (int i = 0; i < r; i++) {
    string s;
    cin >> s;
    for (int j = 0; j < c; j++) {
      if (s[j] == '?') continue;
      for (int k = 0; k < n; k++) {
        bitset<400> g = pos[k][s[j] - 'a'];
        g = (g >> (j % m)) | (g << ((m - j + MAXN * m) % m));
        good[(k - i + MAXN * n) % n] &= g;
      }
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (good[i][j])
        printf("1");
      else
        printf("0");
    }
    printf("\n");
  }
  return 0;
}
