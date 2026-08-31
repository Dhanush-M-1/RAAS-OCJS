#include <bits/stdc++.h>
using namespace std;
bool kmp(int a, int b) { return a < b; }
int main() {
  int n, m;
  int x = 0;
  int y = 0;
  int z = 0;
  cin >> n;
  int a[n];
  int d[n][n];
  int c[n];
  int an[100003];
  int k = 0;
  int p = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    c[i] = 1;
  }
  cin >> m;
  int b[m];
  int f[m];
  for (int i = 0; i < m; i++) {
    cin >> b[i] >> f[i];
  }
  for (int i = 0; i < n; i++) {
    p = 0;
    k = 0;
    for (int j = 0; j < n; j++) {
      if (a[j] > p && c[j] == 1) {
        p = a[j];
        x = j;
      }
    }
    c[x] = 0;
    for (int j = 0; j < x; j++) {
      if (c[j] == 0) {
        k++;
      }
    }
    for (int j = 0; j < i + 1; j++) {
      if (j < k) {
        d[i][j] = d[i - 1][j];
      } else if (j == k) {
        d[i][j] = p;
      } else {
        d[i][j] = d[i - 1][j - 1];
      }
    }
  }
  for (int i = 0; i < m; i++) {
    cout << d[b[i] - 1][f[i] - 1] << endl;
  }
  return 0;
}
