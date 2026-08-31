#include <bits/stdc++.h>
template <class T>
T sqr(T x) {
  return x * x;
}
template <class T>
T lcm(T a, T b) {
  return a / __gcd(a, b) * b;
}
const long long mod = 1e9 + 7, oo = 1e12, N = 2e5 + 5;
using namespace std;
long long n, b[N], res, bit1[N], bit2[N];
pair<long long, long long> a[N];
inline long long lowbit(long long x) { return x & -x; }
void update(long long pos, long long val, long long *arr) {
  while (pos <= n) {
    arr[pos] += val;
    pos += lowbit(pos);
  }
}
long long get(long long pos, long long *arr) {
  long long ret = 0;
  while (pos > 0) {
    ret += arr[pos];
    pos -= lowbit(pos);
  }
  return ret;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie();
  cout.tie();
  cin >> n;
  for (__typeof(n - 1) i = (0); i <= (n - 1); ++i) cin >> a[i].first;
  for (__typeof(n - 1) i = (0); i <= (n - 1); ++i) {
    cin >> a[i].second;
    b[i] = a[i].second;
  }
  sort(b, b + n);
  for (__typeof(n - 1) i = (0); i <= (n - 1); ++i)
    a[i].second = lower_bound(b, b + n, a[i].second) - b + 1;
  sort(a, a + n);
  for (__typeof(n - 1) i = (0); i <= (n - 1); ++i) {
    long long tmp1 = get(a[i].second, bit1);
    long long tmp2 = get(a[i].second, bit2);
    res += a[i].first * tmp1 - tmp2;
    update(a[i].second, 1, bit1);
    update(a[i].second, a[i].first, bit2);
  }
  cout << res;
  return 0;
}
