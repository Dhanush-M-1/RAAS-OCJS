#include <bits/stdc++.h>
using namespace std;
int T;
int n;
long long l, r;
void out(long long sum, int now, int num, long long i) {
  if (now == n) {
    if (i != l) printf(" ");
    printf("1");
    return;
  }
  for (i; i <= min(sum + num - 1, r); i++) {
    int N;
    if ((i - sum + 1) % 2)
      N = now;
    else
      N = now + (i - sum + 1) / 2;
    if (i == l) {
      printf("%d", N);
    } else
      printf(" %d", N);
  }
}
int main() {
  scanf("%d", &T);
  while (T--) {
    long long sum = 1;
    scanf("%d%lld%lld", &n, &l, &r);
    long long now = 1, num = (n - now) * 2;
    for (now = 1; now <= n; now++) {
      num = num = (n - now) * 2;
      num = max(num, 1 * 1ll);
      if (sum <= l && l <= sum + num) {
        out(sum, now, num, l);
      } else if (l <= sum && sum + num <= r) {
        out(sum, now, num, sum);
      } else if (sum <= r && r <= sum + num) {
        out(sum, now, num, sum);
        break;
      }
      sum += num;
    }
    printf("\n");
  }
}
