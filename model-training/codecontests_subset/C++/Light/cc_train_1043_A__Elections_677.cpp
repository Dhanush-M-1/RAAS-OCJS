#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<long long> a(n);
  long long s = 0;
  long long l = 0;
  long long r = 1000000000000000;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    s += a[i];
    l = max(a[i], l);
  }
  long long is = r;
  while (l <= r) {
    long long mid = (l + r) / 2;
    if (n * mid - s > s) {
      is = min(is, mid);
      r = mid - 1;
    } else
      l = mid + 1;
  }
  cout << is << '\n';
  return 0;
}
