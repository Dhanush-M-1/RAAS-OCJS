#include <bits/stdc++.h>
using namespace std;
long long fpow(long long n, long long k, long long p = 1000000007) {
  long long r = 1;
  for (; k; k >>= 1) {
    if (k & 1) r = r * n % p;
    n = n * n % p;
  }
  return r;
}
long long inv(long long a, long long p = 1000000007) {
  return fpow(a, p - 2, p);
}
long long Sqrt(long long x) {
  if (x == 0 || x == 1) return x;
  long long start = 1, end = x, ans;
  while (start <= end) {
    long long mid = (start + end) / 2;
    if (mid * mid == x) return mid;
    if (mid * mid < x) {
      start = mid + 1;
      ans = mid;
    } else
      end = mid - 1;
  }
  return ans;
}
long long power(long long x, long long y) {
  if (y == 0)
    return 1;
  else if (y % 2 == 0)
    return power(x, y / 2) * power(x, y / 2);
  else
    return x * power(x, y / 2) * power(x, y / 2);
}
long long gcd(long long a, long long b) {
  long long r;
  while (b) {
    r = a % b;
    a = b;
    b = r;
  }
  return a;
}
long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
void in(long long &no) {
  bool neg = false;
  register long long c;
  no = 0;
  c = getchar();
  if (c == '-') {
    neg = true;
    c = getchar();
  }
  for (; (c > 47 && c < 58); c = getchar()) no = no * 10 + c - 48;
  if (neg) no *= -1;
}
long long maxx(long long a, long long b) {
  if (a > b) return a;
  return b;
}
int main() {
  long long i, n, k, x;
  cin >> n;
  vector<long long> v1, v2;
  v1.push_back(1);
  v2.push_back(1e6);
  for (int i = (0); i < (n); i++) {
    cin >> x;
    if (x > 500000) {
      v2.push_back(x);
    } else
      v1.push_back(x);
  }
  long long a, b;
  a = (*max_element(v1.begin(), v1.end()));
  b = (*min_element(v2.begin(), v2.end()));
  cout << maxx(1e6 - b, a - 1);
  return 0;
}
