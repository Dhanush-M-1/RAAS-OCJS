#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2;
  cin >> c1 >> c2;
  cin >> d1 >> d2;
  int a1, a2, a3, a4;
  int flag = 0;
  for (a1 = 1; a1 <= 9; a1++) {
    for (a2 = 1; a2 <= 9; a2++) {
      for (a3 = 1; a3 <= 9; a3++) {
        for (a4 = 1; a4 <= 9; a4++) {
          if (a1 + a2 == r1 && a3 + a4 == r2 && a1 + a3 == c1 &&
              a2 + a4 == c2 && a1 + a4 == d1 && a2 + a3 == d2 && a1 != a2 &&
              a2 != a3 && a3 != a4 && a1 != a3 && a1 != a4 && a2 != a4) {
            flag = 1;
            cout << a1 << " " << a2 << endl;
            cout << a3 << " " << a4 << endl;
            break;
          }
        }
      }
    }
  }
  if (!flag) {
    cout << "-1" << endl;
  }
  return 0;
}
