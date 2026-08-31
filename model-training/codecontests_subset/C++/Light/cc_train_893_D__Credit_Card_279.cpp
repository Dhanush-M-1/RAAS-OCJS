#include <bits/stdc++.h>
using namespace std;
long long n, d;
long long a[100005];
vector<long long> save;
int main() {
  scanf("%I64d%I64d", &n, &d);
  for (long long i = 0; i < n; i++) scanf("%I64d", &a[i]);
  long long sum = 0, cnt = 0;
  long long lim = 1000000000;
  for (long long i = 0; i < n; i++) {
    if (a[i] == 0) {
      if (sum < 0) {
        if (cnt != 0 && lim >= (-sum)) {
          lim += sum;
          sum = 0;
        } else {
          cnt++;
          sum = 0;
          lim = 1000000000;
        }
      }
    }
    sum += a[i];
    if (sum > d) {
      printf("-1\n");
      return 0;
    }
    lim = min(lim, d - sum);
  }
  printf("%I64d\n", cnt);
  return 0;
}
