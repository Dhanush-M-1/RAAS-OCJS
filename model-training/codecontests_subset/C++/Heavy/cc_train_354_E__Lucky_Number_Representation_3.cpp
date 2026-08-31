#include <bits/stdc++.h>
using namespace std;
int T, cnt4[20], cnt7[20];
long long n, ans[20];
bool flag;
void dfs(long long n, int k) {
  if (n < 0 || flag) return;
  if (!n) {
    memset(ans, 0, sizeof ans);
    long long tmp = 1;
    flag = 1;
    for (int i = 0; i < k; i++) {
      for (int j = 1; j <= cnt4[i]; j++) ans[j] += 4 * tmp;
      for (int j = 1; j <= cnt7[i]; j++) ans[cnt4[i] + j] += 7 * tmp;
      tmp *= 10;
    }
    for (int i = 1; i <= 6; i++) printf("%I64d ", ans[i]);
    puts("");
    return;
  }
  for (int i = 0; i <= 6; i++)
    for (int j = 0; i + j <= 6; j++)
      if ((4 * i + 7 * j) % 10 == n % 10) {
        cnt4[k] = i;
        cnt7[k] = j;
        dfs(n / 10 - (4 * i + 7 * j) / 10, k + 1);
      }
}
int main() {
  scanf("%d", &T);
  while (T--) {
    scanf("%I64d", &n);
    flag = 0;
    dfs(n, 0);
    if (!flag) puts("-1");
  }
  return 0;
}
