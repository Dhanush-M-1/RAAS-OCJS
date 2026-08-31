#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (int i = 1; i <= 9; ++i) {
    bool print = true;
    int arr[30] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int r11 = i;
    int r12 = r1 - r11;
    int r21 = c1 - r11;
    int r22 = r2 - r21;
    if ((r11 > 9 || r11 < 0) || (r12 > 9 || r12 < 0) || (r21 > 9 || r21 < 0) ||
        (r22 > 9 || r22 < 0))
      continue;
    arr[r11] += 1;
    arr[r12] += 1;
    arr[r21] += 1;
    arr[r22] += 1;
    if ((r12 == r1 - r11) && (r21 == c1 - r11) && (r22 == r2 - r21)) {
      if (d1 == r11 + r22 && d2 == r12 + r21) {
        for (int s = 0; s < 10; s++)
          if (arr[s] > 1) print = false;
        if (r11 <= 0 || r12 <= 0 || r21 <= 0 || r22 <= 0) print = false;
        if (print) {
          cout << r11 << " " << r12 << endl;
          cout << r21 << " " << r22 << endl;
          exit(0);
        }
      }
    }
  }
  cout << -1 << endl;
  return 0;
}
