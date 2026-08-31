#include <bits/stdc++.h>
using namespace std;
long long n, m, i, j, k, l;
long long a[1006], fix[1005], b[1003][1003], c[1003][1003], sh[3000], v[1005];
long long x, y, ra, r;
void go(int x) {
  fix[x] = 1;
  r++;
  int l;
  for (l = 1; l <= n; l++) {
    if (fix[l] == 0 && b[x][l] == 1) go(l);
  }
}
void go1(int y) {
  fix[y] = 1;
  r++;
  int l;
  for (l = 1; l <= n; l++) {
    if (fix[l] == 0 && b[y][l] == 1 && c[l][y] == 1) go(l);
  }
}
int main() {
  cin >> n >> x;
  for (i = 1; i <= n; i++) {
    cin >> a[i];
    b[i][a[i]] = 1;
    c[a[i]][i] = 1;
    b[a[i]][i] = 1;
  }
  r = 0;
  go1(x);
  y = r;
  go(x);
  for (i = 1; i <= n; i++)
    if (fix[i] == 0) {
      r = 0;
      go(i);
      ra++;
      v[ra] = r;
    }
  sh[0] = 1;
  for (i = 1; i <= ra; i++) {
    for (j = n; j >= 0; j--)
      if (sh[j] == 1) sh[j + v[i]] = 1;
  }
  for (i = 0; i <= n; i++)
    if (sh[i] == 1) cout << i + y << endl;
}
