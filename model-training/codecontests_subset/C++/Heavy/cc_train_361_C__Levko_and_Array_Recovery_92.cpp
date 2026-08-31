#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  vector<int> a(n, 1e9), memo(n, 0);
  vector<int> t(m), d(m), l(m), r(m);
  for (int i = 0; i < m; i++) {
    scanf("%d%d%d%d", &t[i], &l[i], &r[i], &d[i]);
    l[i]--;
    if (t[i] == 1) {
      for (int j = l[i]; j < r[i]; j++) memo[j] += d[i];
    } else {
      for (int j = l[i]; j < r[i]; j++) a[j] = min(a[j], d[i] - memo[j]);
    }
  }
  vector<int> ans = a;
  for (int i = 0; i < m; i++) {
    if (t[i] == 1) {
      for (int j = l[i]; j < r[i]; j++) a[j] += d[i];
    } else {
      if (*max_element(a.begin() + l[i], a.begin() + r[i]) != d[i]) {
        puts("NO");
        return 0;
      }
    }
  }
  puts("YES");
  for (int i = 0; i < ((int)(ans).size()); i++) {
    printf("%d ", ans[i]);
  }
  puts("");
  return 0;
}
