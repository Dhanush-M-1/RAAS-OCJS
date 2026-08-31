#include <bits/stdc++.h>
using namespace std;
const int N = 30;
int a[35], b[35];
int nowa, nowb;
int T = 0;
void smaller(int x);
int query(int a, int b, int type = 0) {
  if (type) {
    printf("! %d %d\n", a, b);
    fflush(stdout);
    return 0;
  }
  T++;
  if (T > 62) assert(false);
  printf("? %d %d\n", a, b);
  fflush(stdout);
  int t;
  scanf("%d", &t);
  return t;
}
void getans() {
  int ansa = 0, ansb = 0;
  for (int i = 0; i < N; i++) {
    ansa = ansa * 2 + a[i];
    ansb = ansb * 2 + b[i];
  }
  query(ansa, ansb, 1);
}
void equall(int x) {
  for (int i = x; i < N; i++) {
    nowa |= (1 << (N - 1 - i));
    int t = query(nowa, nowb);
    if (t < 0)
      a[i] = b[i] = 1;
    else
      a[i] = b[i] = 0;
    nowb |= (1 << (N - 1 - i));
  }
  getans();
}
void bigger(int x) {
  if (x == N) {
    getans();
    return;
  }
  nowb |= (1 << (N - 1 - x));
  int t = query(nowa, nowb);
  if (t > 0) {
    nowa |= (1 << (N - 1 - x));
    nowb ^= (1 << (N - 1 - x));
    t = query(nowa, nowb);
    if (t == 0) {
      a[x] = 1;
      b[x] = 0;
      equall(x + 1);
    }
    if (t > 0) {
      a[x] = 1;
      b[x] = 0;
      bigger(x + 1);
    }
    if (t < 0) {
      a[x] = 1;
      b[x] = 1;
      nowa ^= (1 << (N - 1 - x));
      bigger(x + 1);
    }
  } else if (t < 0) {
    nowa |= (1 << (N - 1 - x));
    nowb ^= (1 << (N - 1 - x));
    t = query(nowa, nowb);
    if (t == 0) {
      a[x] = 1;
      b[x] = 0;
      equall(x + 1);
    }
    if (t < 0) {
      a[x] = 1;
      b[x] = 0;
      smaller(x + 1);
    }
    if (t > 0) {
      a[x] = 0;
      b[x] = 0;
      nowa ^= (1 << (N - 1 - x));
      bigger(x + 1);
    }
  } else {
    a[x] = 1;
    b[x] = 0;
    equall(x + 1);
  }
}
void smaller(int x) {
  if (x == N) {
    getans();
    return;
  }
  nowb |= (1 << (N - 1 - x));
  int t = query(nowa, nowb);
  if (t > 0) {
    nowa |= (1 << (N - 1 - x));
    nowb ^= (1 << (N - 1 - x));
    t = query(nowa, nowb);
    if (t == 0) {
      a[x] = 0;
      b[x] = 1;
      equall(x + 1);
    }
    if (t > 0) {
      a[x] = 0;
      b[x] = 1;
      bigger(x + 1);
    }
    if (t < 0) {
      a[x] = 1;
      b[x] = 1;
      nowa ^= (1 << (N - 1 - x));
      smaller(x + 1);
    }
  } else if (t < 0) {
    nowa |= (1 << (N - 1 - x));
    nowb ^= (1 << (N - 1 - x));
    t = query(nowa, nowb);
    if (t == 0) {
      a[x] = 0;
      b[x] = 1;
      equall(x + 1);
    }
    if (t < 0) {
      a[x] = 0;
      b[x] = 1;
      smaller(x + 1);
    }
    if (t > 0) {
      a[x] = 0;
      b[x] = 0;
      nowa ^= (1 << (N - 1 - x));
      smaller(x + 1);
    }
  } else {
    a[x] = 0;
    b[x] = 1;
    equall(x + 1);
  }
}
int main() {
  int t = query(0, 0);
  if (t == 0) {
    equall(0);
  }
  if (t > 0) bigger(0);
  if (t < 0) smaller(0);
  return 0;
}
