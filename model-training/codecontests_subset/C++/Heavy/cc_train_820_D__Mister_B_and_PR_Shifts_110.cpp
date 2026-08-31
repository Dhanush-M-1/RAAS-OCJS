#include <bits/stdc++.h>
using namespace std;
long long ans[1000005], num[1000005];
int main() {
  int n;
  long long minn, x;
  int temp;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &x);
    num[i] = x;
    if (i < x) {
      ans[1]--;
      ans[x - i + 1]++;
      ans[x - i + 1]++;
      ans[n - i + 1]--;
      ans[n - i + 1] += 2 * x - 1 - n;
      ans[n - i + 2] -= 2 * x - 1 - n;
      ans[n - i + 2]--;
    } else {
      ans[1]++;
      ans[n - i + 1]--;
      ans[n - i + 1] += 2 * x - 1 - n;
      ans[n - i + 2] -= 2 * x - 1 - n;
      ans[n - i + 2]--;
      ans[n - i + x + 1]++;
      ans[n - i + x + 1]++;
    }
  }
  for (int i = 1; i < n; i++) ans[i] += ans[i - 1];
  for (int i = 1; i <= n; i++) ans[0] += abs(i - num[i]);
  temp = 0;
  minn = ans[0];
  for (int i = 1; i < n; i++) {
    ans[i] += ans[i - 1];
    if (ans[i] < minn) {
      minn = ans[i];
      temp = i;
    }
  }
  printf("%lld %d\n", minn, temp);
  return 0;
}
