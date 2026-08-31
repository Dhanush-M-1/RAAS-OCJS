#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const long long mod = 1000000007;
const double e = 2.718281828459;
long long gcd(long long a, long long b) {
  if (!b) return a;
  return gcd(b, a % b);
}
long long gcd1(int a, int b) {
  if (!b) return a;
  return gcd(b, a % b);
}
long long pow_mod(long long a, long long b, long long c) {
  long long ans = 1;
  a = a % c;
  while (b > 0) {
    if (b % 2 == 1) ans = (ans * a) % c;
    b = b / 2;
    a = (a * a) % c;
  }
  return ans;
}
int pow_int(int a, int b) {
  int ans = 1;
  while (b > 0) {
    if (b % 2 == 1) ans = ans * a;
    b = b / 2;
    a = a * a;
  }
  return ans;
}
long long pow_llong(long long a, long long b) {
  long long ans = 1;
  while (b > 0) {
    if (b % 2 == 1) ans = ans * a;
    b = b / 2;
    a = a * a;
  }
  return ans;
}
int Scan() {
  int res = 0, flag = 0;
  char ch;
  if ((ch = getchar()) == '-') {
    flag = 1;
  } else if (ch >= '0' && ch <= '9') {
    res = ch - '0';
  }
  while ((ch = getchar()) >= '0' && ch <= '9') {
    res = res * 10 + (ch - '0');
  }
  return flag ? -res : res;
}
void Out(int a) {
  if (a < 0) {
    putchar('-');
    a = -a;
  }
  if (a >= 10) {
    Out(a / 10);
  }
  putchar(a % 10 + '0');
}
long long jc_mod(long long a, long long b, long long mod) {
  long long ans = 1;
  b = max(b, a - b);
  for (long long i = a; i > b; i--) {
    ans *= i;
    ans %= mod;
  }
  return ans;
}
double lg(double a) { return (log(a) / log(10.0)); }
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
inline void read(int &x) {
  bool sign = 0;
  char ch = nc();
  x = 0;
  for (; blank(ch); ch = nc())
    ;
  if (IOerror) return;
  if (ch == '-') sign = 1, ch = nc();
  for (; ch >= '0' && ch <= '9'; ch = nc()) x = x * 10 + ch - '0';
  if (sign) x = -x;
}
inline void read(long long &x) {
  bool sign = 0;
  char ch = nc();
  x = 0;
  for (; blank(ch); ch = nc())
    ;
  if (IOerror) return;
  if (ch == '-') sign = 1, ch = nc();
  for (; ch >= '0' && ch <= '9'; ch = nc()) x = x * 10 + ch - '0';
  if (sign) x = -x;
}
inline void read(double &x) {
  bool sign = 0;
  char ch = nc();
  x = 0;
  for (; blank(ch); ch = nc())
    ;
  if (IOerror) return;
  if (ch == '-') sign = 1, ch = nc();
  for (; ch >= '0' && ch <= '9'; ch = nc()) x = x * 10 + ch - '0';
  if (ch == '.') {
    double tmp = 1;
    ch = nc();
    for (; ch >= '0' && ch <= '9'; ch = nc())
      tmp /= 10.0, x += tmp * (ch - '0');
  }
  if (sign) x = -x;
}
inline void read(char *s) {
  char ch = nc();
  for (; blank(ch); ch = nc())
    ;
  if (IOerror) return;
  for (; !blank(ch) && !IOerror; ch = nc()) *s++ = ch;
  *s = 0;
}
inline void read(char &c) {
  for (c = nc(); blank(c); c = nc())
    ;
  if (IOerror) {
    c = -1;
    return;
  }
}
inline void read1(int &x) {
  char ch;
  int bo = 0;
  x = 0;
  for (ch = getchar(); ch < '0' || ch > '9'; ch = getchar())
    if (ch == '-') bo = 1;
  for (; ch >= '0' && ch <= '9'; x = x * 10 + ch - '0', ch = getchar())
    ;
  if (bo) x = -x;
}
inline void read1(long long &x) {
  char ch;
  int bo = 0;
  x = 0;
  for (ch = getchar(); ch < '0' || ch > '9'; ch = getchar())
    if (ch == '-') bo = 1;
  for (; ch >= '0' && ch <= '9'; x = x * 10 + ch - '0', ch = getchar())
    ;
  if (bo) x = -x;
}
inline void read1(double &x) {
  char ch;
  int bo = 0;
  x = 0;
  for (ch = getchar(); ch < '0' || ch > '9'; ch = getchar())
    if (ch == '-') bo = 1;
  for (; ch >= '0' && ch <= '9'; x = x * 10 + ch - '0', ch = getchar())
    ;
  if (ch == '.') {
    double tmp = 1;
    for (ch = getchar(); ch >= '0' && ch <= '9';
         tmp /= 10.0, x += tmp * (ch - '0'), ch = getchar())
      ;
  }
  if (bo) x = -x;
}
inline void read1(char *s) {
  char ch = getchar();
  for (; blank(ch); ch = getchar())
    ;
  for (; !blank(ch); ch = getchar()) *s++ = ch;
  *s = 0;
}
inline void read1(char &c) {
  for (c = getchar(); blank(c); c = getchar())
    ;
}
inline void read2(int &x) { scanf("%d", &x); }
inline void read2(long long &x) { scanf("%lld", &x); }
inline void read2(double &x) { scanf("%lf", &x); }
inline void read2(char *s) { scanf("%s", s); }
inline void read2(char &c) { scanf(" %c", &c); }
inline void readln2(char *s) { gets(s); }
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
  void print(int x) {
    static char s[15], *s1;
    s1 = s;
    if (!x) *s1++ = '0';
    if (x < 0) out('-'), x = -x;
    while (x) *s1++ = x % 10 + '0', x /= 10;
    while (s1-- != s) out(*s1);
  }
  void println(int x) {
    static char s[15], *s1;
    s1 = s;
    if (!x) *s1++ = '0';
    if (x < 0) out('-'), x = -x;
    while (x) *s1++ = x % 10 + '0', x /= 10;
    while (s1-- != s) out(*s1);
    out('\n');
  }
  void print(long long x) {
    static char s[25], *s1;
    s1 = s;
    if (!x) *s1++ = '0';
    if (x < 0) out('-'), x = -x;
    while (x) *s1++ = x % 10 + '0', x /= 10;
    while (s1-- != s) out(*s1);
  }
  void println(long long x) {
    static char s[25], *s1;
    s1 = s;
    if (!x) *s1++ = '0';
    if (x < 0) out('-'), x = -x;
    while (x) *s1++ = x % 10 + '0', x /= 10;
    while (s1-- != s) out(*s1);
    out('\n');
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
    x *= mul[y];
    long long x1 = (long long)floor(x);
    if (x - floor(x) >= 0.5) ++x1;
    long long x2 = x1 / mul[y], x3 = x1 - x2 * mul[y];
    print(x2);
    if (y > 0) {
      out('.');
      for (size_t i = 1; i < y && x3 * mul[i] < mul[y]; out('0'), ++i)
        ;
      print(x3);
    }
  }
  void println(double x, int y) {
    print(x, y);
    out('\n');
  }
  void print(char *s) {
    while (*s) out(*s++);
  }
  void println(char *s) {
    while (*s) out(*s++);
    out('\n');
  }
  void flush() {
    if (p1 != buf) {
      fwrite(buf, 1, p1 - buf, stdout);
      p1 = buf;
    }
  }
  ~Ostream_fwrite() { flush(); }
} Ostream;
inline void print(int x) { Ostream.print(x); }
inline void println(int x) { Ostream.println(x); }
inline void print(char x) { Ostream.out(x); }
inline void println(char x) {
  Ostream.out(x);
  Ostream.out('\n');
}
inline void print(long long x) { Ostream.print(x); }
inline void println(long long x) { Ostream.println(x); }
inline void print(double x, int y) { Ostream.print(x, y); }
inline void println(double x, int y) { Ostream.println(x, y); }
inline void print(char *s) { Ostream.print(s); }
inline void println(char *s) { Ostream.println(s); }
inline void println() { Ostream.out('\n'); }
inline void flush() { Ostream.flush(); }
char Out[100000], *o = Out;
inline void print1(int x) {
  static char buf[15];
  char *p1 = buf;
  if (!x) *p1++ = '0';
  if (x < 0) *o++ = '-', x = -x;
  while (x) *p1++ = x % 10 + '0', x /= 10;
  while (p1-- != buf) *o++ = *p1;
}
inline void println1(int x) {
  print1(x);
  *o++ = '\n';
}
inline void print1(long long x) {
  static char buf[25];
  char *p1 = buf;
  if (!x) *p1++ = '0';
  if (x < 0) *o++ = '-', x = -x;
  while (x) *p1++ = x % 10 + '0', x /= 10;
  while (p1-- != buf) *o++ = *p1;
}
inline void println1(long long x) {
  print1(x);
  *o++ = '\n';
}
inline void print1(char c) { *o++ = c; }
inline void println1(char c) {
  *o++ = c;
  *o++ = '\n';
}
inline void print1(char *s) {
  while (*s) *o++ = *s++;
}
inline void println1(char *s) {
  print1(s);
  *o++ = '\n';
}
inline void println1() { *o++ = '\n'; }
inline void flush1() {
  if (o != Out) {
    if (*(o - 1) == '\n') *--o = 0;
    puts(Out);
  }
}
struct puts_write {
  ~puts_write() { flush1(); }
} _puts;
inline void print2(int x) { printf("%d", x); }
inline void println2(int x) { printf("%d\n", x); }
inline void print2(char x) { printf("%c", x); }
inline void println2(char x) { printf("%c\n", x); }
inline void print2(long long x) { printf("%lld", x); }
inline void println2(long long x) {
  print2(x);
  printf("\n");
}
inline void println2() { printf("\n"); }
};  // namespace fastIO
using namespace fastIO;
void lisan(int *x, int n) {
  int data[100010];
  for (int i = 1; i <= n; i++) data[i] = x[i];
  sort(data + 1, data + 1 + n);
  int o = unique(data + 1, data + 1 + n) - data - 1;
  for (int i = 1; i <= n; i++)
    x[i] = lower_bound(data + 1, data + 1 + o, x[i]) - data;
}
long long calc(int M) { return 1; }
int sanfen(int L, int R) {
  int M, RM;
  while (L + 1 < R) {
    M = (L + R) / 2;
    RM = (M + R) / 2;
    if (calc(M) < calc(RM))
      R = RM;
    else
      L = M;
  }
  return L;
}
int CaculateWeekDay(int y, int m, int d) {
  if (m == 1 || m == 2) {
    m += 12;
    y--;
  }
  int iWeek = (d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7;
  return iWeek;
}
long long inv[2000022];
void init_inverse() {
  inv[1] = 1;
  for (int i = 2; i < 2000022; i++)
    inv[i] = (mod - (mod / i) * inv[mod % i] % mod) % mod;
}
int n, m, k;
set<int> second[200010];
set<pair<int, int> > now;
int siz[200010];
void del(int x) {
  for (set<int>::iterator it = second[x].begin(); it != second[x].end();) {
    now.erase(make_pair(siz[*it], *it));
    siz[*it]--;
    now.insert(make_pair(siz[*it], *it));
    second[*it].erase(x);
    second[x].erase(*it++);
  }
  now.erase(make_pair(siz[x], x));
  siz[x] = 0;
}
void update() {
  while (now.size() && now.begin()->first < k) {
    del(now.begin()->second);
  }
}
int ai[200010];
int ans[200010];
int bi[200010];
int main() {
  scanf("%d%d%d", &n, &m, &k);
  int a, b;
  for (int i = 1; i <= m; i++) {
    scanf("%d%d", &ai[i], &bi[i]);
    second[ai[i]].insert(bi[i]);
    second[bi[i]].insert(ai[i]);
    siz[ai[i]]++;
    siz[bi[i]]++;
  }
  for (int i = 1; i <= n; i++) now.insert(make_pair(siz[i], i));
  update();
  for (int i = m; i; i--) {
    ans[i] = now.size();
    if (second[ai[i]].find(bi[i]) != second[ai[i]].end()) {
      now.erase(make_pair(siz[ai[i]], ai[i]));
      second[ai[i]].erase(bi[i]);
      siz[ai[i]]--;
      if (siz[ai[i]]) now.insert(make_pair(siz[ai[i]], ai[i]));
    }
    if (second[bi[i]].find(ai[i]) != second[bi[i]].end()) {
      now.erase(make_pair(siz[bi[i]], bi[i]));
      second[bi[i]].erase(ai[i]);
      siz[bi[i]]--;
      if (siz[bi[i]]) now.insert(make_pair(siz[bi[i]], bi[i]));
    }
    update();
  }
  for (int i = 1; i <= m; i++) printf("%d\n", ans[i]);
}
