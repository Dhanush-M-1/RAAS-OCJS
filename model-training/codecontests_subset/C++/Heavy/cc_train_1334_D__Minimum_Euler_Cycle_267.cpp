#include <bits/stdc++.h>
using namespace std;
long long Min(long long a, long long b) { return (a < b) ? a : b; }
long long Max(long long a, long long b) { return (a < b) ? b : a; }
long long gcd(long long m, long long n) {
  if (n == 0) return m;
  return gcd(n, m % n);
}
long long lcm(long long m, long long n) { return m * n / gcd(m, n); }
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long tc;
  cin >> tc;
  while (tc--) {
    long long n, l, r;
    cin >> n >> l >> r;
    long long ff = l, cnt = r - l + 1, ai = -1;
    if (l > n * (n - 1)) {
      cout << "1\n";
      continue;
    }
    for (int i = 1; i < n; i++) {
      if (ff - 2 * (n - i) <= 0) {
        ai = i;
        break;
      }
      ff -= 2 * (n - i);
    }
    if (ai == -1) {
      ai = n - 1;
    }
    long long aj = ai + ff / 2 + (l & 1);
    l %= 2;
    while (cnt--) {
      if (l & 1) {
        cout << ai << ' ';
      } else {
        cout << aj << ' ';
        aj++;
        if (aj > n) {
          ai++;
          aj = ai + 1;
        }
        if (ai == n) {
          ai = 1;
        }
      }
      l = 1 - l;
    }
    cout << '\n';
  }
  exit(0);
}
