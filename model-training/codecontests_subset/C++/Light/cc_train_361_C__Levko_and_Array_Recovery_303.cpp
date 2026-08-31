#include <bits/stdc++.h>
using namespace std;
long long int v[5001];
long long int vv[5001];
int c[4][5001];
int main() {
  int n, k;
  cin >> n >> k;
  for (int i = 0; i < k; i++) {
    int in;
    for (int j = 0; j < 4; j++) {
      cin >> in;
      c[j][i] = in;
      if (j == 1 || j == 2) c[j][i]--;
    }
  }
  for (int i = 0; i < n; i++) v[i] = 1 << 29;
  for (int i = k - 1; i >= 0; i--) {
    if (c[0][i] == 1) {
      for (int j = c[1][i]; j <= c[2][i]; j++) v[j] -= c[3][i];
    } else {
      for (int j = c[1][i]; j <= c[2][i]; j++) {
        if (v[j] > c[3][i]) v[j] = c[3][i];
      }
    }
  }
  for (int i = 0; i < n; i++) vv[i] = v[i];
  for (int i = 0; i < k; i++) {
    if (c[0][i] == 1) {
      for (int j = c[1][i]; j <= c[2][i]; j++) vv[j] += c[3][i];
    } else {
      bool flg = false;
      for (int j = c[1][i]; j <= c[2][i]; j++) {
        if (vv[j] >= c[3][i]) {
          flg = true;
          break;
        }
      }
      if (flg == false) {
        cout << "NO" << endl;
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  for (int i = 0; i < n; i++) {
    cout << v[i];
    if (i == n - 1)
      cout << "\n";
    else
      cout << " ";
  }
  return 0;
}
