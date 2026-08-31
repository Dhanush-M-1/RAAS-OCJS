#include <bits/stdc++.h>
using namespace std;
struct Operation {
  int t, l, r, v;
};
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  vector<Operation> ops(m);
  vector<int> a(n, 1e9);
  vector<int> change(n);
  for (int j = 0; j < m; j++) {
    Operation &op = ops[j];
    scanf("%d%d%d%d", &op.t, &op.l, &op.r, &op.v);
    op.l--;
    op.r--;
    if (op.t == 1) {
      for (int i = op.l; i <= op.r; i++) change[i] += op.v;
    } else {
      for (int i = op.l; i <= op.r; i++) a[i] = min(a[i], op.v - change[i]);
    }
  }
  vector<int> b(a);
  for (int j = 0; j < m; j++) {
    Operation &op = ops[j];
    if (op.t == 1) {
      for (int i = op.l; i <= op.r; i++) b[i] += op.v;
    } else {
      if (op.v != *max_element(b.begin() + op.l, b.begin() + op.r + 1)) {
        puts("NO");
        return 0;
      }
    }
  }
  puts("YES");
  for (int i = 0; i < n; i++) {
    printf("%d ", a[i]);
  }
  puts("");
}
