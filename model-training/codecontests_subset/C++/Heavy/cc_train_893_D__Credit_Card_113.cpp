#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T bigmod(T p, T e, T M) {
  long long int ret = 1;
  for (; e > 0; e >>= 1) {
    if (e & 1) ret = (ret * p) % M;
    p = (p * p) % M;
  }
  return (T)ret;
}
template <class T>
inline T gcd(T a, T b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
template <class T>
inline T modinverse(T a, T M) {
  return bigmod(a, M - 2, M);
}
template <class T>
inline T bpow(T p, T e) {
  long long int ret = 1;
  for (; e > 0; e >>= 1) {
    if (e & 1) ret = (ret * p);
    p = (p * p);
  }
  return (T)ret;
}
int toInt(string s) {
  int sm;
  stringstream ss(s);
  ss >> sm;
  return sm;
}
int toLlint(string s) {
  long long int sm;
  stringstream ss(s);
  ss >> sm;
  return sm;
}
int ts, kk = 1;
int n, m;
int a[100005];
long long int cr[100005];
long long int mx[100005];
int main() {
  int t, i, j, k;
  scanf("%d%d", &n, &m);
  for (i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    cr[i] = a[i];
    if (i) cr[i] += cr[i - 1];
    if (cr[i] > m) {
      printf("-1\n");
      return 0;
    }
  }
  mx[n - 1] = cr[n - 1];
  for (i = n - 2; i > -1; i--) {
    mx[i] = max(cr[i], mx[i + 1]);
  }
  int rs = 0;
  long long int nw = 0, bs = 0;
  for (i = 0; i < n; i++) {
    if (a[i] == 0) {
      if (nw < 0) {
        long long int cur = m - (bs + mx[i]);
        nw += cur;
        bs += cur;
        rs++;
      }
      if (nw < 0) {
        printf("-1\n");
        return 0;
      }
    } else {
      nw += a[i];
      if (nw > m) {
        printf("-1\n");
        return 0;
      }
    }
  }
  printf("%d\n", rs);
  return 0;
}
