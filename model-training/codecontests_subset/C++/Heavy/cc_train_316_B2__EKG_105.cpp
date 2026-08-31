#include <bits/stdc++.h>
using namespace std;
int d[1002], a[1002], p[1002], p1[1002], used[1002], us[1002];
vector<int> vec;
int main() {
  int n, x, k, l = 0, m, i, j, top, f;
  scanf("%d%d", &n, &x);
  m = x;
  for (i = 1; i <= n; i++) {
    scanf("%d", &p1[i]);
    if (p1[i] != 0) p[p1[i]] = i;
  }
  k = 1;
  while (p1[x] != 0) k++, x = p1[x];
  top = k;
  for (i = 1; i <= n; i++)
    if (p1[i] == 0) {
      j = i;
      k = 1;
      f = 0;
      while (p[j] != 0) {
        if (j == m) f = 1;
        used[j] = 1;
        k++;
        j = p[j];
      }
      used[j] = 1;
      if (j == m) f = 1;
      if (!f) l++, a[l] = k;
    }
  d[0] = 1;
  for (i = 1; i <= l; i++)
    for (j = n; j >= a[i]; j--)
      if (d[j - a[i]]) {
        if (!us[j]) vec.push_back(j + top);
        us[j] = 1;
        d[j] = 1;
      }
  vec.push_back(top);
  sort(vec.begin(), vec.end());
  for (i = 0; i < vec.size(); i++) printf("%d\n", vec[i]);
}
