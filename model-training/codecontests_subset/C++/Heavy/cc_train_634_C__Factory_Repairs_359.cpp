#include <bits/stdc++.h>
using namespace std;
struct __s {
  __s() {
    srand(time(NULL));
    if (1) {
      ios_base::Init i;
      cin.sync_with_stdio(0);
      cin.tie(0);
    }
  }
  ~__s() {
    if (!1)
      fprintf(stderr, "Execution time: %.3lf s.\n",
              (double)clock() / CLOCKS_PER_SEC);
    long long n;
    cin >> n;
  }
} __S;
long long n, k, a, b, q;
long long C[811111];
long long D[811111];
void addC(long long v, long long l, long long r, long long i, long long val) {
  if (l == r)
    C[v] = min(C[v] + val, a);
  else {
    long long mid = (l + r) / 2;
    if (i <= mid)
      addC(2 * v, l, mid, i, val);
    else
      addC(2 * v + 1, mid + 1, r, i, val);
    C[v] = C[2 * v] + C[2 * v + 1];
  }
}
void addD(long long v, long long l, long long r, long long i, long long val) {
  if (l == r)
    D[v] = min(D[v] + val, b);
  else {
    long long mid = (l + r) / 2;
    if (i <= mid)
      addD(2 * v, l, mid, i, val);
    else
      addD(2 * v + 1, mid + 1, r, i, val);
    D[v] = D[2 * v] + D[2 * v + 1];
  }
}
long long getC(long long v, long long l, long long r, long long tl,
               long long tr) {
  if (tl > tr)
    return 0;
  else if (tl == l && tr == r)
    return C[v];
  else {
    long long mid = (l + r) / 2;
    return getC(v * 2, l, mid, tl, min(tr, mid)) +
           getC(v * 2 + 1, mid + 1, r, max(tl, mid + 1), tr);
  }
}
long long getD(long long v, long long l, long long r, long long tl,
               long long tr) {
  if (tl > tr)
    return 0;
  else if (tl == l && tr == r)
    return D[v];
  else {
    long long mid = (l + r) / 2;
    return getD(v * 2, l, mid, tl, min(tr, mid)) +
           getD(v * 2 + 1, mid + 1, r, max(tl, mid + 1), tr);
  }
}
int main(void) {
  cin >> n >> k >> a >> b >> q;
  for (long long i = 0; i < (long long)(q); i++) {
    long long x;
    cin >> x;
    if (x == 1) {
      long long d;
      cin >> d >> x;
      d--;
      addC(1, 0, n - 1, d, min(x, a));
      addD(1, 0, n - 1, d, min(x, b));
    } else {
      cin >> x;
      x--;
      long long res = 0;
      res += getD(1, 0, n - 1, 0, x - 1);
      res += getC(1, 0, n - 1, x + k, n - 1);
      cout << res << '\n';
    }
  }
  return 0;
}
