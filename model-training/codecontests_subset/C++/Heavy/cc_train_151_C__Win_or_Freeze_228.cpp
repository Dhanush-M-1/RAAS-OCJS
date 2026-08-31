#include <bits/stdc++.h>
using namespace std;
vector<long long> y;
void prime_factorization(long long x) {
  long long i;
  long long c;
  c = x;
  while ((c % 2) == 0) {
    y.push_back(2LL);
    c = c / 2;
  }
  i = 3;
  while (i <= (sqrt(c) + 1)) {
    if ((c % i) == 0) {
      y.push_back(i);
      c = c / i;
    } else
      i = i + 2;
  }
  if (c > 1) y.push_back(c);
}
bool isprime(long long p) {
  if (p < 2) return false;
  long long d;
  for (d = 2; d * d <= p; d++)
    if (p % d == 0) return false;
  return true;
}
int main() {
  long long n;
  cin >> n;
  if (n == 1LL)
    cout << 1 << endl << 0 << endl;
  else if (isprime(n)) {
    cout << 1 << endl << 0 << endl;
    return 0;
  } else {
    prime_factorization(n);
    if ((int)(y.size()) <= 2)
      cout << 2 << endl;
    else {
      cout << 1 << endl;
      cout << (long long)(y[0] * y[1]) << endl;
    }
  }
  return 0;
}
