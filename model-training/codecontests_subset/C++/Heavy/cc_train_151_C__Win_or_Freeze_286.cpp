#include <bits/stdc++.h>
using namespace std;
unsigned long long arr[4000001];
int main() {
  arr[0] = 0, arr[1] = 0;
  for (int i = 2; i <= 4000000; i++) arr[i] = 1;
  for (int i = 2; i * i <= 4000000; i++) {
    if (arr[i]) {
      for (int p = i * i; p <= 4000000; p += i) {
        arr[p] = 0;
      }
    }
  }
  unsigned long long q, x = 0, y = 0, z, c = 1, tmp = 0, mn = INT_MAX;
  cin >> q;
  bool b = 0, bl = 0;
  while (1) {
    b = 0, z = 0, mn = INT_MAX;
    for (unsigned long long i = 2; i * i <= q; i++) {
      if (q % i == 0 && !arr[i]) {
        b = 1;
        z = i;
        break;
      } else if (q % i == 0 && arr[i]) {
        b = 1;
        z = q / i;
      }
    }
    if (q != 4 && q % 2 == 0) {
      if (z > q / 2) z = q / 2;
    }
    if (c == 1) x = z;
    q = z;
    c++;
    if (!b) break;
  }
  if (c % 2 == 0)
    cout << "1\n" << x << "\n";
  else
    cout << 2 << "\n";
  return 0;
}
