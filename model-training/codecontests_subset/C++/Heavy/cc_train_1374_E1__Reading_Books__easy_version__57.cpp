#include <bits/stdc++.h>
#pragma GCC optimize("02")
#pragma G++ optimize("03")
using namespace std;
const int N = 2e5 + 5;
int n, k, type1[N], type2[N], type3[N];
int main() {
  scanf("%d%d", &n, &k);
  int cnt1 = 0, cnt2 = 0, cnt3 = 0;
  for (int i = 1; i <= n; i++) {
    int val, a, b;
    scanf("%d%d%d", &val, &a, &b);
    if (!a && !b) continue;
    if (a && b) type1[++cnt1] = val;
    if (a && !b) type2[++cnt2] = val;
    if (!a && b) type3[++cnt3] = val;
  }
  sort(type1 + 1, type1 + 1 + cnt1);
  sort(type2 + 1, type2 + 1 + cnt2);
  sort(type3 + 1, type3 + 1 + cnt3);
  for (int i = 1; i <= min(cnt2, cnt3); i++)
    type1[++cnt1] = type2[i] + type3[i];
  sort(type1 + 1, type1 + 1 + cnt1);
  if (cnt1 < k)
    puts("-1");
  else {
    int res = 0;
    for (int i = 1; i <= k; i++) res += type1[i];
    printf("%d\n", res);
  }
  return 0;
}
