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
int n, m, s1, s2, t, i, j, s, suf[35];
int query(int x, int y) {
  printf("? %d %d\n", x, y);
  fflush(stdout);
  int s;
  scanf("%d", &s);
  return s;
}
void solve(int x) {
  while (x >= 0) {
    if (query(s1 ^ (1 << x), s2) == -1) {
      s1 |= (1 << x);
      s2 |= (1 << x);
    }
    x--;
  }
  printf("! %d %d\n", s1, s2);
  exit(0);
}
int main() {
  s = query(0, 0);
  if (s == 1) t = 1;
  if (s == -1) t = 2;
  if (s == 0) solve(29);
  suf[0] = 1;
  if ((1) <= ((29)))
    for (((i)) = (1); ((i)) <= ((29)); ((i))++)
      suf[i] = (suf[i - 1] | (1 << i));
  if ((29) >= (0))
    for ((i) = (29); (i) >= (0); (i)--) {
      if (t == 1) {
        int t1 = query((s1 ^ (1 << i)), s2);
        if (t1 == 0) {
          s1 |= (1 << i);
          solve(i - 1);
        }
        int t2 = query((s1 ^ suf[i]), (s2 ^ (1 << i) ^ suf[i]));
        t1 += t2;
        if (t1 == 0) {
          s1 |= (1 << i);
          if (t1 - t2 == -1) {
            t = 2;
          }
        }
        if (t1 == -2) {
          s1 |= (1 << i);
          s2 |= (1 << i);
        }
      } else {
        int t2 = query(s1, (s2 ^ (1 << i)));
        if (t2 == 0) {
          s2 |= (1 << i);
          solve(i - 1);
        }
        int t1 = query((s1 ^ (1 << i) ^ suf[i]), (s2 ^ suf[i]));
        t2 *= -1;
        t1 *= -1;
        t2 += t1;
        if (t2 == 0) {
          s2 |= (1 << i);
          if (t2 - t1 == -1) {
            t = 1;
          }
        }
        if (t2 == -2) {
          s2 |= (1 << i);
          s1 |= (1 << i);
        }
      }
    }
  printf("! %d %d\n", s1, s2);
  fflush(stdout);
  return 0;
}
