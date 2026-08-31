#include <bits/stdc++.h>
using namespace std;
const int N = 2e6 + 10;
int z[N], f[N], p[N], n;
int sum[N * 4];
void update(int i, int v) {
  for (; i < n * 4; i += (i & -i)) sum[i] += v;
}
int getsum(int i) {
  int ans = 0;
  for (; i; i -= (i & -i)) ans += sum[i];
  return ans;
}
int main() {
  memset(sum, 0, sizeof(sum));
  scanf("%d", &n);
  long long int tmp = 0, tem = 0;
  int ans = 0, dd = n;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &p[i]);
    tmp += ((p[i] - i) > 0 ? (p[i] - i) : -(p[i] - i));
    update(p[i] - i + n, 1);
  }
  tem = tmp;
  for (int i = 2; i <= n; i++) {
    tem -= ((p[n - i + 2] - n) > 0 ? (p[n - i + 2] - n) : -(p[n - i + 2] - n));
    tem += ((p[n - i + 2] - 1) > 0 ? (p[n - i + 2] - 1) : -(p[n - i + 2] - 1));
    update(p[n - i + 2] - (n - i + 2) + n, -1);
    int t = getsum(dd);
    tem += t;
    tem -= n - 1 - t;
    dd++;
    update(p[n - i + 2] - 1 + dd, 1);
    if (tem < tmp) {
      tmp = tem;
      ans = i - 1;
    }
  }
  printf("%lld %d\n", tmp, ans);
  return 0;
}
