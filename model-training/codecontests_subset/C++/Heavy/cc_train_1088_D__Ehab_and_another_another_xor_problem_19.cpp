#include <bits/stdc++.h>
using namespace std;
const int N = 1100000;
int mod = 998244353;
int ask(int a, int b) {
  printf("? %d %d\n", a, b);
  fflush(stdout);
  int t;
  scanf("%d", &t);
  return t;
}
void sol() {
  int ax = 0, bx = 0;
  int flag = -2;
  for (int i = 29; i >= 0; --i) {
    int a1 = ax | (1 << i);
    int b1 = bx | (1 << i);
    int ret = ask(a1, bx);
    if (ret == 1) {
      int ret = ask(ax, b1);
      if (ret == -1) {
        continue;
      }
      if (flag == -2) {
        flag = ask(ax, bx);
      }
      if (flag == 1) {
        ax = a1;
        flag = 1;
      } else if (flag == -1) {
        bx = b1;
        flag = 1;
      }
    } else if (ret == -1) {
      int ret = ask(ax, b1);
      if (ret == 1) {
        ax = a1;
        bx = b1;
        continue;
      } else {
        if (flag == -2) {
          flag = ask(ax, bx);
        }
        if (flag == 1) {
          ax = a1;
          flag = -1;
        } else if (flag == -1) {
          bx = b1;
          flag = -1;
        }
      }
    } else if (ret == 0) {
      if (flag == -2) {
        flag = ask(ax, bx);
      }
      if (flag == -1) {
        bx = b1;
        flag = 0;
      } else if (flag == 1) {
        ax = a1;
        flag = 0;
      } else if (flag == 0) {
      }
    }
  }
  printf("! %d %d\n", ax, bx);
  fflush(stdout);
}
int main() { sol(); }
