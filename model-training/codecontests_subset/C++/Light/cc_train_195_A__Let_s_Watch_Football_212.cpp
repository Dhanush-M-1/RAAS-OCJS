#include <bits/stdc++.h>
long long a, b, c;
using namespace std;
bool ok(long long mid);
long long low = 0, high = 1e12 + 100;
long long mid;
int main() {
  cin >> a >> b >> c;
  while (low < high) {
    mid = low + (high - low + 1) / 2;
    if (ok(mid))
      high = mid - 1;
    else
      low = mid;
  }
  cout << ++high << endl;
  return 0;
}
bool ok(long long mid) {
  if (b * mid + b * c >= a * (c))
    return 1;
  else
    return 0;
}
