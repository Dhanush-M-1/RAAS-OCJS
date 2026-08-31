#include <bits/stdc++.h>
using namespace std;
int n, v[10];
bool mat[5205][5205], ok = 0;
char c;
void f() {
  if (c == '0') {
    v[1] = 0;
    v[2] = 0;
    v[3] = 0;
    v[4] = 0;
  }
  if (c == '1') {
    v[1] = 0;
    v[2] = 0;
    v[3] = 0;
    v[4] = 1;
  }
  if (c == '2') {
    v[1] = 0;
    v[2] = 0;
    v[3] = 1;
    v[4] = 0;
  }
  if (c == '3') {
    v[1] = 0;
    v[2] = 0;
    v[3] = 1;
    v[4] = 1;
  }
  if (c == '4') {
    v[1] = 0;
    v[2] = 1;
    v[3] = 0;
    v[4] = 0;
  }
  if (c == '5') {
    v[1] = 0;
    v[2] = 1;
    v[3] = 0;
    v[4] = 1;
  }
  if (c == '6') {
    v[1] = 0;
    v[2] = 1;
    v[3] = 1;
    v[4] = 0;
  }
  if (c == '7') {
    v[1] = 0;
    v[2] = 1;
    v[3] = 1;
    v[4] = 1;
  }
  if (c == '8') {
    v[1] = 1;
    v[2] = 0;
    v[3] = 0;
    v[4] = 0;
  }
  if (c == '9') {
    v[1] = 1;
    v[2] = 0;
    v[3] = 0;
    v[4] = 1;
  }
  if (c == 'A') {
    v[1] = 1;
    v[2] = 0;
    v[3] = 1;
    v[4] = 0;
  }
  if (c == 'B') {
    v[1] = 1;
    v[2] = 0;
    v[3] = 1;
    v[4] = 1;
  }
  if (c == 'C') {
    v[1] = 1;
    v[2] = 1;
    v[3] = 0;
    v[4] = 0;
  }
  if (c == 'D') {
    v[1] = 1;
    v[2] = 1;
    v[3] = 0;
    v[4] = 1;
  }
  if (c == 'E') {
    v[1] = 1;
    v[2] = 1;
    v[3] = 1;
    v[4] = 0;
  }
  if (c == 'F') {
    v[1] = 1;
    v[2] = 1;
    v[3] = 1;
    v[4] = 1;
  }
}
bool verif(int x) {
  for (int i = 1; i <= n; i += x) {
    for (int j = 1; j <= n; j += x) {
      for (int p = i; p <= i + x - 1; p++)
        for (int q = j; q <= j + x - 1; q++) {
          if (mat[i][j] != mat[p][q]) return 0;
        }
    }
  }
  return 1;
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n / 4; j++) {
      cin >> c;
      f();
      mat[i][4 * (j - 1) + 1] = v[1];
      mat[i][4 * (j - 1) + 2] = v[2];
      mat[i][4 * (j - 1) + 3] = v[3];
      mat[i][4 * (j - 1) + 4] = v[4];
    }
  }
  for (int k = n; k >= 2; k--) {
    if (n % k == 0) {
      if (verif(k)) {
        cout << k;
        k = 1;
        ok = 1;
      }
    }
  }
  if (ok == 0) cout << 1;
  return 0;
}
