#include <bits/stdc++.h>
using namespace std;
const int N = 1e9;
int a, b, c;
bool ok(long long mid) {
  long long data, sum = 0;
  data = a * c;
  sum = b * c + mid * b;
  return sum >= data;
}
int main() {
  int l = 0, h = N, mid;
  cin >> a >> b >> c;
  while (h > l) {
    mid = ((h + l) >> 1);
    if (ok(mid)) {
      h = mid;
    } else {
      l = mid + 1;
    }
  }
  cout << h << endl;
  return 0;
}
