#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, x, y, z, up1(0), up2(0), up3(0), f1(0), f2(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x;
    up1 += x;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> y;
    up2 += y;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> z;
    up3 += z;
  }
  f1 = up1 - up2;
  f2 = up2 - up3;
  cout << f1 << "\n" << f2 << "\n";
  return 0;
}
