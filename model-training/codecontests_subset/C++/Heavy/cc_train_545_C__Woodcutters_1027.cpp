#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1e9 + 7;
const long long mx = 2e7;
vector<bool> pr(mx, 1);
void sv() {
  pr[1] = 0;
  for (long long n = 2; n * n <= mx; n++) {
    if (pr[n]) {
      for (long long k = 2 * n; k < mx; k += n) pr[k] = 0;
    }
  }
}
long long bit[mx];
void up(long long ind, long long vl) {
  while (ind < mx) {
    bit[ind] += vl;
    ind += ind & (-ind);
  }
}
long long qr(long long ind) {
  long long res = 0;
  while (ind) {
    res += bit[ind];
    ind -= ind & (-ind);
  }
  return res;
}
void solve() {
  long long x;
  scanf("%lld", &(x));
  vector<pair<long long, long long> > s(x);
  for (int n = 0; n < x; n++)
    scanf("%lld", &(s[n].first)), scanf("%lld", &(s[n].second));
  if (x == 1) {
    printf("%lld\n", (x));
    return;
  }
  long long res = 2;
  long long prv = s[0].first;
  for (long long n = 1; n < x - 1; n++) {
    long long a = s[n].first - s[n].second;
    long long b = s[n].first + s[n].second;
    if (a > prv) {
      res++;
      prv = s[n].first;
      continue;
    } else if (b < s[n + 1].first) {
      res++;
      prv = b;
      continue;
    }
    prv = s[n].first;
  }
  printf("%lld\n", (res));
}
int main() { solve(); }
