#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int l = 1, u = a * c, pos = -1;
  while (l <= u) {
    int mid = (l + u) / 2;
    int z = b * c;
    int z1 = a * c;
    int val = (mid * b) + (b * c);
    if (val == a * c) {
      pos = mid;
      break;
    }
    if (val > a * c) {
      pos = mid;
      u = mid - 1;
    } else {
      l = mid + 1;
    }
  }
  int val = (a * c) - (b * c);
  if (val <= 0) {
    puts("1");
    return 0;
  }
  int z1 = val / b;
  if (b * z1 != val) {
    z1++;
  }
  cout << z1 << endl;
  return 0;
}
