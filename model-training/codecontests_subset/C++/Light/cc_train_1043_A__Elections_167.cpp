#include <bits/stdc++.h>
using namespace std;
int n, a[107], r, max1;
bool f(int x) {
  if ((n * x) - r > r) return true;
  return false;
}
int haha(int b, int e) {
  int mid;
  while (b <= e) {
    mid = (b + e) >> 1;
    if (b >= e) {
      return mid;
    } else if (f(mid))
      e = mid;
    else
      b = mid + 1;
  }
}
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    max1 = max(max1, a[i]);
    r += a[i];
  }
  cout << haha(max1, 10000) << endl;
  return 0;
}
