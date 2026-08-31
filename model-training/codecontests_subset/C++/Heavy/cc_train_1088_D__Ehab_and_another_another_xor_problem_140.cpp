#include <bits/stdc++.h>
using namespace std;
int ans[2];
void solve(int t) {
  int x;
  for (int i = t; i >= 0; i--) {
    printf("? %d %d\n", ans[0] | (1 << i), ans[1]);
    cin >> x;
    if (x == -1) {
      ans[0] |= (1 << i);
      ans[1] |= (1 << i);
    }
  }
  return;
}
int main() {
  int x, flag = 0;
  printf("? 0 0\n");
  cin >> flag;
  for (int i = 29; i >= 0; i--) {
    printf("? %d %d\n", ans[0] | (1 << i), ans[1] | (1 << i));
    cin >> x;
    if (x == 0) {
      solve(i);
      break;
    }
    if (x == flag) {
      printf("? %d %d\n", ans[0] | (1 << i), ans[1]);
      cin >> x;
      if (x == -1) {
        ans[0] |= (1 << i);
        ans[1] |= (1 << i);
      }
    } else {
      if (x == 1) {
        ans[1] |= (1 << i);
        printf("? %d %d\n", ans[0], ans[1]);
        cin >> flag;
      } else {
        ans[0] |= (1 << i);
        printf("? %d %d\n", ans[0], ans[1]);
        cin >> flag;
      }
    }
  }
  printf("! %d %d\n", ans[0], ans[1]);
  return 0;
}
