#include <bits/stdc++.h>
using namespace std;
struct jg {
  int x, y, z;
};
jg a[200001];
int n, k, t1, t2, t3, mx, ans[200001], sum[200001], ans1[200001];
bool bj1[200001], bj2;
int main() {
  int i, j;
  cin >> n >> k;
  for (i = 1; i <= n; i++) {
    scanf("%d%d%d", &a[i].x, &a[i].y, &a[i].z);
    if (a[i].y == 1 && a[i].z == 0) {
      t1++;
      ans[t1] = a[i].x;
    }
    if (a[i].y == 0 && a[i].z == 1) {
      t2++;
      sum[t2] = a[i].x;
    }
    if (a[i].y == 1 && a[i].z == 1) {
      t3++;
      ans1[t3] = a[i].x;
    }
  }
  sort(ans + 1, ans + t1 + 1);
  sort(sum + 1, sum + t2 + 1);
  for (i = 1; i <= min(t1, t2); i++) {
    t3++;
    ans1[t3] = ans[i] + sum[i];
  }
  if (t3 < k) {
    cout << -1 << endl;
    return 0;
  }
  sort(ans1 + 1, ans1 + t3 + 1);
  for (i = 1; i <= k; i++) {
    mx += ans1[i];
  }
  cout << mx << endl;
  return 0;
}
