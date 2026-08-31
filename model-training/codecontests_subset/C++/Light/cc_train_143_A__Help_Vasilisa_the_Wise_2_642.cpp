#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int a1, a2, a3, a4;
  for (int i = 1; i <= 9; i++) {
    a1 = i;
    a2 = r1 - a1;
    a3 = c1 - a1;
    a4 = c2 - a2;
    if (1 > a2 or 1 > a3 or 1 > a4 or a2 > 9 or a3 > 9 or a4 > 9) continue;
    if (a1 == a2 or a1 == a3 or a1 == a4 or a2 == a3 or a2 == a4 or a3 == a4)
      continue;
    if (a3 + a4 != r2 or a1 + a4 != d1 or a2 + a3 != d2) continue;
    cout << a1 << " " << a2 << endl;
    cout << a3 << " " << a4 << endl;
    return 0;
  }
  puts("-1");
  return 0;
}
