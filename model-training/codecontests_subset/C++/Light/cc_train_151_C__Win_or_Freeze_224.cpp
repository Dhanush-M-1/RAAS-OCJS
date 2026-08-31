#include <bits/stdc++.h>
using namespace std;
int main() {
  long long q, p[2], t = 0;
  cin >> q;
  for (long long i = 2; i * i <= q; ++i) {
    if (t == 2) break;
    if (!(q % i) && t < 2 && q > i) {
      p[t++] = i;
      q /= i;
      i--;
    }
  }
  if (t == 2)
    cout << 1 << "\n" << p[0] * p[1];
  else if (t == 1)
    cout << 2;
  else
    cout << 1 << "\n" << 0;
  return 0;
}
