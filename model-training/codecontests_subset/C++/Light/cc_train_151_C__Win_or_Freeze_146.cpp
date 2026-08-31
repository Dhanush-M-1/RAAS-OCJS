#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int i, a, p, b, p1, p2;
  cin >> a;
  b = a;
  p = 0;
  p1 = p2 = 1;
  for (i = 2; i <= sqrt(b); i++) {
    if (b % i == 0) {
      b = b / i;
      p++;
      if (p == 1) p1 = i;
      if (p == 2) p2 = i;
      i--;
    }
  }
  if (p == 0) cout << 1 << endl << 0 << endl;
  if (p == 1) cout << 2 << endl;
  if (p >= 2) cout << 1 << endl << p1 * p2 << endl;
}
