#include <bits/stdc++.h>
using namespace std;
const long long MOD = (long long)1e9 + 7;
const int N = 1e5 + 5, inf = 1e9 + 5;
long long add(long long x, long long y) {
  x += y;
  if (x >= MOD) return x - MOD;
  return x;
}
long long sub(long long x, long long y) {
  x -= y;
  if (x < 0) return x + MOD;
  return x;
}
long long mult(long long x, long long y) { return (x * y) % MOD; }
mt19937_64 rng(chrono::steady_clock::now().time_since_epoch().count());
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  vector<int> a(n);
  int sum = 0;
  for (__typeof(n) i = (0) - ((0) > (n)); i != (n) - ((0) > (n));
       i += 1 - 2 * ((0) > (n))) {
    cin >> a[i];
    sum += a[i];
  }
  int maxx = *max_element(begin(a), end(a));
  for (__typeof(205) k = (maxx) - ((maxx) > (205));
       k != (205) - ((maxx) > (205)); k += 1 - 2 * ((maxx) > (205))) {
    int new_sum = 0;
    for (__typeof(n) i = (0) - ((0) > (n)); i != (n) - ((0) > (n));
         i += 1 - 2 * ((0) > (n))) {
      new_sum += k - a[i];
    }
    if (new_sum > sum) {
      cout << k << endl;
      return 0;
    }
  }
  return 0;
}
