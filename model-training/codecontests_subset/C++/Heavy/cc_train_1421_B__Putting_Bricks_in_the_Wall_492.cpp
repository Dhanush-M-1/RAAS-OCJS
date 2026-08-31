#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const int mod = 1e9 + 7;
const int maxn = 205;
int n, ans, T;
char a[maxn][maxn];
int main() {
  cin >> T;
  while (T--) {
    cin >> n;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) cin >> a[i][j];
    }
    int p1 = a[1][2] - '0', p2 = a[2][1] - '0', q1 = a[n][n - 1] - '0',
        q2 = a[n - 1][n] - '0';
    int cnt = p1 + p2 + q1 + q2;
    if (cnt == 0 || cnt == 4) {
      cout << 2 << endl;
      cout << "1 2" << endl;
      cout << "2 1" << endl;
    } else if (cnt == 1 || cnt == 3) {
      cout << 1 << endl;
      int f = 1;
      if (cnt == 3) f = 0;
      if (p1 == f) cout << "2 1" << endl;
      if (p2 == f) cout << "1 2" << endl;
      if (q1 == f) cout << n - 1 << ' ' << n << endl;
      if (q2 == f) cout << n << ' ' << n - 1 << endl;
    } else {
      if (p1 == p2)
        cout << 0 << endl;
      else {
        cout << 2 << endl;
        if (p1 == 0) cout << "1 2" << endl;
        if (p2 == 0) cout << "2 1" << endl;
        if (q1 == 1) cout << n << ' ' << n - 1 << endl;
        if (q2 == 1) cout << n - 1 << ' ' << n << endl;
      }
    }
  }
  return 0;
}
