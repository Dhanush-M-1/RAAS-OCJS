#include <bits/stdc++.h>
using namespace std;
bool flag;
int t, n[1010], m[1010];
const int MAXN = 1e3 + 10;
int a[MAXN][MAXN], b[MAXN][MAXN];
int main() {
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> n[i] >> m[i];
    for (int j = 0; j < n[i]; j++) cin >> a[i][j];
    for (int j = 0; j < m[i]; j++) cin >> b[i][j];
  }
  for (int i = 0; i < t; i++) {
    flag = 0;
    for (int j = 0; j < n[i]; j++) {
      for (int k = 0; k < m[i]; k++) {
        if (a[i][j] == b[i][k]) {
          cout << "YES" << endl;
          cout << 1 << " " << a[i][j] << endl;
          flag = 1;
          break;
        }
      }
      if (flag == 1) break;
    }
    if (flag == 0) cout << "NO" << endl;
  }
  return 0;
}
