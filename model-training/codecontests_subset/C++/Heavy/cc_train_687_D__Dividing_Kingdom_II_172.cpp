#include <bits/stdc++.h>
using namespace std;
void read(int &x) {
  int v = 0, f = 1;
  char c = getchar();
  while (!isdigit(c) && c != '-') c = getchar();
  if (c == '-')
    f = -1;
  else
    v = v * 10 + c - '0';
  while (isdigit(c = getchar())) v = v * 10 + c - '0';
  x = v * f;
}
void read(long long &x) {
  long long v = 0ll, f = 1ll;
  char c = getchar();
  while (!isdigit(c) && c != '-') c = getchar();
  if (c == '-')
    f = -1;
  else
    v = v * 10 + c - '0';
  while (isdigit(c = getchar())) v = v * 10 + c - '0';
  x = v * f;
}
void readc(char &x) {
  char c;
  while ((c = getchar()) == ' ')
    ;
  x = c;
}
void writes(string s) { puts(s.c_str()); }
void writeln() { writes(""); }
void writei(int x) {
  if (x < 0) {
    putchar('-');
    x = abs(x);
  }
  if (!x) putchar('0');
  char a[25];
  int top = 0;
  while (x) {
    a[++top] = (x % 10) + '0';
    x /= 10;
  }
  while (top) {
    putchar(a[top]);
    top--;
  }
}
void writell(long long x) {
  if (x < 0) {
    putchar('-');
    x = abs(x);
  }
  if (!x) putchar('0');
  char a[25];
  int top = 0;
  while (x) {
    a[++top] = (x % 10) + '0';
    x /= 10;
  }
  while (top) {
    putchar(a[top]);
    top--;
  }
}
inline long long inc(int &x) { return ++x; }
inline long long inc(long long &x) { return ++x; }
inline long long inc(int &x, long long y) { return x += y; }
inline long long inc(long long &x, long long y) { return x += y; }
inline double inc(double &x, double y) { return x += y; }
inline long long dec(int &x) { return --x; }
inline long long dec(long long &x) { return --x; }
inline long long dec(int &x, long long y) { return x -= y; }
inline long long dec(long long &x, long long y) { return x -= y; }
inline double dec(double &x, double y) { return x -= y; }
inline long long mul(int &x) { return x = ((long long)x) * x; }
inline long long mul(long long &x) { return x = x * x; }
inline long long mul(int &x, long long y) { return x *= y; }
inline long long mul(long long &x, long long y) { return x *= y; }
inline double mul(double &x, double y) { return x *= y; }
inline long long divi(const int &x) {
  long long ans, l, r, mid;
  ans = 0;
  l = 0;
  r = 0x3fffffff;
  while (l < r) {
    mid = (l + r) / 2;
    if (mid * mid <= x) {
      ans = mid;
      l = mid + 1;
    } else
      r = mid;
  }
  return ans;
}
inline long long divi(const long long &x) {
  long long ans, l, r, mid;
  ans = 0;
  l = 0;
  r = 0x3fffffff;
  while (l < r) {
    mid = (l + r) / 2;
    if (mid * mid <= x) {
      ans = mid;
      l = mid + 1;
    } else
      r = mid;
  }
  return ans;
}
inline long long divi(int &x, long long y) { return x /= y; }
inline long long divi(long long &x, long long y) { return x /= y; }
inline double divi(double &x, double y) { return x /= y; }
inline long long mod(int &x, long long y) { return x %= y; }
inline long long mod(long long &x, long long y) { return x %= y; }
struct ee {
  int x, y, z, id;
} e[500005];
bool cmp(ee x, ee y) { return x.z > y.z; }
int n, m, i, j, q, fa[1000005], l, r;
int fnd(int x) {
  if (fa[x] == x) return x;
  return fa[x] = fnd(fa[x]);
}
int main() {
  read(n);
  read(m);
  read(q);
  if ((1) <= ((m)))
    for (((i)) = (1); ((i)) <= ((m)); ((i))++) {
      e[i].id = i;
      read(e[i].x);
      read(e[i].y);
      read(e[i].z);
    }
  stable_sort(e + 1, e + m + 1, cmp);
  while (q--) {
    read(l);
    read(r);
    if ((1) <= ((n + n)))
      for (((i)) = (1); ((i)) <= ((n + n)); ((i))++) fa[i] = i;
    if ((1) <= ((m)))
      for (((i)) = (1); ((i)) <= ((m)); ((i))++) {
        if (e[i].id < l || e[i].id > r) continue;
        if (fnd(e[i].x) == fnd(e[i].y)) break;
        if (fnd(e[i].x + n) == fnd(e[i].y + n)) break;
        fa[fnd(e[i].x)] = fnd(e[i].y + n);
        fa[fnd(e[i].y)] = fnd(e[i].x + n);
      }
    if (i > m)
      puts("-1");
    else
      printf("%d\n", e[i].z);
  }
  return 0;
}
