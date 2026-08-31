#include <bits/stdc++.h>
using namespace std;
template <class X>
class vec {
 public:
  X x, y;
  vec<X>(X a = 0, X b = 0) { x = a, y = b; }
  X dis(vec a) { return (x - a.x) * (x - a.x) + (y - a.y) * (y - a.y); }
  vec<X> operator-(vec<X> b) { return vec<X>(x - b.x, y - b.y); }
  X operator*(vec<X> b) { return x * b.y - y * b.x; }
};
void sf(int &x) { scanf("%d", &x); }
void sf(long long &x) { scanf("%lld", &x); }
void sf(long long &x, long long &y) { scanf("%lld%lld", &x, &y); }
void sf(float &x) { scanf("%f", &x); }
void sf(double &x) { scanf("%lf", &x); }
void sf(int &x, int &y) { scanf("%d%d", &x, &y); }
void sf(float &x, float &y) { scanf("%f%f", &x, &y); }
void sf(double &x, double &y) { scanf("%lf%lf", &x, &y); }
void sf(double &x, double &y, double &z) { scanf("%lf%lf%lf", &x, &y, &z); }
void sf(int &x, int &y, int &z) { scanf("%d%d%d", &x, &y, &z); }
void sf(long long &x, long long &y, long long &z) {
  scanf("%lld%lld%lld", &x, &y, &z);
}
void sf(float &x, float &y, float &z) { scanf("%u%u%u", &x, &y, &z); }
void sf(char &x) { x = getchar(); }
void sf(char *s) { scanf("%s", s); }
void sf(string &s) { cin >> s; }
void sf(vec<int> &x) {
  int a, b;
  sf(a, b);
  x = vec<int>(a, b);
}
void pf(int x) { printf("%d\n", x); }
void pf(int x, int y) { printf("%d %d\n", x, y); }
void pf(int x, int y, int z) { printf("%d %d %d\n", x, y, z); }
void pf(long long x) { printf("%lld\n", x); }
void pf(long long x, long long y) { printf("%lld %lld\n", x, y); }
void pf(long long x, long long y, long long z) {
  printf("%lld %lld %lld\n", x, y, z);
}
void pf(float x) { printf("%u\n", x); }
void pf(double x) { printf("%.9lf\n", x); }
void pf(double x, double y) { printf("%.5lf %.5lf\n", x, y); }
void pf(char x) { printf("%c\n", x); }
void pf(char *x) { printf("%s\n", x); }
void pf(string x) {
  cout << x;
  puts("");
}
void pf(vec<int> x) { printf("%d %d\n", x.x, x.y); }
long long STN(string s) {
  long long sm;
  stringstream ss(s);
  ss >> sm;
  return sm;
}
template <class T>
T bigmod(T b, T p, T m) {
  if (p == 0) return 1 % m;
  T x = b;
  T ans = 1;
  while (p) {
    if (p & 1) ans = (ans * x) % m;
    p >>= 1;
    x = (x * x) % m;
  }
  return ans;
}
template <class T>
T gcd(T x, T y) {
  if (y == 0) return x;
  return gcd(y, x % y);
}
template <typename T>
T POW(T b, T p) {
  if (p == 0) return 1;
  if (p == 1) return b;
  if (p % 2 == 0) {
    T s = POW(b, p / 2);
    return s * s;
  }
  return b * POW(b, p - 1);
}
template <typename T>
T modinv(T num, T m) {
  return bigmod(num, m - 2, m);
}
template <class T>
string NTS(T Number) {
  stringstream ss;
  ss << Number;
  return ss.str();
}
string s, as;
map<string, int> mp;
int an = 0, dx[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int main() {
  sf(s);
  int l = s.size();
  for (int i = 0, j = 9; j < l; i++, j++) {
    int a = 0;
    int b = 0;
    bool f = 1;
    if (s[i + 2] != '-' || s[i + 5] != '-') f = 0;
    string ss, gg, gm, gd;
    for (int k = i; k <= j; k++) {
      ss += s[k];
      if (s[k] >= '0' && s[k] <= '9')
        a++;
      else
        b++;
    }
    gg = s.substr(i + 6, 4);
    gm = s.substr(i + 3, 2);
    gd = s.substr(i, 2);
    int ag = STN(gg), ad = STN(gd);
    if (a != 8) f = 0;
    if (f) mp[ss]++;
    int ab = mp[ss], am = STN(gm);
    if (ag >= 2013 && ag <= 2015 && ad > 0 && ad <= dx[am] && ab > an) {
      an = ab;
      as = ss;
    }
  }
  pf(as);
  return 0;
}
