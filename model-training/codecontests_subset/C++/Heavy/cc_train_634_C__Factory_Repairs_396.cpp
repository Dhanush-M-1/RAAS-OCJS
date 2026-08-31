#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
long long A[maxn], ta[maxn], tb[maxn];
long long n, k, a, b, q;
void insert(long long i, long long num, long long *t) {
  for (; i < maxn; i += (i & (-i))) t[i] += num;
}
long long cal(long long i, long long *t) {
  long long ans = 0;
  for (; i > 0; i -= (i & (-i))) ans += t[i];
  return ans;
}
int main() {
  cin >> n >> k >> a >> b >> q;
  for (int i = 1; i <= q; i++) {
    int op;
    long long dd, aa, pp;
    scanf("%d", &op);
    if (op == 1) {
      scanf("%lld%lld", &dd, &aa);
      insert(dd, max(0ll, min(b - A[dd], aa)), tb);
      insert(dd, max(0ll, min(a - A[dd], aa)), ta);
      A[dd] += aa;
    } else {
      scanf("%lld", &pp);
      printf("%lld\n", cal(pp - 1, tb) + cal(n, ta) - cal(pp + k - 1, ta));
    }
  }
}
