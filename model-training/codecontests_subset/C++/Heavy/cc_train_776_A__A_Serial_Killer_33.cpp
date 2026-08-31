#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b;
  int i, n;
  cin >> a >> b;
  cin >> n;
  string ar[n][2], tmp, tmp1;
  for (i = 0; i < n; i++) {
    for (int j = 0; j < 2; j++) {
      cin >> ar[i][j];
    }
  }
  cout << a << " " << b << endl;
  for (i = 0; i < n; i++) {
    for (int j = 0; j < 2; j++) {
      if (i == 0) {
        if (ar[i][0] == a) {
          tmp = b;
          tmp1 = ar[i][1];
        } else {
          tmp = a;
          tmp1 = ar[i][1];
        }
      } else {
        if (ar[i][0] == tmp) {
          tmp = ar[i][1];
        } else if (ar[i][0] == tmp1) {
          tmp1 = ar[i][1];
        }
      }
    }
    cout << tmp << " " << tmp1 << endl;
  }
}
