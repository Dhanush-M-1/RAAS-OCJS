#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-6;
const int maxn = 3e5 + 100;
const int maxm = 2e6 + 100;
const int inf = 0x3f3f3f3f;
const double pi = acos(-1.0);
int t;
long long n;
long long l, r;
long long f(long long x) { return (2ll * n - x - 1) * x / 2ll; }
void pt(long long x) { printf("%lld ", x); }
int main() {
  scanf("%d", &t);
  while (t--) {
    scanf("%lld %lld %lld", &n, &l, &r);
    long long id = (l + 1) / 2;
    int ok = 0;
    if (r > n * (n - 1)) {
      ok = 1;
      r--;
    }
    if (l <= r) {
      long long L = 1, R = n - 1;
      long long res;
      while (L <= R) {
        long long mid = L + R >> 1;
        if (f(mid) >= id) {
          res = mid;
          R = mid - 1;
        } else
          L = mid + 1;
      }
      long long j = id - f(res - 1);
      while (l <= r) {
        if (l % 2 == 0) {
          pt(j + res);
          j++;
          l++;
        } else {
          pt(res);
          l++;
        }
        if (j > n - res) {
          j = 1;
          res++;
        }
      }
    }
    if (ok) printf("1");
    printf("\n");
  }
  return 0;
}
