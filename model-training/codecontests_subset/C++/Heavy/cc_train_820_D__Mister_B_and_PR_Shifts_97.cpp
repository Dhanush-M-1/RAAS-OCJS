#include <bits/stdc++.h>
using namespace std;
int p[1000010], n;
long long hold[1000010], sum, res, ind;
int main() {
  sum = ind = res = 0;
  memset(hold, 0, sizeof(hold));
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", p + i);
    if (p[i] > i) {
      hold[1]--;
      hold[p[i] - i + 1] += 2;
      hold[p[i] - i + 1 + n - p[i]]--;
      hold[p[i] - i + 1 + n - p[i] + 1]--;
      sum += ((long long)p[i] - (long long)i);
    } else {
      hold[1]++;
      hold[n - i + 1]--;
      hold[n - i + 2]--;
      hold[n - i + 2 + p[i] - 1] += 2;
      sum += ((long long)i - (long long)p[i]);
    }
  }
  res = sum;
  ind = 0;
  for (int i = 1; i <= n; i++) {
    hold[i] += hold[i - 1];
  }
  hold[n] = 0;
  for (int i = 1; i < n; i++) {
    sum += hold[i];
    sum += (p[n - i + 1] - 1 - abs(p[n - i + 1] - n));
    if (sum < res) {
      res = sum;
      ind = i;
    }
  }
  printf("%lld %lld", res, ind);
  return 0;
}
