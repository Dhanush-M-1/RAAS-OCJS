#include <bits/stdc++.h>
using namespace std;
inline long long gcd(long long a, long long b) {
  while (b) {
    a %= b, swap(a, b);
  }
  return a;
}
inline long long lcm(long long a, long long b) {
  return a * b / max(1LL, gcd(a, b));
}
mt19937 Random((long long)time(0));
inline long long rnd(long long x) { return Random() % x; }
const long long INF = (long long)1e9 + 2017;
const long long MOD = (long long)1e9 + 7;
const long double EPS = 1e-10;
const long double PI = acos(-1.0);
const long long N = 1e5 + 10;
long long arr[N], suf[N];
void source() {
  long long n, d;
  cin >> n >> d;
  for (long long i = 0; i < n; ++i) {
    cin >> arr[i];
  }
  suf[n - 1] = arr[n - 1];
  for (long long i = n - 2; i >= 0; --i) {
    suf[i] = max(0ll, suf[i + 1]) + arr[i];
  }
  long long cur = 0, ans = 0;
  for (long long i = 0; i < n; ++i) {
    cur += arr[i];
    if (cur > d) {
      cout << -1;
      return;
    }
    if (!arr[i] && cur < 0) {
      cur = d - suf[i];
      if (cur < 0) {
        cout << -1;
        return;
      }
      ans++;
    }
  }
  cout << ans;
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cout.setf(ios_base::fixed, ios_base::floatfield);
  cout.precision(10);
  source();
}
