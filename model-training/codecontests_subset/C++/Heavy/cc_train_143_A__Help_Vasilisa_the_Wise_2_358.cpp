#include <bits/stdc++.h>
bool isprime[100000];
using namespace std;
void setprime() {
  for (int i = 1; i < 100005; i++) isprime[i] = true;
  isprime[0] = false;
  isprime[1] = false;
  for (int i = 2; i * i < 100005; i++) {
    if (isprime[i] == true) {
      for (int j = (2 * i); j < 100005; j += i) isprime[j] = false;
    }
  }
}
long long mod = 1000000007;
long long N = 1000005;
long long abSolute(long long a) {
  if (a >= 0)
    return a;
  else
    return (-1) * a;
}
int main() {
  cin.tie(0);
  ios::sync_with_stdio(0);
  cout << fixed;
  cout << setprecision(12);
  long long r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  long long a, b, c, d;
  for (long long i = 1; i < 10; i++) {
    a = i;
    b = r1 - a;
    c = c1 - a;
    d = r2 - c1 + a;
    if (b < 10 && c < 10 && d < 10 && b > 0 && c > 0 && d > 0)
      if ((a != b) && (a != c) && (a != d) && (b != c) && (b != d) && (c != d))
        if ((a + d) == d1 && (b + c) == d2) {
          cout << a << " " << b << "\n" << c << " " << d;
          break;
        }
    if (i == 9) cout << -1;
  }
  return 0;
}
