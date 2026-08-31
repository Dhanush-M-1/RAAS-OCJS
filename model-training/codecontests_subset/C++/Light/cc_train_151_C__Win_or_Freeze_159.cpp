#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  long long q, k = 0, fi = 1;
  cin >> q;
  long long l = q;
  while (q % 2 == 0) {
    if (k < 2) fi *= 2;
    q /= 2;
    ++k;
  }
  for (long long i = 3; i * i <= q; i += 2) {
    while (q % i == 0) {
      if (k < 2) fi *= i;
      q /= i;
      ++k;
    }
  }
  if (q > 2) ++k;
  if (k > 2) {
    cout << "1"
         << "\n";
    cout << fi << "\n";
  } else if (l == 1 || k == 1) {
    cout << "1"
         << "\n"
         << "0"
         << "\n";
    ;
  } else
    cout << "2"
         << "\n";
  return 0;
}
