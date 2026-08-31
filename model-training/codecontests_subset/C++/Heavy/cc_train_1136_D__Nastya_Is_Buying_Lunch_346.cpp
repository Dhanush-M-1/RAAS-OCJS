#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, int> mp1;
int a[300005];
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    mp1[make_pair(u, v)] = 1;
  }
  int last = n;
  for (int i = n - 1; i >= 1; i--) {
    if (mp1[make_pair(a[i], a[last])]) {
      int j;
      for (j = i; j < last; ++j) {
        if (mp1[make_pair(a[j], a[j + 1])]) {
          swap(a[j], a[j + 1]);
        } else
          break;
      }
      if (j == last) {
        --last;
      }
    }
  }
  printf("%d\n", n - last);
  return 0;
}
