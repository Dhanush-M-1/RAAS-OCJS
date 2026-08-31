#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5;
int T;
int seq[maxn * 10 + 5];
long long sum, n, l, r;
void mak(int p) {
  long long len = 0;
  for (int i = p; i <= n; i++) {
    for (int j = i + 1; j <= n; j++) {
      seq[++len] = i;
      seq[++len] = j;
    }
    if (len + sum >= r) break;
  }
}
int main() {
  scanf("%d", &T);
  while (T--) {
    scanf("%lld %lld %lld", &n, &l, &r);
    bool fl = 0;
    if (r == n * (n - 1ll) + 1) fl = 1;
    sum = 0;
    int pos;
    for (int i = 1; i <= n; i++) {
      if (sum + 2 * (n - i) >= l) {
        mak(i);
        break;
      }
      sum += 2 * (n - i);
    }
    l -= sum;
    r -= sum;
    if (fl) seq[r] = 1;
    for (int i = l; i <= r; i++) printf("%d ", seq[i]);
    printf("\n");
  }
  return 0;
}
