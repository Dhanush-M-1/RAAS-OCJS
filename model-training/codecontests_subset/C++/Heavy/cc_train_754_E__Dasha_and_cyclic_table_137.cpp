#include <bits/stdc++.h>
using namespace std;
char pattern[405][405], grid[405][405];
bitset<405> ans[405], possui[26][405];
int n, m;
bitset<405>* shift(bitset<405>* possui, int i, int j) {
  bitset<405>* ret = new bitset<405>[405];
  j %= m;
  for (int k = 0; k < n; k++) {
    ret[k] = possui[(k + i) % n];
    ret[k] = (ret[k] << j) | (ret[k] >> (m - j));
  }
  return ret;
}
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; i++) scanf("%s", grid[i]);
  int n2, m2;
  scanf("%d %d", &n2, &m2);
  for (int i = 0; i < n2; i++) scanf("%s", pattern[i]);
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
      for (int c = 0; c < 26; c++) ans[i][405 - 1 - j] = 1;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++) possui[grid[i][j] - 'a'][i][405 - 1 - j] = true;
  for (int i = 0; i < n2; i++) {
    for (int j = 0; j < m2; j++) {
      int c = pattern[i][j];
      if (c == '?') continue;
      auto shifted = shift(possui[c - 'a'], i, j);
      for (int i = 0; i < n; i++) ans[i] &= shifted[i];
      delete shifted;
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) printf("%d", ans[i][405 - 1 - j] == true);
    printf("\n");
  }
  return 0;
}
