#include <bits/stdc++.h>
using namespace std;
int ques(int a, int b) {
  printf("? %d %d\n", a, b);
  fflush(stdout);
  int rep = 0;
  scanf("%d", &rep);
  assert(rep != -2);
  return rep;
}
int main() {
  int c = 0, d = 0;
  int a = 0, b = 0;
  int i = 29;
  while (i >= 0) {
    printf("? %d %d\n", a, b);
    fflush(stdout);
    int rep1 = 0;
    scanf("%d", &rep1);
    assert(rep1 != -2);
    if (rep1 == 1) {
      bool flag = false;
      for (; i >= 0; i--) {
        if (flag == false) {
          c = ((1 << i) | a);
          d = ((1 << i) | b);
          printf("? %d %d\n", c, d);
          fflush(stdout);
          int rep = 0;
          scanf("%d", &rep);
          assert(rep != -2);
          if (rep == rep1) {
            c = ((1 << i) | a);
            d = (0 | b);
            int rep2 = ques(c, d);
            if (rep2 == -1) {
              b |= (1 << i);
              a |= (1 << i);
            }
          } else {
            flag = true;
            a |= (1 << i);
            i--;
            break;
          }
        }
      }
    } else if (rep1 == -1) {
      bool flag = false;
      for (; i >= 0; i--) {
        if (flag == false) {
          c = ((1 << i) | a);
          d = ((1 << i) | b);
          printf("? %d %d\n", c, d);
          fflush(stdout);
          int rep = 0;
          scanf("%d", &rep);
          assert(rep != -2);
          if (rep == rep1) {
            c = ((1 << i) | a);
            d = (0 | b);
            int rep2 = ques(c, d);
            if (rep2 == -1) {
              b |= (1 << i);
              a |= (1 << i);
            }
          } else {
            flag = true;
            b |= (1 << i);
            i--;
            break;
          }
        }
      }
    } else if (rep1 == 0) {
      for (; i >= 0; i--) {
        c = (0 | a);
        d = ((1 << i) | b);
        int rep2 = ques(c, d);
        if (rep2 == 1) {
          a |= (1 << i);
          b |= (1 << i);
        }
      }
    }
  }
  printf("! %d %d\n", a, b);
}
