#include <bits/stdc++.h>
using namespace std;
char a[407][407];
char b[407][407];
bitset<407> pos[407][26];
bitset<407> good[407];
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; i++) {
    scanf("%s", a[i]);
    for (int j = 0; j < m; j++) {
      pos[i][a[i][j] - 'a'][j] = true;
      good[i][j] = true;
    }
  }
  int aa, bb;
  scanf("%d %d", &aa, &bb);
  for (int i = 0; i < aa; i++) {
    scanf("%s", b[i]);
    for (int j = 0; j < bb; j++) {
      if (b[i][j] == '?') continue;
      for (int k = 0; k < n; k++) {
        bitset<407> gg = pos[k][b[i][j] - 'a'];
        int ii = i % n, jj = j % m;
        gg = (gg >> jj) | (gg << (m - jj));
        good[(k + n - ii) % n] &= gg;
      }
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (!good[i][j]) {
        printf("0");
      } else {
        printf("1");
      }
    }
    printf("\n");
  }
}
