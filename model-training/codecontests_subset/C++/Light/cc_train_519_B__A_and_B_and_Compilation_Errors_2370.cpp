#include <bits/stdc++.h>
using namespace std;
void file() {}
const int MN = 1e9 + 1e2;
const int MW = 1e3 + 5;
const int OO = 1e9 + 5;
int main() {
  file();
  map<int, int> ar[3];
  int v[3][(int)(1e5 + 100)];
  int n, ms[3];
  scanf("%d", &n);
  for (int i = 0; i < 3; ++i)
    for (int j = 0; j < n - i and scanf("%d", &v[i][j]); ++j) ar[i][v[i][j]]++;
  for (int i = 0; i < 2; ++i)
    for (int j = 0; j < n - i; ++j)
      if (ar[i][v[i][j]] != ar[i + 1][v[i][j]]) ms[i] = v[i][j];
  printf("%d", ms[0]), printf("\n"), printf("%d", ms[1]);
  return 0;
}
