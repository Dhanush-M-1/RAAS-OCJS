#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int a, b, c, l, r, mid, i, j, k;
  cin >> a >> b >> c;
  l = 0;
  r = 1000000000;
  while (l <= r) {
    mid = (l + r) / 2;
    if ((mid + c) * b >= c * a) {
      k = mid;
      r = mid - 1;
    } else
      l = mid + 1;
  }
  cout << k << endl;
  return 0;
}
