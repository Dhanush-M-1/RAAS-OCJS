#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, k, a, b, c, t;
  cin >> a >> b >> c;
  t = 1;
  i = a * c;
  j = 0;
  while (t > 0) {
    k = j * b + c * b;
    if (k >= i)
      t = 0;
    else
      j = j + 1;
  }
  cout << j;
  return 0;
}
