#include <bits/stdc++.h>
using namespace std;
int n;
int a[300005], pos[300005];
int lowbit(int now) { return now & (-now); }
long long sum[5][300005];
void add(int flag, int now, int val) {
  for (int i = now; i <= n; i += lowbit(i)) sum[flag][i] += val;
}
long long query(int flag, int now) {
  long long ans = 0;
  for (int i = now; i; i -= lowbit(i)) ans += sum[flag][i];
  return ans;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]), pos[a[i]] = i;
  long long ans1 = 0;
  for (int i = 1; i <= n; i++) {
    ans1 += (i - 1 - query(1, pos[i]));
    add(1, pos[i], 1);
    add(2, pos[i], pos[i]);
    int nl = 1, nr = n, ans = 1;
    while (nl <= nr) {
      if (query(1, ((nl + nr) >> 1)) * 2 <= i) {
        ans = ((nl + nr) >> 1);
        nl = ((nl + nr) >> 1) + 1;
      } else
        nr = ((nl + nr) >> 1) - 1;
    }
    long long cnt1 = query(1, ans), cnt2 = i - cnt1;
    long long res1 =
        ans * cnt1 - query(2, ans) - (1 + cnt1 - 1) * (cnt1 - 1) / 2;
    long long res2 = (query(2, n) - query(2, ans)) - ((ans + 1) * cnt2) -
                     (cnt2) * (cnt2 - 1) / 2;
    printf("%lld ", ans1 + res1 + res2);
  }
}
