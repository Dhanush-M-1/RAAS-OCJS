#include <bits/stdc++.h>
using namespace std;
long long int mod = 1000000007;
inline long long int gcd(long long int a, long long int b) {
  return (b == 0) ? a : gcd(b, a % b);
}
inline long long int lcm(long long int a, long long int b) {
  return (a * b) / gcd(a, b);
}
inline long long int mymod(long long int A, long long int M) {
  return ((A % M) + M) % M;
}
template <class type>
type power(type x, long long int n) {
  type temp;
  long long int y = n;
  if (y == 0) return 1;
  temp = power(x, y / 2);
  return ((y % 2) ? ((y > 0) ? x * temp * temp : (temp * temp) / x)
                  : temp * temp);
}
template <typename Arg, typename... Args>
void db(Arg&& arg, Args&&... args) {
  cout << std::forward<Arg>(arg);
  using expander = long long int[];
  (void)expander{0, (void(cout << ',' << std::forward<Args>(args)), 0)...};
  cout << "\n";
}
void IO_FILE() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
inline void solve() {
  long long int n, l, r;
  cin >> n >> l >> r;
  if (l == n * (n - 1) + 1) {
    cout << 1 << " ";
    return;
  }
  long long int st = 1;
  long long int cnt = 0;
  while (cnt < l) {
    cnt += 2 * (n - st);
    if (st == n) {
      cnt++;
      break;
    }
    st++;
  }
  st--;
  cnt -= 2 * (n - st);
  long long int w, f = 1, j = st + 1;
  while (cnt < l) {
    f ? w = st : w = j++;
    f = 1 - f;
    cnt++;
  }
  if (w != st) {
    cout << w << " ";
    l++;
  }
  f = 1;
  while (j <= n and l <= r) {
    f ? cout << st << " " : cout << j++ << " ";
    f = 1 - f;
    l++;
  }
  st++;
  while (l <= r) {
    f = 1;
    j = st + 1;
    if (st == n) {
      break;
    }
    while (j <= n and l <= r) {
      f ? cout << st << " " : cout << j++ << " ";
      f = 1 - f;
      l++;
    }
    st++;
  }
  if (r == n * (n - 1) + 1) {
    cout << 1 << " ";
  }
  cout << "\n";
}
int32_t main() {
  IO_FILE();
  long long int t;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
