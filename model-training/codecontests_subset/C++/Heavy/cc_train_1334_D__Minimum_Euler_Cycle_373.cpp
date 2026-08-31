#include <bits/stdc++.h>
using namespace std;
int gcdExtended(int a, int b, int *x, int *y) {
  if (a == 0) {
    *x = 0, *y = 1;
    return b;
  }
  int x1, y1;
  int gcd = gcdExtended(b % a, a, &x1, &y1);
  *x = y1 - (b / a) * x1;
  *y = x1;
  return gcd;
}
long long int modInverse(int a, int m) {
  int x, y;
  int g = gcdExtended(a, m, &x, &y);
  long long int res = ((long long int)x % m + (long long int)m) % m;
  return res;
}
long long int poww(long long int x, long long int n) {
  if (n == 0)
    return 1;
  else if (n == 1)
    return x;
  else if (n % 2 == 0)
    return poww(x * x, n / 2);
  else
    return x * poww(x * x, (n - 1) / 2);
}
long long int modularExponentiation(long long int x, long long int n,
                                    long long int M) {
  long long int result = 1;
  while (n > 0) {
    if (n % 2 == 1) result = (result * x) % M;
    x = (x * x) % M;
    n = n / 2;
  }
  return result;
}
template <typename T>
T maxx(T a, T b) {
  if (a < b) return b;
  return b;
}
template <typename T, typename... Args>
T maxx(T a, T b, Args... args) {
  return (maxx(maxx(a, b), args...));
}
template <typename T>
T minn(T a, T b) {
  if (a < b) return a;
  return b;
}
template <typename T, typename... Args>
T minn(T a, T b, Args... args) {
  return (minn(minn(a, b), args...));
}
int gcd(int a, int b) {
  if (a == 0) return b;
  if (b == 0) return a;
  if (a == b) return a;
  if (a > b)
    return gcd(a - b, b);
  else
    return gcd(a, b - a);
}
long long int ncr(int n, int r) {
  long long int ans = 1;
  r = min(r, n - r);
  for (int i = 0; i < r; i++) {
    ans = (ans * (n - i) / (i + 1)) % 1000000007;
  }
  return ans;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  int t = 1;
  cin >> t;
  while (t--) {
    long long int n, m, k, l, r;
    cin >> n >> l >> r;
    l--;
    m = 0;
    k = 1;
    while (m + (n - k) * 2 <= l && k < n) {
      m += (n - k) * 2;
      k++;
    }
    long long int temp = m;
    vector<long long int> v;
    while (m <= r) {
      long long int z = k;
      if (k != n) {
        for (int i = 0; i < (n - k); i++) {
          m += 2;
          v.push_back(k);
          v.push_back(++z);
        }
        k++;
      } else {
        v.push_back(1);
        break;
      }
    }
    for (int i = 0; i < r - l; i++) {
      cout << v[l - temp + i] << " ";
    }
    cout << '\n';
  }
  return 0;
}
