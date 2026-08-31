#include <bits/stdc++.h>
using namespace std;
int main() {
  int x;
  cin >> x;
  int a[x][3], b[x];
  for (int i = 0; i < x; i++) {
    for (int j = 0; j < 3; j++) {
      cin >> a[i][j];
    }
  }
  for (int i = 0; i < x; i++) {
    int count = 0;
    if (a[i][1] == 0) {
      cout << "0" << endl;
      continue;
    } else {
      for (int k = a[i][1]; k > 0; k--) {
        if ((k * 2) <= a[i][2]) {
          count = count + 3 * k;
          a[i][1] -= k;
          break;
        }
      }
      for (int k = a[i][0]; k > 0; k--) {
        if (a[i][1] == 0) {
          break;
        } else if ((k * 2) <= a[i][1]) {
          count = count + 3 * k;
          break;
        }
      }
    }
    cout << count << endl;
  }
}
