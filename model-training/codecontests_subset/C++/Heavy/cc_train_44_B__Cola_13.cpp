#include <bits/stdc++.h>
using namespace std;
long double pi = 3.1415927535897932384626433;
template <typename T, typename U>
static inline void amin(T &x, U y) {
  if (y < x) x = y;
}
template <typename T, typename U>
static inline void amax(T &x, U y) {
  if (x < y) x = y;
}
long long cdiv(long long a, long long b) {
  return a / b + ((a ^ b) > 0 && a % b);
}
long long fdiv(long long a, long long b) {
  return a / b - ((a ^ b) < 0 && a % b);
}
long long max(long long a, long long b, long long c) {
  return max(a, max(b, c));
}
long long min(long long a, long long b, long long c) {
  return min(a, min(b, c));
}
long long gcd(long long a, long long b) {
  if (b == 0)
    return (a);
  else
    return (gcd(b, a % b));
}
void _good_for_nothing_() {
  long long n, a, b, c;
  cin >> n >> a >> b >> c;
  long long cnt = 0;
  n *= 2;
  for (long long i = 0; i < a + 1; i++) {
    for (long long j = 0; j < b + 1; j++) {
      long long temp = i + 2 * j;
      long long third = (n - temp) / 4;
      if (third == cdiv((n - temp), 4) and third <= c and third >= 0 and
          third == fdiv((n - temp), 4))
        cnt++;
    }
  }
  cout << cnt;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long TESTS = 1;
  while (TESTS--) _good_for_nothing_();
  return 0;
}
