#include <bits/stdc++.h>
using namespace std;
int N, M;
int cmp[35][2][2];
int ans[35][2];
int main() {
  memset(cmp, 1, sizeof(cmp));
  int base0 = 0;
  int base1 = 0;
  for (int i = 29; i >= 0; i--) {
    if (cmp[i][0][0] == (16843009)) {
      ++N;
      printf("? %d %d\n", base0, base1);
      fflush(stdout);
      cin >> cmp[i][0][0];
    }
    if (cmp[i][0][0] == 0) {
      if (i > 1) cmp[i - 1][0][0] = cmp[i][0][0];
      ++N;
      printf("? %d %d\n", base0 + (1 << i), base1);
      fflush(stdout);
      cin >> cmp[i][1][0];
      if (cmp[i][1][0] == 1)
        ans[i][0] = ans[i][1] = 0;
      else
        ans[i][0] = ans[i][1] = 1, base0 += (1 << i), base1 += (1 << i);
      continue;
    }
    ++N;
    printf("? %d %d\n", base0 + (1 << i), base1 + (1 << i));
    fflush(stdout);
    cin >> cmp[i][1][1];
    if (cmp[i][0][0] == cmp[i][1][1]) {
      ++N;
      printf("? %d %d\n", base0 + (1 << i), base1);
      fflush(stdout);
      cin >> cmp[i][1][0];
      if (cmp[i][1][0] == 1)
        ans[i][0] = ans[i][1] = 0;
      else
        ans[i][0] = ans[i][1] = 1, base0 += (1 << i), base1 += (1 << i);
      if (i > 1) cmp[i - 1][0][0] = cmp[i][0][0];
    } else {
      if (cmp[i][0][0] == 1)
        ans[i][0] = 1, ans[i][1] = 0, base0 += (1 << i);
      else
        ans[i][0] = 0, ans[i][1] = 1, base1 += (1 << i);
    }
  }
  int a = 0, b = 0;
  for (int i = 29; i >= 0; i--) {
    if (ans[i][0]) a += (1 << i);
    if (ans[i][1]) b += (1 << i);
  }
  printf("! %d %d\n", a, b);
  fflush(stdout);
  return 0;
}
