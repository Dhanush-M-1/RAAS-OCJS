#include <bits/stdc++.h>
using namespace std;
int n, m, a, b;
bool is[110] = {false};
int main() {
  scanf("%d%d", &n, &m);
  while (n--) {
    scanf("%d", &a);
    while (a--) {
      scanf("%d", &b);
      is[b] = true;
    }
  }
  bool flag = true;
  for (int i = 1; i <= m; i++) {
    if (!is[i]) {
      flag = false;
      break;
    }
  }
  if (flag) {
    printf("YES\n");
  } else {
    printf("NO\n");
  }
  return 0;
}
