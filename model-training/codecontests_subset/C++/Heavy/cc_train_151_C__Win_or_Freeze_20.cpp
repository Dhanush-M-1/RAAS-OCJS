#include <bits/stdc++.h>
int rr[] = {0, 0, 1, -1};
using namespace std;
int main() {
  long long int q, q1, i, cnt, f;
  while (cin >> q) {
    if (q == 1) {
      cout << "1" << endl << "0" << endl;
      continue;
    }
    q1 = q;
    for (i = 2, f = 0; i * i <= q; i++) {
      if (q % i == 0) {
        cnt++;
        f = 1;
        q = q / i;
        break;
      }
    }
    if (f == 1)
      for (i = 2; i * i <= q; i++) {
        if (q % i == 0) {
          q = q / i;
          f = 2;
          break;
        }
      }
    if (f == 2 || f == 0) {
      cout << "1" << endl;
      if (f == 2)
        cout << q1 / q << endl;
      else
        cout << "0" << endl;
    } else
      cout << "2" << endl;
  }
  return 0;
}
