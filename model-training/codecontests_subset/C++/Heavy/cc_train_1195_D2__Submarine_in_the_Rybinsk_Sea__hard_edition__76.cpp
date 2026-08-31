#include <bits/stdc++.h>
using namespace std;
const long long P = 998244353LL;
const int N_MAX = 1e5 + 15;
int A[N_MAX];
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> A[i];
  long long ans = 0LL;
  bool rem = 1;
  long long q = 1LL, w = 0LL;
  long long v = n * 1LL;
  while (v) {
    long long t = 0LL;
    for (int i = 0; i < n; i++) {
      if (A[i] == -1) continue;
      if (A[i] == 0) {
        w += (2LL * q);
        w %= P;
        v -= 1LL;
        A[i] = -1;
      } else {
        t += (1LL * (A[i] % 10));
        A[i] /= 10;
      }
    }
    if (v == 0) break;
    long long m = 0LL;
    m += v;
    m *= q;
    m %= P;
    m *= 11LL;
    m %= P;
    m += w;
    m %= P;
    t *= m;
    t %= P;
    q *= 100LL;
    q %= P;
    ans += t;
    ans %= P;
    w *= 10LL;
    w %= P;
  }
  ans %= P;
  cout << ans << endl;
  return 0;
}
