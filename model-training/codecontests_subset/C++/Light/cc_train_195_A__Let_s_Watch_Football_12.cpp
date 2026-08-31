#include <bits/stdc++.h>
using namespace std;
int main() {
  long long b;
  long long a, c, buf, buf2 = 0, mid;
  cin >> a >> b >> c;
  long long l = 0, r = 1e9;
  while (l < r) {
    mid = (l + r + 1) / 2;
    if ((mid + c) * b >= c * a)
      r = mid - 1;
    else
      l = mid;
  }
  cout << l + 1;
}
