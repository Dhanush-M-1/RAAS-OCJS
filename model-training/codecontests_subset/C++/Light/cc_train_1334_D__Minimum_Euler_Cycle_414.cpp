#include <bits/stdc++.h>
using namespace std;
long long arr[200005];
long long solve(long long x, long long n) {
  long long ind = lower_bound(arr + 1, arr + n, x) - arr;
  x -= arr[ind - 1];
  if (x & 1) return ind;
  return x / 2 + ind;
}
int main() {
  long long t;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    arr[0] = 0;
    for (long long i = 1; i <= n; i++) {
      arr[i] = arr[i - 1] + (n - i) * 2;
    }
    for (long long i = l; i <= r; i++) {
      if (i == n * (n - 1) + 1)
        cout << 1 << " ";
      else
        cout << solve(i, n) << " ";
    }
    cout << endl;
  }
}
