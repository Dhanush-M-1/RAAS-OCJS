#include <bits/stdc++.h>
using namespace std;
const int maxN = 1e6 + 10;
int n;
int p[maxN], value[3 * maxN];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%d", p + i);
  long long sum = 0;
  int positive = 0, negative = 0;
  for (int i = 1; i <= n; ++i) {
    sum += abs(p[i] - i);
    value[p[i] - i + maxN]++;
    if (p[i] <= i)
      negative++;
    else
      positive++;
  }
  long long maxValue = sum, pos = 0;
  for (int i = 1; i < n; ++i) {
    sum += negative;
    sum -= positive;
    sum -= (n + 1 - p[n - i + 1]);
    sum += (p[n - i + 1] - 1);
    if (sum < maxValue) {
      maxValue = sum;
      pos = i;
    }
    negative += value[maxN + i];
    positive -= value[maxN + i];
    value[maxN + p[n - i + 1] - (n - i + 1)]--;
    value[maxN + p[n - i + 1] + i - 1]++;
    if (p[n - i + 1] != 1) {
      positive++;
      negative--;
    }
  }
  printf("%I64d %d\n", maxValue, pos);
  return 0;
}
