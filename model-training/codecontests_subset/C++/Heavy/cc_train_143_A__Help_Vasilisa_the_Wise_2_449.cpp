#include <bits/stdc++.h>
using namespace std;
int main() {
  long long r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  long long cnt = 0;
  for (long long i = 1; i < 10; i++) {
    for (long long j = 1; j < 10; j++) {
      for (long long k = 1; k < 10; k++) {
        for (long long l = 1; l < 10; l++) {
          if (i != j && i != k && i != l && j != k && j != l && k != l) {
            if ((i + j == r1) && (k + l == r2) && (i + k == c1) &&
                (j + l == c2) && (i + l == d1) && (j + k == d2)) {
              cout << i << " " << j << endl;
              cout << k << " " << l << endl;
              cnt++;
            }
          }
        }
      }
    }
  }
  if (cnt == 0) {
    cout << "-1" << endl;
  }
  return 0;
}
