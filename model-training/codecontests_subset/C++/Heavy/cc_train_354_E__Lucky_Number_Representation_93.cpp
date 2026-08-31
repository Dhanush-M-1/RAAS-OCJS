#include <bits/stdc++.h>
using namespace std;
char s[22];
int a[4][22];
int flag, n;
int jin, t;
void search(int i) {
  int jin2;
  if (flag) return;
  t = s[i] - '0' - jin;
  jin2 = 0;
  while (t < 0) {
    jin2++;
    t += 10;
  }
  if (i == 0) {
    if (jin2 > 0) return;
    if (t == 0) {
      a[0][0] = 6;
      a[1][0] = 0;
      a[2][0] = 0;
      flag = 1;
    } else if (t == 4) {
      a[0][0] = 5;
      a[1][0] = 1;
      a[2][0] = 0;
      flag = 1;
    } else if (t == 7) {
      a[0][0] = 5;
      a[1][0] = 0;
      a[2][0] = 1;
      flag = 1;
    } else if (t == 8) {
      a[0][0] = 4;
      a[1][0] = 2;
      a[2][0] = 0;
      flag = 1;
    }
    return;
  }
  if (t == 0) {
    jin = 0 + jin2;
    a[0][i] = 6;
    a[1][i] = 0;
    a[2][i] = 0;
    search(i - 1);
    if (flag) return;
    jin = 2 + jin2;
    a[0][i] = 1;
    a[1][i] = 5;
    a[2][i] = 0;
    search(i - 1);
    if (flag) return;
    jin = 3 + jin2;
    a[0][i] = 0;
    a[1][i] = 4;
    a[2][i] = 2;
    search(i - 1);
    if (flag) return;
  } else if (t == 1) {
    jin = 1 + jin2;
    a[0][i] = 4;
    a[1][i] = 1;
    a[2][i] = 1;
    search(i - 1);
    if (flag) return;
    jin = 2 + jin2;
    a[0][i] = 3;
    a[1][i] = 0;
    a[2][i] = 3;
    search(i - 1);
    if (flag) return;
  } else if (t == 2) {
    jin = 1 + jin2;
    a[0][i] = 3;
    a[1][i] = 3;
    a[2][i] = 0;
    search(i - 1);
    if (flag) return;
    jin = 2 + jin2;
    a[0][i] = 2;
    a[1][i] = 2;
    a[2][i] = 2;
    search(i - 1);
    if (flag) return;
    jin = 3 + jin2;
    a[0][i] = 1;
    a[1][i] = 1;
    a[2][i] = 4;
    search(i - 1);
    if (flag) return;
    jin = 4 + jin2;
    a[0][i] = 0;
    a[1][i] = 0;
    a[2][i] = 6;
    search(i - 1);
    if (flag) return;
  } else if (t == 3) {
    jin = 2 + jin2;
    a[0][i] = 1;
    a[1][i] = 4;
    a[2][i] = 1;
    search(i - 1);
    if (flag) return;
    jin = 3 + jin2;
    a[0][i] = 0;
    a[1][i] = 3;
    a[2][i] = 3;
    search(i - 1);
    if (flag) return;
  } else if (t == 4) {
    jin = 0 + jin2;
    a[0][i] = 5;
    a[1][i] = 1;
    a[2][i] = 0;
    search(i - 1);
    if (flag) return;
    jin = 2 + jin2;
    a[0][i] = 0;
    a[1][i] = 6;
    a[2][i] = 0;
    search(i - 1);
    if (flag) return;
    jin = 1 + jin2;
    a[0][i] = 4;
    a[1][i] = 0;
    a[2][i] = 2;
    search(i - 1);
    if (flag) return;
  } else if (t == 5) {
    jin = 1 + jin2;
    a[0][i] = 3;
    a[1][i] = 2;
    a[2][i] = 1;
    search(i - 1);
    if (flag) return;
    jin = 2 + jin2;
    a[0][i] = 2;
    a[1][i] = 1;
    a[2][i] = 3;
    search(i - 1);
    if (flag) return;
    jin = 3 + jin2;
    a[0][i] = 1;
    a[1][i] = 0;
    a[2][i] = 5;
    search(i - 1);
    if (flag) return;
  } else if (t == 6) {
    jin = 1 + jin2;
    a[0][i] = 2;
    a[1][i] = 4;
    a[2][i] = 0;
    search(i - 1);
    if (flag) return;
    jin = 2 + jin2;
    a[0][i] = 1;
    a[1][i] = 3;
    a[2][i] = 2;
    search(i - 1);
    if (flag) return;
    jin = 3 + jin2;
    a[0][i] = 0;
    a[1][i] = 2;
    a[2][i] = 4;
    search(i - 1);
    if (flag) return;
  } else if (t == 7) {
    jin = 0 + jin2;
    a[0][i] = 5;
    a[1][i] = 0;
    a[2][i] = 1;
    search(i - 1);
    if (flag) return;
    jin = 2 + jin2;
    a[0][i] = 0;
    a[1][i] = 5;
    a[2][i] = 1;
    search(i - 1);
    if (flag) return;
  } else if (t == 8) {
    jin = 0 + jin2;
    a[0][i] = 4;
    a[1][i] = 2;
    a[2][i] = 0;
    search(i - 1);
    if (flag) return;
    jin = 1 + jin2;
    a[0][i] = 3;
    a[1][i] = 1;
    a[2][i] = 2;
    search(i - 1);
    if (flag) return;
    jin = 2 + jin2;
    a[0][i] = 2;
    a[1][i] = 0;
    a[2][i] = 4;
    search(i - 1);
    if (flag) return;
  } else if (t == 9) {
    jin = 1 + jin2;
    a[0][i] = 2;
    a[1][i] = 3;
    a[2][i] = 1;
    search(i - 1);
    if (flag) return;
    jin = 2 + jin2;
    a[0][i] = 1;
    a[1][i] = 2;
    a[2][i] = 3;
    search(i - 1);
    if (flag) return;
    jin = 3 + jin2;
    a[0][i] = 0;
    a[1][i] = 1;
    a[2][i] = 5;
    search(i - 1);
    if (flag) return;
  }
}
int main() {
  int T;
  int i, j;
  unsigned long long re;
  unsigned long long sum;
  scanf("%d", &T);
  while (T--) {
    scanf("%s", s);
    sum = 0;
    n = strlen(s);
    flag = 0;
    jin = 0;
    search(n - 1);
    if (flag == 0)
      cout << -1 << endl;
    else {
      re = 0;
      for (i = 0; i < n; i++) {
        if (a[0][i] > 0) {
          re = re * 10 + 0;
          a[0][i]--;
        } else if (a[1][i] > 0) {
          re = re * 10 + 4;
          a[1][i]--;
        } else if (a[2][i] > 0) {
          re = re * 10 + 7;
          a[2][i]--;
        }
      }
      cout << re;
      sum += re;
      for (j = 1; j < 6; j++) {
        re = 0;
        for (i = 0; i < n; i++) {
          if (a[0][i] > 0) {
            re = re * 10 + 0;
            a[0][i]--;
          } else if (a[1][i] > 0) {
            re = re * 10 + 4;
            a[1][i]--;
          } else if (a[2][i] > 0) {
            re = re * 10 + 7;
            a[2][i]--;
          }
        }
        cout << ' ' << re;
        sum += re;
      }
      cout << endl;
    }
  }
  return 0;
}
