#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const int N = 4e5 + 4;
int main() {
  int n, k;
  scanf("%d", &n);
  scanf("%d", &k);
  int a[n];
  for (int i = 0; i < n; i++) scanf("%d", &a[i]);
  int sum = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] == 0 and sum < 0)
      sum = 0;
    else
      sum += a[i];
    if (sum > k) {
      printf("%d", -1);
      return 0;
    }
  }
  int ans = 0;
  sum = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] == 0 and sum < 0) {
      sum = k;
      ans++;
    }
    sum += a[i];
    if (sum > k) sum = k;
  }
  printf("%d", ans);
  return 0;
}
