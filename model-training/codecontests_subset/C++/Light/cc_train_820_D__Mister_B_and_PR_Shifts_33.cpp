#include <bits/stdc++.h>
using namespace std;
int a[1000005];
int b[1000005];
int main() {
  int n;
  scanf("%d", &n);
  long long ans = 0;
  int cnt1 = 0, cnt2;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    if (a[i] > i) {
      b[a[i] - i]++;
      cnt1++;
    } else {
      b[a[i] - i + n]++;
    }
    ans += abs(a[i] - i);
  }
  long long tmp = ans;
  int id = 0;
  for (int i = 1; i < n; i++) {
    int cnt2 = n - cnt1;
    tmp += (a[n - i + 1] - 1) + (cnt2 - cnt1 + (-(n - a[n - i + 1]))) - 1;
    cnt1 -= b[i];
    cnt1++;
    if (tmp < ans) {
      ans = tmp;
      id = i;
    }
  }
  printf("%I64d %d\n", ans, id);
  return 0;
}
