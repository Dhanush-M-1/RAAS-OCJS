#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2, n[4], b[4];
  cin >> r1 >> r2;
  cin >> c1 >> c2;
  cin >> d1 >> d2;
  n[0] = (d1 + c1 - r2) / 2;
  b[0] = n[0];
  n[1] = (c2 + d2 - r2) / 2;
  b[1] = n[1];
  n[2] = (c1 + d2 - r1) / 2;
  b[2] = n[2];
  n[3] = (c2 + d1 - r1) / 2;
  b[3] = n[3];
  sort(b, b + 4);
  int m = (unique(b, b + 4) - b);
  if (m == 4 && n[0] < 10 && n[1] < 10 && n[2] < 10 && n[3] < 10 && n[0] > 0 &&
      n[1] > 0 && n[2] > 0 && n[3] > 0) {
    cout << n[0] << " " << n[1] << "\n";
    cout << n[2] << " " << n[3] << "\n";
  } else
    cout << "-1\n";
  return 0;
}
