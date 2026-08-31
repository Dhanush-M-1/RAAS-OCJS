#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const long long INF = 0x3f3f3f3f3f3f3f3fLL;
const double pi = acos(-1.0);
const int maxn = 100000 + 10;
const int mod = 1e9 + 7;
inline char _getchar() {
  static const int BUFSIZE = 100001;
  static char buf[BUFSIZE];
  static char *psta = buf, *pend = buf;
  if (psta >= pend) {
    psta = buf;
    pend = buf + fread(buf, 1, BUFSIZE, stdin);
    if (psta >= pend) return -1;
  }
  return *psta++;
}
inline int read(int &x) {
  x = 0;
  int f = 1;
  char ch = _getchar();
  while ((ch < '0' || ch > '9') && ~ch) {
    if (ch == '-') f = -1;
    ch = _getchar();
  }
  if (ch == -1) return -1;
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = _getchar();
  }
  x *= f;
  return 1;
}
inline int read(long long &x) {
  x = 0;
  int f = 1;
  char ch = _getchar();
  while ((ch < '0' || ch > '9') && ~ch) {
    if (ch == '-') f = -1;
    ch = _getchar();
  }
  if (ch == -1) return -1;
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = _getchar();
  }
  x *= f;
  return 1;
}
inline int read(double &x) {
  char in;
  double Dec = 0.1;
  bool IsN = false, IsD = false;
  in = _getchar();
  if (in == EOF) return -1;
  while (in != '-' && in != '.' && (in < '0' || in > '9')) in = _getchar();
  if (in == '-') {
    IsN = true;
    x = 0;
  } else if (in == '.') {
    IsD = true;
    x = 0;
  } else
    x = in - '0';
  if (!IsD) {
    while (in = _getchar(), in >= '0' && in <= '9') {
      x *= 10;
      x += in - '0';
    }
  }
  if (in != '.') {
    if (IsN) x = -x;
    return 1;
  } else {
    while (in = _getchar(), in >= '0' && in <= '9') {
      x += Dec * (in - '0');
      Dec *= 0.1;
    }
  }
  if (IsN) x = -x;
  return 1;
}
inline int read(float &x) {
  char in;
  double Dec = 0.1;
  bool IsN = false, IsD = false;
  in = _getchar();
  if (in == EOF) return -1;
  while (in != '-' && in != '.' && (in < '0' || in > '9')) in = _getchar();
  if (in == '-') {
    IsN = true;
    x = 0;
  } else if (in == '.') {
    IsD = true;
    x = 0;
  } else
    x = in - '0';
  if (!IsD) {
    while (in = _getchar(), in >= '0' && in <= '9') {
      x *= 10;
      x += in - '0';
    }
  }
  if (in != '.') {
    if (IsN) x = -x;
    return 1;
  } else {
    while (in = _getchar(), in >= '0' && in <= '9') {
      x += Dec * (in - '0');
      Dec *= 0.1;
    }
  }
  if (IsN) x = -x;
  return 1;
}
inline int read(char *x) {
  char *tmp = x;
  char in = _getchar();
  while (in <= ' ' && in != EOF) in = _getchar();
  if (in == -1) return -1;
  while (in > ' ') *(tmp++) = in, in = _getchar();
  *tmp = '\0';
  return 1;
}
void Gao1(int, int, int);
void Gao2(int, int, int);
void Gao3(int, int, int);
void Gao1(int i, int a, int b) {
  if (i == -1) {
    printf("! %d %d\n", a, b);
    fflush(stdout);
    exit(0);
  }
  int x, y;
  printf("? %d %d\n", a, b ^ (1 << i));
  fflush(stdout);
  scanf("%d", &x);
  if (x == 0) Gao2(i - 1, a, b ^ (1 << i));
  if (x == 1) {
    int x;
    printf("? %d %d\n", a ^ (1 << i), b ^ (1 << i));
    fflush(stdout);
    scanf("%d", &x);
    if (x == 1)
      Gao3(i - 1, a, b ^ (1 << i));
    else
      Gao1(i - 1, a ^ (1 << i), b ^ (1 << i));
  }
  if (x == -1) {
    int x;
    printf("? %d %d\n", a ^ (1 << i), b);
    fflush(stdout);
    scanf("%d", &x);
    if (x == 0) Gao2(i - 1, a, b ^ (1 << i));
    if (x == 1) Gao1(i - 1, a, b);
    if (x == -1) Gao1(i - 1, a, b ^ (1 << i));
  }
}
void Gao2(int i, int a, int b) {
  if (i == -1) {
    printf("! %d %d\n", a, b);
    fflush(stdout);
    exit(0);
  }
  a ^= 1 << i;
  printf("? %d %d\n", a, b);
  fflush(stdout);
  int x;
  scanf("%d", &x);
  if (x == -1)
    Gao2(i - 1, a, b ^ (1 << i));
  else
    Gao2(i - 1, a ^ (1 << i), b);
}
void Gao3(int i, int a, int b) {
  if (i == -1) {
    printf("! %d %d\n", a, b);
    fflush(stdout);
    exit(0);
  }
  int x, y;
  printf("? %d %d\n", a ^ (1 << i), b);
  fflush(stdout);
  scanf("%d", &x);
  if (x == 0) Gao2(i - 1, a ^ (1 << i), b);
  if (x == -1) {
    int x;
    printf("? %d %d\n", a ^ (1 << i), b ^ (1 << i));
    fflush(stdout);
    scanf("%d", &x);
    if (x == -1)
      Gao1(i - 1, a ^ (1 << i), b);
    else
      Gao3(i - 1, a ^ (1 << i), b ^ (1 << i));
  }
  if (x == 1) {
    int x;
    printf("? %d %d\n", a, b ^ (1 << i));
    fflush(stdout);
    scanf("%d", &x);
    if (x == -1) Gao3(i - 1, a, b);
    if (x == 1) Gao3(i - 1, a ^ (1 << i), b);
  }
}
int main() {
  printf("? %d %d\n", 0, 0);
  fflush(stdout);
  int x;
  scanf("%d", &x);
  if (x == -1) Gao1(29, 0, 0);
  if (x == 0) Gao2(29, 0, 0);
  if (x == 1) Gao3(29, 0, 0);
  return 0;
}
