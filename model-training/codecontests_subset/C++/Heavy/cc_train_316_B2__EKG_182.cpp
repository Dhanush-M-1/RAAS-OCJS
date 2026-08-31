#include <bits/stdc++.h>
using namespace std;
long n, x, nums, num[10000], qq[10000], deep[10000], q, cn[10000], sz[10000],
    usd[10000];
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n >> x;
  nums = 0;
  for (int i = 1; i <= n; i++) {
    cin >> qq[i];
    q = qq[i];
    if (q == 0) {
      num[i] = nums + 1;
      nums++;
      sz[nums] = 1;
      deep[i] = 1;
    }
    if (i == x) usd[num[i]] = 1;
  }
  for (int iter = 1; iter <= 1000; iter++)
    for (int i = 1; i <= n; i++)
      if (deep[qq[i]] > 0 && deep[i] == 0) {
        q = qq[i];
        num[i] = num[q];
        sz[num[i]]++;
        deep[i] = deep[q] + 1;
        if (i == x) usd[num[i]] = 1;
      }
  cn[deep[x]] = 1;
  for (int i = 1; i <= nums; i++)
    if (usd[i] == 0)
      for (int j = 1000; j >= 0; --j)
        if (cn[j]) cn[j + sz[i]] = 1;
  for (int i = 1; i <= 1000; i++)
    if (cn[i]) cout << i << endl;
  cin.get();
  cin.get();
  return 0;
}
