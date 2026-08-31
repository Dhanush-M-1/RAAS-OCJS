#include <bits/stdc++.h>
using namespace std;
long long gcd(long long n, long long m) {
  return n % m == 0 ? m : gcd(m, n % m);
}
long long getNum(long long x, long long n, long long pre, long long k) {
  if (k >= n) return 1;
  if ((x - pre) & 1)
    return k;
  else
    return k + (x - pre) / 2;
}
int main() {
  ios::sync_with_stdio(false);
  int T;
  cin >> T;
  while (T--) {
    long long n, l, r;
    cin >> n >> l >> r;
    long long pre = 0;
    long long Next = 2 * (n - 1);
    long long k = 1;
    for (long long i = l; i <= r; i++) {
      while (i > Next && k != n) {
        pre = Next;
        Next += 2 * (n - k - 1);
        k++;
      }
      cout << getNum(i, n, pre, k) << " ";
    }
    cout << endl;
  }
  return 0;
}
