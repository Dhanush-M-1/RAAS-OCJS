#include <bits/stdc++.h>
using namespace std;
namespace fastIO {
bool IOerror = 0;
inline char nc() {
  static char buf[100000], *p1 = buf + 100000, *pend = buf + 100000;
  if (p1 == pend) {
    p1 = buf;
    pend = buf + fread(buf, 1, 100000, stdin);
    if (pend == p1) {
      IOerror = 1;
      return -1;
    }
  }
  return *p1++;
}
inline bool blank(char ch) {
  return ch == ' ' || ch == '\n' || ch == '\r' || ch == '\t';
}
template <class T>
inline bool read(T &x) {
  bool sign = 0;
  char ch = nc();
  x = 0;
  for (; blank(ch); ch = nc())
    ;
  if (IOerror) return false;
  if (ch == '-') sign = 1, ch = nc();
  for (; ch >= '0' && ch <= '9'; ch = nc()) x = x * 10 + ch - '0';
  if (sign) x = -x;
  return true;
}
inline bool read(double &x) {
  bool sign = 0;
  char ch = nc();
  x = 0;
  for (; blank(ch); ch = nc())
    ;
  if (IOerror) return false;
  if (ch == '-') sign = 1, ch = nc();
  for (; ch >= '0' && ch <= '9'; ch = nc()) x = x * 10 + ch - '0';
  if (ch == '.') {
    double tmp = 1;
    ch = nc();
    for (; ch >= '0' && ch <= '9'; ch = nc())
      tmp /= 10.0, x += tmp * (ch - '0');
  }
  if (sign) x = -x;
  return true;
}
inline bool read(char *s) {
  char ch = nc();
  for (; blank(ch); ch = nc())
    ;
  if (IOerror) return false;
  for (; !blank(ch) && !IOerror; ch = nc()) *s++ = ch;
  *s = 0;
  return true;
}
inline bool read(char &c) {
  for (c = nc(); blank(c); c = nc())
    ;
  if (IOerror) {
    c = -1;
    return false;
  }
  return true;
}
template <typename T, typename... U>
inline bool read(T &head, U &...tail) {
  return read(head) && read(tail...);
}
struct Ostream_fwrite {
  char *buf, *p1, *pend;
  Ostream_fwrite() {
    buf = new char[100000];
    p1 = buf;
    pend = buf + 100000;
  }
  void out(char ch) {
    if (p1 == pend) {
      fwrite(buf, 1, 100000, stdout);
      p1 = buf;
    }
    *p1++ = ch;
  }
  template <class T>
  void print(T x) {
    static char s[15], *s1;
    s1 = s;
    if (!x) *s1++ = '0';
    if (x < 0) out('-'), x = -x;
    while (x) *s1++ = x % 10 + '0', x /= 10;
    while (s1-- != s) out(*s1);
  }
  void print(double x, int y) {
    static long long mul[] = {1,
                              10,
                              100,
                              1000,
                              10000,
                              100000,
                              1000000,
                              10000000,
                              100000000,
                              1000000000,
                              10000000000LL,
                              100000000000LL,
                              1000000000000LL,
                              10000000000000LL,
                              100000000000000LL,
                              1000000000000000LL,
                              10000000000000000LL,
                              100000000000000000LL};
    if (x < -1e-12) out('-'), x = -x;
    long long x2 = (long long)floor(x);
    if (!y && x - x2 >= 0.5) ++x2;
    x -= x2;
    x *= mul[y];
    long long x3 = (long long)floor(x);
    if (y && x - x3 >= 0.5) ++x3;
    print(x2);
    if (y > 0) {
      out('.');
      for (size_t i = 1; i < y && x3 * mul[i] < mul[y]; out('0'), ++i)
        ;
      print(x3);
    }
  }
  void print(char *s) {
    while (*s) out(*s++);
  }
  void print(const char *s) {
    while (*s) out(*s++);
  }
  void flush() {
    if (p1 != buf) {
      fwrite(buf, 1, p1 - buf, stdout);
      p1 = buf;
    }
  }
  ~Ostream_fwrite() { flush(); }
} Ostream;
template <class T>
void print(T x) {
  Ostream.print(x);
}
inline void print(char x) { Ostream.out(x); }
inline void print(char *s) { Ostream.print(s); }
inline void print(const char *s) { Ostream.print(s); }
inline void print(double x, int y) { Ostream.print(x, y); }
template <typename T, typename... U>
inline void print(const T &head, const U &...tail) {
  print(head);
  print(tail...);
}
inline void flush() { Ostream.flush(); }
};  // namespace fastIO
using namespace fastIO;
int getv(char c) {
  if (isdigit(c)) return (c - '0');
  return (c - 'A' + 10);
}
int n;
bool a[5205][5205];
char buf[5205];
int pre[5205][5205];
void check(int x) {
  int mj = x * x;
  for (int i = x; i <= n; i += x) {
    for (int j = x; j <= n; j += x) {
      int vaa = pre[i][j] - pre[i - x][j] - pre[i][j - x] + pre[i - x][j - x];
      if (vaa == 0 || vaa == mj) continue;
      return;
    }
  }
  cout << x;
  exit(0);
}
int main() {
  read(n);
  for (int i = 1; i <= n; i++) {
    read(buf);
    for (int j = 1, pos = 0; j <= n; j += 4, pos++) {
      int val = getv(buf[pos]);
      a[i][j] = val & (1 << 3);
      a[i][j + 1] = val & (1 << 2);
      a[i][j + 2] = val & (1 << 1);
      a[i][j + 3] = val & (1 << 0);
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + a[i][j];
    }
  }
  for (int x = n; x >= 2; x--) {
    if (n % x != 0) continue;
    check(x);
  }
  cout << 1;
  return 0;
}
