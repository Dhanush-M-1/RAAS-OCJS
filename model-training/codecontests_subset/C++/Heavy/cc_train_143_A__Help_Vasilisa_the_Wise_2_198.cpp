#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int a1 = ((r1 + c1 - d2)) % 2 == 0 ? ((r1 + c1 - d2) / 2) : -1;
  int a2 = ((r1 + c2 - d1)) % 2 == 0 ? ((r1 + c2 - d1) / 2) : -1;
  int a3 = ((r2 + c1 - d1)) % 2 == 0 ? ((r2 + c1 - d1) / 2) : -1;
  int a4 = ((r2 + c2 - d2)) % 2 == 0 ? ((r2 + c2 - d2) / 2) : -1;
  if (a1 < 1 || a2 < 1 || a3 < 1 || a4 < 1 || a1 > 9 || a2 > 9 || a3 > 9 ||
      a4 > 9 || a1 == a2 || a1 == a3 || a1 == a4 || a2 == a3 || a2 == a4 ||
      a3 == a4) {
    cout << "-1";
  } else {
    cout << a1 << " " << a2 << endl;
    cout << a3 << " " << a4;
  }
  return 0;
}
