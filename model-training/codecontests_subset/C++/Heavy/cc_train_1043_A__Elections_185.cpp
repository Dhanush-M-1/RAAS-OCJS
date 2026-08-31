#include <bits/stdc++.h>
using namespace std;
void FAST() { ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0); }
int main() {
  FAST();
  long long n;
  cin >> n;
  long long sum = 0;
  long long mn = -1;
  for (long long i = 0; i < n; i++) {
    long long temp;
    cin >> temp;
    sum += temp;
    mn = max(mn, temp);
  }
  cout << max(mn, (2 * sum) / n + 1) << endl;
  return 0;
}
struct Query {
  long long L, R, idx;
};
bool compare(long long a0, long long a1) { return (a0 > a1); }
long long power(long long x, long long y, long long p) {
  long long ans = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) ans = (ans * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return ans;
}
long long x, y, g;
void extendedEuclid(long long a, long long b) {
  if (b == 0) {
    g = a;
    x = 1;
    y = 0;
  } else {
    extendedEuclid(b, a % b);
    long long temp = x;
    x = y;
    y = temp - (a / b) * y;
  }
}
long long moduloInverse(long long a, long long p) {
  extendedEuclid(a, p);
  if (g == 1 && p != 1)
    return (x + p) % p;
  else
    return -1;
}
