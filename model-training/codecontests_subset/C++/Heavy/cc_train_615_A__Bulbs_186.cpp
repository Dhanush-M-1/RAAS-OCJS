#include <bits/stdc++.h>
using namespace std;
void reader(int *x) {
  int k, m = 0;
  *x = 0;
  for (;;) {
    (k) = getchar();
    if (k == '-') {
      m = 1;
      break;
    }
    if ('0' <= k && k <= '9') {
      *x = k - '0';
      break;
    }
  }
  for (;;) {
    (k) = getchar();
    if (k < '0' || k > '9') break;
    *x = (*x) * 10 + k - '0';
  }
  if (m) (*x) = -(*x);
}
void reader(long long *x) {
  int k, m = 0;
  *x = 0;
  for (;;) {
    (k) = getchar();
    if (k == '-') {
      m = 1;
      break;
    }
    if ('0' <= k && k <= '9') {
      *x = k - '0';
      break;
    }
  }
  for (;;) {
    (k) = getchar();
    if (k < '0' || k > '9') break;
    *x = (*x) * 10 + k - '0';
  }
  if (m) (*x) = -(*x);
}
void reader(double *x) { scanf("%lf", x); }
int reader(char c[]) {
  int i, s = 0;
  for (;;) {
    (i) = getchar();
    if (i != ' ' && i != '\n' && i != '\r' && i != '\t' && i != EOF) break;
  }
  c[s++] = i;
  for (;;) {
    (i) = getchar();
    if (i == ' ' || i == '\n' || i == '\r' || i == '\t' || i == EOF) break;
    c[s++] = i;
  }
  c[s] = '\0';
  return s;
}
template <class T, class S>
void reader(T *x, S *y) {
  reader(x);
  reader(y);
}
template <class T, class S, class U>
void reader(T *x, S *y, U *z) {
  reader(x);
  reader(y);
  reader(z);
}
template <class T, class S, class U, class V>
void reader(T *x, S *y, U *z, V *w) {
  reader(x);
  reader(y);
  reader(z);
  reader(w);
}
void writer(int x, char c) {
  int s = 0, m = 0;
  char f[10];
  if (x < 0) m = 1, x = -x;
  while (x) f[s++] = x % 10, x /= 10;
  if (!s) f[s++] = 0;
  if (m) putchar('-');
  while (s--) putchar(f[s] + '0');
  putchar(c);
}
void writer(long long x, char c) {
  int s = 0, m = 0;
  char f[20];
  if (x < 0) m = 1, x = -x;
  while (x) f[s++] = x % 10, x /= 10;
  if (!s) f[s++] = 0;
  if (m) putchar('-');
  while (s--) putchar(f[s] + '0');
  putchar(c);
}
void writer(double x, char c) {
  printf("%.15f", x);
  putchar(c);
}
void writer(const char c[]) {
  int i;
  for (i = 0; c[i] != '\0'; i++) putchar(c[i]);
}
void writer(const char x[], char c) {
  int i;
  for (i = 0; x[i] != '\0'; i++) putchar(x[i]);
  putchar(c);
}
template <class T>
void writerLn(T x) {
  writer(x, '\n');
}
template <class T, class S>
void writerLn(T x, S y) {
  writer(x, ' ');
  writer(y, '\n');
}
template <class T, class S, class U>
void writerLn(T x, S y, U z) {
  writer(x, ' ');
  writer(y, ' ');
  writer(z, '\n');
}
template <class T>
void writerArr(T x[], int n) {
  int i;
  if (!n) {
    putchar('\n');
    return;
  }
  for (i = 0; i < n - 1; i++) writer(x[i], ' ');
  writer(x[n - 1], '\n');
}
char memarr[17000000];
void *mem = memarr;
int N, M;
int chk[1000];
int main() {
  int i, j, k;
  reader(&N, &M);
  while (N--) {
    reader(&k);
    while (k--) reader(&i), chk[i - 1] = 1;
  }
  for (i = 0; i < M; i++)
    if (!chk[i]) break;
  writerLn(i == M ? "YES" : "NO");
  return 0;
}
