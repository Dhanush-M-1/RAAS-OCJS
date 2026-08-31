#include <bits/stdc++.h>
using namespace std;
class operation {
 public:
  int t, l, r, f;
};
int arr[5010], change[5010];
int n, m;
int main() {
  scanf("%d %d", &n, &m);
  operation op[6000];
  for (int i = 0; i < n; i++) {
    arr[i] = 1000000000;
    change[i] = 0;
  }
  for (int i = 0; i < m; i++) {
    scanf("%d %d %d %d", &op[i].t, &op[i].l, &op[i].r, &op[i].f);
    for (int j = op[i].l - 1; j < op[i].r; j++)
      if (op[i].t == 1)
        change[j] += op[i].f;
      else
        arr[j] = min(op[i].f - change[j], arr[j]);
  }
  bool valid = true;
  for (int i = 0; i < n; i++) change[i] = 0;
  for (int i = 0; i < m; i++)
    if (op[i].t == 1)
      for (int j = op[i].l - 1; j < op[i].r; j++) change[j] += op[i].f;
    else {
      int maxValue = -100000000;
      for (int j = op[i].l - 1; j < op[i].r; j++)
        maxValue = max(arr[j] + change[j], maxValue);
      if (maxValue != op[i].f) {
        valid = false;
        break;
      }
    }
  if (valid) {
    printf("YES\n%d", arr[0]);
    for (int i = 1; i < n; i++) printf(" %d", arr[i]);
    printf("\n");
  } else
    printf("NO\n");
  return 0;
}
