#include <bits/stdc++.h>
using namespace std;
void ask0(int idx);
void askn1(int idx);
int C = 0, D = 0;
void ask1(int idx) {
  if (idx == -1) {
    return;
  }
  int x = (C | (1 << idx)), y = (D | (1 << idx));
  printf("? %d %d\n", x, y);
  fflush(stdout);
  int T;
  scanf("%d", &T);
  if (T == 1) {
    y = D;
    printf("? %d %d\n", x, y);
    fflush(stdout);
    int R;
    scanf("%d", &R);
    if (R == -1) {
      C |= (1 << idx);
      D |= (1 << idx);
    }
    ask1(idx - 1);
  } else {
    C = x;
    int t;
    printf("? %d %d\n", C, D);
    fflush(stdout);
    scanf("%d", &t);
    if (t == 1) {
      ask1(idx - 1);
    } else if (t == 0) {
      ask0(idx - 1);
    } else {
      askn1(idx - 1);
    }
  }
}
void ask0(int idx) {
  if (idx == -1) {
    return;
  }
  int x = (C | (1 << idx));
  printf("? %d %d\n", x, D);
  fflush(stdout);
  int T;
  scanf("%d", &T);
  if (T == -1) {
    C = x;
    D |= (1 << idx);
  }
  ask0(idx - 1);
}
void askn1(int idx) {
  if (idx == -1) {
    return;
  }
  int x = (C | (1 << idx)), y = (D | (1 << idx));
  printf("? %d %d\n", x, y);
  fflush(stdout);
  int T;
  scanf("%d", &T);
  if (T == -1) {
    y = D;
    printf("? %d %d\n", x, y);
    fflush(stdout);
    int R;
    scanf("%d", &R);
    if (R == -1) {
      C |= (1 << idx);
      D |= (1 << idx);
    }
    askn1(idx - 1);
  } else {
    D = y;
    int t;
    printf("? %d %d\n", C, D);
    fflush(stdout);
    scanf("%d", &t);
    if (t == 1) {
      ask1(idx - 1);
    } else if (t == 0) {
      ask0(idx - 1);
    } else {
      askn1(idx - 1);
    }
  }
}
int main() {
  printf("? %d %d\n", C, D);
  fflush(stdout);
  int t;
  scanf("%d", &t);
  if (t == 1) {
    ask1(29);
  } else if (t == 0) {
    ask0(29);
  } else {
    askn1(29);
  }
  printf("! %d %d\n", C, D);
  return 0;
}
