#include <bits/stdc++.h>
using namespace std;
template <class T>
void read(T& x) {
  T f = 1;
  x = 0;
  char c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while ('0' <= c && c <= '9') {
    x = x * 10 + c - '0';
    c = getchar();
  }
  x *= f;
}
template <class T>
void print(T x) {
  if (x < 0) putchar('-'), x = -x;
  int s[20], top = 0;
  while (s[++top] = x % 10, x /= 10)
    ;
  if (!top) s[++top] = 0;
  while (top) putchar(s[top--] + '0');
}
int n, a[200005], T[200005], B, mxv, ans, fir[200005 << 1];
int calc(int x) {
  memset(fir, -1, sizeof(fir));
  int now = n;
  fir[now] = 0;
  for (int i = 1; i <= n; ++i) {
    if (a[i] == mxv)
      now++;
    else if (a[i] == x)
      now--;
    if (!(~fir[now]))
      fir[now] = i;
    else
      ans = max(ans, i - fir[now]);
  }
}
int main() {
  read(n);
  for (int i = 1; i <= n; ++i) read(a[i]), T[a[i]]++;
  for (int i = 1; i <= n; ++i)
    if (T[a[i]] > T[mxv]) mxv = a[i];
  B = sqrt(n);
  for (int i = 1; i <= n; ++i)
    if (T[i] >= B) ans = max(ans, calc(i));
  for (int x = 1; x <= B; ++x) {
    for (int i = 1; i <= n; ++i) T[i] = 0;
    for (int i = 1, cnt = 0, l = 1; i <= n; ++i) {
      T[a[i]]++;
      if (T[a[i]] == x) cnt++;
      while (T[a[i]] > x) {
        if (T[a[l]] == x) cnt--;
        T[a[l]]--, l++;
      }
      if (cnt >= 2) ans = max(ans, i - l + 1);
    }
  }
  print(ans);
}
