#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2000000;
const long long INF = 1000000000000000000;
long long n;
long long p[MAXN + 10];
long long f[MAXN + 10];
int main() {
  scanf("%I64d", &n);
  long long sum = 0, py = 0;
  for (int i = 1; i <= n; ++i) {
    scanf("%I64d", p + i);
    if (i > p[i]) {
      sum += i - p[i];
      ++py;
      f[p[i] + n - i] += 2;
    } else {
      sum += p[i] - i;
      --py;
      f[p[i] - i] += 2;
    }
  }
  long long mmin = sum, r = 0;
  for (int i = 1; i < n; ++i) {
    py += f[i - 1] - 2;
    sum += py + 1;
    sum += abs(p[n - i + 1] - 1) - abs(p[n - i + 1] - n);
    if (sum < mmin) {
      mmin = sum;
      r = i;
    }
  }
  printf("%I64d %I64d", mmin, r);
  return 0;
}
