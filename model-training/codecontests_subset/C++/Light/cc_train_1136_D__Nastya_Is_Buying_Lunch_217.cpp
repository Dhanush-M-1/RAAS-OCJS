#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, int> ma;
int a[300005];
int main() {
  int n, m, x, y;
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; i++) scanf("%d", &a[i]);
  for (int i = 1; i <= m; i++) {
    scanf("%d %d", &x, &y);
    ma[make_pair(x, y)] = 1;
  }
  int last = n - 1;
  for (int i = n - 2; i >= 0; i--) {
    if (ma[make_pair(a[i], a[last])]) {
      int j;
      for (j = i; j < last; j++) {
        if (ma[make_pair(a[j], a[j + 1])]) {
          swap(a[j], a[j + 1]);
        } else
          break;
      }
      if (j == last) last--;
    }
  }
  printf("%d\n", n - 1 - last);
  return 0;
}
