#include <bits/stdc++.h>
using namespace std;
long long n;
void prnt(long long a, long long b, long long cnt) {
  if (cnt) printf("%d ", a);
  if (cnt < 2) return;
  printf("%d ", b);
  if (b != n)
    prnt(a, b + 1, cnt - 2);
  else if (a != n - 1)
    prnt(a + 1, a + 2, cnt - 2);
  else if (cnt > 2)
    printf("1");
}
long long arth(long long st, long long en, long long n) {
  return n * (st + en) / 2;
}
long long clc(long long m) { return arth((n - 1) * 2, (n - m) * 2, m); }
long long bs(long long lft) {
  long long l = 1, r = n - 1, m;
  while (l < r) {
    m = (l + r) / 2;
    long long c = clc(m);
    if (lft > c)
      l = m + 1;
    else
      r = m;
  }
  return l;
}
void fnd(long long lft, long long rit) {
  long long l1 = bs(lft);
  long long l2 = bs(lft + 1);
  if (l1 == l2) {
    long long nl = lft;
    if (l1 > 1) nl -= clc(l1 - 1);
    long long k = nl / 2;
    if (nl % 2 == 0) cout << k + l1 << " ", lft++;
    prnt(l1, k + l1 + 1, rit - lft + 1);
  } else {
    cout << n << " ";
    prnt(l2, l2 + 1, rit - lft);
  }
}
int main() {
  long long t;
  scanf("%lld", &t);
  while (t--) {
    scanf("%lld", &n);
    long long lft, rit;
    scanf("%lld%lld", &lft, &rit);
    long long mx = n * (n - 1) + 1;
    if (lft == mx)
      cout << 1 << endl;
    else if (lft + 1 == mx) {
      cout << n;
      if (rit == mx) cout << " " << 1 << endl;
    } else {
      fnd(lft, rit);
      cout << endl;
    }
  }
}
