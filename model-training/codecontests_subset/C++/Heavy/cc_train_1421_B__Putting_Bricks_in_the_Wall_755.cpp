#include <bits/stdc++.h>
using namespace std;
int read() {
  int re = 0;
  char c = getchar();
  while (c < '0' || c > '9') c = getchar();
  while (c >= '0' && c <= '9') {
    re = re * 10 + c - '0';
    c = getchar();
  }
  return re;
}
int t;
string mat[300];
int vis[300][300], chg[300][300];
int main() {
  cin >> t;
  while (t--) {
    int n = read();
    for (int i = 0; i < n; ++i) {
      cin >> mat[i];
    }
    int n1 = mat[0][1] - '0';
    int n2 = mat[1][0] - '0';
    int n3 = mat[n - 1][n - 2] - '0';
    int n4 = mat[n - 2][n - 1] - '0';
    if (n1 != n2 && n3 != n4) {
      cout << 2 << endl;
      if (n1 != 1) {
        cout << 1 << ' ' << 2 << endl;
      } else
        cout << 2 << ' ' << 1 << endl;
      if (n3 != 0) {
        printf("%d %d\n", n, n - 1);
      } else
        printf("%d %d\n", n - 1, n);
    } else if (n1 != n2) {
      cout << 1 << endl;
      int op = n3;
      if (n1 == op)
        printf("%d %d\n", 1, 2);
      else
        printf("%d %d\n", 2, 1);
    } else if (n3 != n4) {
      cout << 1 << endl;
      int op = n1;
      if (n3 == op)
        printf("%d %d\n", n, n - 1);
      else
        printf("%d %d\n", n - 1, n);
    } else {
      if (n1 != n3) {
        cout << 0 << endl;
        continue;
      }
      cout << 2 << endl;
      printf("%d %d\n", 2, 1);
      printf("%d %d\n", 1, 2);
    }
  }
}
