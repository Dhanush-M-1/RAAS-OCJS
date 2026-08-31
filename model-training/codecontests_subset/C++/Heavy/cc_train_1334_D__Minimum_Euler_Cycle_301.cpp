#include <bits/stdc++.h>
using namespace std;
int main() {
  long long test;
  scanf("%lld", &test);
  while (test--) {
    long long i, j, k, l, r, n, m;
    scanf("%lld", &n);
    scanf("%lld", &l);
    scanf("%lld", &r);
    long long pre = 1, cub = 0, num;
    for (i = 1; i < n; i++) {
      if (l <= cub + 2 * (n - i)) {
        pre = i;
        break;
      } else
        cub += 2 * (n - i);
    }
    num = pre + 1;
    vector<long long> ans;
    for (i = cub + 1; i <= r && i <= n * (n - 1); i++) {
      if (i & 1)
        k = pre;
      else
        k = num++;
      if (i >= l) ans.push_back(k);
      if (num > n) {
        pre++;
        num = pre + 1;
      }
    }
    if (r == n * (n - 1) + 1) ans.push_back(1LL);
    for (long long bn : ans) {
      printf("%lld", bn);
      printf(" ");
    }
    printf("\n");
  }
}
