#include <bits/stdc++.h>
using namespace std;
long long int arr[100005], p[100005], hi[100005];
int main() {
  long long int n, d, res = 0, sum = 0;
  scanf("%lld%lld", &n, &d);
  for (long long int i = 1; i <= n; i++) scanf("%lld", &arr[i]);
  for (long long int i = 1; i <= n; i++) {
    p[i] = p[i - 1] + arr[i];
    if (p[i] > d) {
      printf("-1");
      exit(0);
    }
  }
  hi[n] = p[n];
  for (long long int i = n - 1; i >= 0; i--) hi[i] = max(p[i], hi[i + 1]);
  for (long long int i = 1; i <= n; i++)
    if (arr[i] == 0 && p[i] + sum < 0) {
      if (d < hi[i] - p[i]) {
        printf("-1");
        exit(0);
      }
      sum += d - hi[i] - sum;
      res++;
    }
  printf("%lld", res);
}
