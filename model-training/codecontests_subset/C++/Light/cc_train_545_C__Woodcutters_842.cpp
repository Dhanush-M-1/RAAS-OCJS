#include <bits/stdc++.h>
using namespace std;
int main() {
  long n;
  cin >> n;
  long long x, h;
  long c = 0;
  cin >> x >> h;
  if (n == 1) {
    cout << 1;
    return 0;
  }
  ++c;
  h = 0;
  long long X, H;
  for (long i = 1; i < n - 1; ++i) {
    cin >> X >> H;
    if (h > 0 && h < X - x) {
      ++c;
      x += h;
      h = 0;
    }
    if (H < X - x) {
      ++c;
      H = 0;
    }
    x = X;
    h = H;
  }
  cin >> X >> H;
  if (h > 0 && h < X - x) {
    ++c;
    x += h;
    h = 0;
  }
  ++c;
  cout << c;
  return 0;
}
