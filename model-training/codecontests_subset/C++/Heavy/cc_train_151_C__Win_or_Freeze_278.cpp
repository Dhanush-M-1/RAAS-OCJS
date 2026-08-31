#include <bits/stdc++.h>
using namespace std;
const int maxcnt_prime = 500000 + 5;
long long q;
long long prime[maxcnt_prime];
int pcnt[maxcnt_prime];
int cnt_prime;
int main() {
  cin >> q;
  long long qt = q;
  for (long long i = 2; i * i <= q; ++i)
    if (qt % i == 0) {
      prime[++cnt_prime] = i;
      while (qt % i == 0) qt /= i, ++pcnt[cnt_prime];
    }
  if (qt > 1) prime[++cnt_prime] = qt, pcnt[cnt_prime] = 1;
  if (q == 1 || prime[cnt_prime] == q) {
    cout << 1 << endl << 0 << endl;
    return 0;
  } else if (prime[1] * prime[1] != q && prime[1] * prime[2] != q) {
    long long ret = 1;
    if (pcnt[1] >= 2)
      ret = prime[1] * prime[1];
    else
      ret = prime[1] * prime[2];
    cout << 1 << endl << ret << endl;
  } else
    cout << 2 << endl;
  return 0;
}
