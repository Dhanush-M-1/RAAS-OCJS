#include <bits/stdc++.h>
using namespace std;
void fast_IO_file() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
}
int main() {
  fast_IO_file();
  long long int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  long long int flag = 0, a, b, c, d;
  for (long long int i = 1; i < 10; i++) {
    for (long long int j = 1; j < 10; j++) {
      for (long long int k = 1; k < 10; k++) {
        for (long long int l = 1; l < 10; l++) {
          if (i != j && i != k && i != l && j != k && j != l && k != l &&
              (i + j) == r1 && (k + l) == r2 && (i + k) == c1 &&
              (j + l) == c2 && (i + l) == d1 && (j + k) == d2) {
            a = i;
            b = j;
            c = k;
            d = l;
            flag = 1;
            break;
          }
        }
        if (flag) break;
      }
      if (flag) break;
    }
    if (flag) break;
  }
  if (flag) {
    cout << a << " " << b << "\n";
    cout << c << " " << d << "\n";
  } else {
    cout << -1;
  }
  return 0;
}
