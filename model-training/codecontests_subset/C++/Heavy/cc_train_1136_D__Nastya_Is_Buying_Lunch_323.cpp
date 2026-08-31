#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, int> mp1;
int a[300005];
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; i++) scanf("%d", &a[i]);
  for (int i = 0; i < m; i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    mp1[make_pair(u, v)] = 1;
  }
  int last = n - 1;
  for (int i = n - 2; i >= 0; i--) {
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
  printf("%d\n", n - 1 - last);
  return 0;
}
