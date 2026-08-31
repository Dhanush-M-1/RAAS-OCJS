#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T bigMod(T p, T e, T M) {
  long long ret = 1;
  for (; e > 0; e >>= 1) {
    if (e & 1) ret = (ret * p) % M;
    p = (p * p) % M;
  }
  return (T)ret;
}
template <class T>
inline T modInverse(T a, T M) {
  return bigMod(a, M - 2, M);
}
template <class T>
inline T gcd(T a, T b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
template <class T>
inline T lcm(T a, T b) {
  a = abs(a);
  b = abs(b);
  return (a / gcd(a, b)) * b;
}
template <class T>
inline string int2String(T a) {
  ostringstream str;
  str << a;
  return str.str();
}
const int dr[] = {0, 1, 0, -1, -1, 1, 1, -1, -2, -2, 2, 2, -1, -1, 1, 1};
const int dc[] = {1, 0, -1, 0, 1, 1, -1, -1, -1, 1, -1, 1, -2, 2, -2, 2};
int main() {
  long long n, d, mx = 0;
  scanf("%lld%lld", &n, &d);
  vector<long long> v(n + 2), sum(n + 2), mn(n + 2);
  for (int i = int(1); i < int(n + 1); i++)
    scanf("%lld", &v[i]), sum[i] = sum[i - 1] + v[i], mx = max(mx, sum[i]);
  if (sum[n] > d || mx > d) {
    puts("-1");
    return 0;
  }
  mn[n] = d - sum[n];
  for (int i = int(n - 1); i >= int(1); i--) mn[i] = min(mn[i + 1], d - sum[i]);
  long long cnt = 0, carry = v[1], ex = 0;
  for (int i = int(2); i < int(n + 1); i++) {
    if (carry + ex > d && ex) ex = d - carry;
    if (carry > d) {
      puts("-1");
      return 0;
    }
    carry += v[i];
    if (carry > d) {
      puts("-1");
      return 0;
    }
    if (v[i]) continue;
    if (carry + ex >= 0) {
      if (carry < 0) ex += carry, carry = 0;
      continue;
    }
    if (abs(carry) > mn[i]) {
      puts("-1");
      return 0;
    }
    ex = mn[i] + carry;
    carry = 0;
    cnt++;
  }
  printf("%lld\n", cnt);
  return 0;
}
