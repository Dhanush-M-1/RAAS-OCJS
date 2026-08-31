#include <bits/stdc++.h>
using namespace std;
int main() {
  bool ok = false;
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
  do {
    if (a[0] + a[1] == r1 && a[2] + a[3] == r2 && a[0] + a[2] == c1 &&
        a[1] + a[3] == c2 && a[0] + a[3] == d1 && a[1] + a[2] == d2) {
      ok = true;
      break;
    }
  } while (next_permutation(a, a + 9));
  if (ok)
    cout << a[0] << ' ' << a[1] << endl << a[2] << ' ' << a[3] << endl;
  else
    cout << -1 << endl;
  return 0;
}
