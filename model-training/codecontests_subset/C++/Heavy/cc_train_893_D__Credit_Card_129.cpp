#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5, inf = 0x3f3f3f3f;
long long n, d, a[N];
long long f[N], w[N], mk[N];
int main() {
  cin >> n >> d;
  for (int i = 1; i <= n; i++) scanf("%I64d", &a[i]);
  bool flag = true;
  long long sum = 0;
  for (int i = 1; i <= n; i++) {
    sum += a[i];
    if (sum > d) flag = false;
    if (a[i] == 0 && sum < 0) sum = 0, mk[i] = -1;
    w[i] = sum;
  }
  if (flag == false)
    puts("-1");
  else {
    sum = 0;
    for (int i = n; i >= 1; i--) {
      if (mk[i + 1] == -1)
        f[i] = w[i];
      else
        f[i] = max(f[i + 1], w[i]);
    }
    long long ans = 0, val = 0;
    for (int i = 1; i <= n; i++) {
      sum += a[i];
      if (a[i] == 0 && sum < 0) {
        ans++;
        long long exd = max(0ll, d - f[i]);
        sum = exd;
      }
    }
    printf("%I64d\n", ans);
  }
  return 0;
}
