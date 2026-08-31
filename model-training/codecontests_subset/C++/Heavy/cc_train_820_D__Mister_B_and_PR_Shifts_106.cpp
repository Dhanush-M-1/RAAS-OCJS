#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 100;
int a[maxn];
int change[maxn];
int main() {
  int n;
  int down, up;
  while (scanf("%d", &n) != EOF) {
    memset(change, 0, sizeof(change));
    for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
    long long sum = 0;
    long long down = up = 0;
    for (int i = 1; i <= n; i++) {
      change[(a[i] - i + n) % n]++;
      if (a[i] > i)
        down++;
      else if (a[i] <= i)
        up++;
      sum += abs(a[i] - i);
    }
    long long ans = sum;
    long long pos = 0;
    for (int i = 1; i < n; i++) {
      sum = sum + up - down - 1;
      sum = sum + 2 * a[(n - i) % n + 1] - n - 1;
      up--;
      down++;
      up += change[i];
      down -= change[i];
      if (sum < ans) {
        ans = sum;
        pos = i;
      }
    }
    printf("%I64d %I64d\n", ans, pos);
  }
  return 0;
}
