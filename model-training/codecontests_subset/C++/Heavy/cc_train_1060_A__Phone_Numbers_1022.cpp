#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 1123456;
template <typename T>
T sqr(T x) {
  return x * x;
}
template <typename T>
void vout(T s) {
  cout << s << "\n";
  exit(0);
}
long long bp(long long a, long long n) {
  long long res = 1;
  while (n) {
    if (n % 2) res *= a;
    a *= a;
    n >>= 1;
  }
  return res;
}
long long f(long long x) {
  long long res = 0;
  while (x) {
    res += x % 10;
    x /= 10;
  }
  return res;
}
long long a[MAXN];
int main() {
  ios_base ::sync_with_stdio(0);
  cin.tie(0);
  long long n, kol = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    char cc;
    cin >> cc;
    if (cc == '8') kol++;
  }
  cout << min(kol, n / 11) << "\n";
  cerr << "Time execute: " << clock() / (double)CLOCKS_PER_SEC << " sec"
       << "\n";
  return 0;
}
