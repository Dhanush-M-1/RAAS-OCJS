#include <bits/stdc++.h>
using namespace std;
void fun(long long start, long long end, long long l, long long r) {
  long long n = end - start + 1;
  for (long long i = max(1ll, l); i <= min(2 * (n - 1), r); i++) {
    if (i % 2 == 0) {
      cout << start + i / 2 << " ";
    } else {
      cout << start << " ";
    }
  }
  if (r > 2 * (n - 1) && start + 1 != end) {
    fun(start + 1, end, max(1ll, l - 2 * (n - 1)), r - 2 * (n - 1));
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    bool flag = 0;
    if (r == n * (n - 1) + 1) {
      flag = 1;
      r--;
    }
    if (l <= r) {
      fun(1, n, l, r);
    }
    if (flag) {
      cout << 1 << " ";
    }
    cout << endl;
  }
  return 0;
}
