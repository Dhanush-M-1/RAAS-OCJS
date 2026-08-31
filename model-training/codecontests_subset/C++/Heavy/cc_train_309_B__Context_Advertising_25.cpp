#include <bits/stdc++.h>
using namespace std;
template <class F, class T>
T convert(F a, int p = -1) {
  stringstream ss;
  if (p >= 0) ss << fixed << setprecision(p);
  ss << a;
  T r;
  ss >> r;
  return r;
}
template <class T>
T gcd(T a, T b) {
  T r;
  while (b != 0) {
    r = a % b;
    a = b;
    b = r;
  }
  return a;
}
template <class T>
T lcm(T a, T b) {
  return a / gcd(a, b) * b;
}
template <class T>
T sqr(T x) {
  return x * x;
}
template <class T>
T cube(T x) {
  return x * x * x;
}
template <class T>
int getbit(T s, int i) {
  return (s >> i) & 1;
}
template <class T>
T onbit(T s, int i) {
  return s | (T(1) << i);
}
template <class T>
T offbit(T s, int i) {
  return s & (~(T(1) << i));
}
template <class T>
int cntbit(T s) {
  return s == 0 ? 0 : cntbit(s >> 1) + (s & 1);
}
const int bfsz = 1 << 16;
char bf[bfsz + 5];
int rsz = 0;
int ptr = 0;
char gc() {
  if (rsz <= 0) {
    ptr = 0;
    rsz = (int)fread(bf, 1, bfsz, stdin);
    if (rsz <= 0) return EOF;
  }
  --rsz;
  return bf[ptr++];
}
void ga(char &c) {
  c = EOF;
  while (!isalpha(c)) c = gc();
}
int gs(char s[]) {
  int l = 0;
  char c = gc();
  while (isspace(c)) c = gc();
  while (c != EOF && !isspace(c)) {
    s[l++] = c;
    c = gc();
  }
  s[l] = '\0';
  return l;
}
template <class T>
bool gi(T &v) {
  v = 0;
  char c = gc();
  while (c != EOF && c != '-' && !isdigit(c)) c = gc();
  if (c == EOF) return false;
  bool neg = c == '-';
  if (neg) c = gc();
  while (isdigit(c)) {
    v = v * 10 + c - '0';
    c = gc();
  }
  if (neg) v = -v;
  return true;
}
const double PI = acos(-1.0);
const double eps = 1e-9;
const int inf = (int)1e9 + 5;
const long long linf = (long long)1e17 + 5;
const long long mod = 10003;
int n, r, c, dad[1000005][22], d[1000005], len[1000005];
string s[1000005];
char str[1000005 * 5];
int cal(int x) {
  for (int i = 20; i >= 0; i--)
    if (getbit(r, i)) {
      x = dad[x][i];
    }
  return x;
}
void print(int x, int l) {
  int d = 0;
  for (int i = (x); i <= (x + l - 1); ++i) {
    str[len[i]] = '\0';
    memcpy(str, s[i].c_str(), len[i]);
    if (d + len[i] > c) {
      printf("\n%s", str);
      d = len[i] + 1;
    } else {
      printf("%s%s", d == 0 ? "" : " ", str);
      d += 1 + len[i];
    }
  }
}
int main() {
  gi(n);
  gi(r);
  gi(c);
  d[0] = 0;
  for (int i = 0; i < (n); ++i) {
    gs(str);
    s[i] = str;
    len[i] = s[i].length();
    d[i + 1] = d[i] + len[i] + 1;
  }
  dad[n][0] = n;
  int run = 0;
  for (int i = 0; i < (n); ++i) {
    while (run < n && d[run + 1] - d[i] <= c + 1) run++;
    dad[i][0] = run;
  }
  for (int j = (1); j <= (20); ++j)
    for (int i = 0; i < (n + 1); ++i) dad[i][j] = dad[dad[i][j - 1]][j - 1];
  int MAX = -1, vt = -1;
  for (int i = 0; i < (n); ++i) {
    int v = cal(i);
    if (v - i > MAX) {
      MAX = v - i;
      vt = i;
    }
  }
  print(vt, MAX);
  return 0;
}
