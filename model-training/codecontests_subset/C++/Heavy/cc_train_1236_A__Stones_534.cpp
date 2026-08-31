#include <bits/stdc++.h>
using namespace std;
long long heap(long long h1, long long h2, long long h3) {
  if (h2 == 0) return 0;
  long long stones = 0;
  if (h3 >= 2 * h2 && h3 != 0) {
    stones += 3 * h2;
    h3 = h3 - 2 * h2;
    h2 = 0;
    return stones;
  } else if (h3 < 2 * h2 && h3 != 0) {
    stones += 3 * (h3 / 2);
    h2 -= (h3 / 2);
  }
  if (h2 >= 2 * h1 && h1 != 0 && h2 != 0) {
    stones += 3 * h1;
    h2 = h2 - 2 * h1;
    h1 = 0;
  } else if (h2 < 2 * h1 && h1 != 0 && h2 != 0) {
    stones += 3 * (h2 / 2);
    h2 %= 2;
  }
  return stones;
}
int32_t main() {
  long long t;
  cin >> t;
  while (t--) {
    long long h1, h2, h3;
    cin >> h1 >> h2 >> h3;
    cout << heap(h1, h2, h3) << endl;
  }
}
