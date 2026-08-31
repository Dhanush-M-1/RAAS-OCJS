#include <bits/stdc++.h>
using namespace std;
int a, b, c;
bool ok(int x) {
  if (((a * c) - (b * c) + b - 1) / b > x)
    return false;
  else
    return true;
}
int binarySearch() {
  int lo = 0, med, h = 1000000;
  while (lo < h) {
    med = (lo + h) >> 1;
    if (ok(med))
      h = med;
    else
      lo = med + 1;
  }
  return lo;
}
int main() {
  cin >> a >> b >> c;
  cout << binarySearch();
  return 0;
}
