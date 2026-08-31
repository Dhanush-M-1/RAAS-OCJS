#include <bits/stdc++.h>
using namespace std;
int dx4[] = {0, 0, -1, 1};
int dy4[] = {-1, 1, 0, 0};
int dx8[] = {0, 0, -1, 1, -1, -1, 1, 1};
int dy8[] = {-1, 1, 0, 0, -1, 1, -1, 1};
int knightx[] = {-1, 1, -2, 2, -2, 2, -1, 1};
int knighty[] = {-2, -2, -1, -1, 1, 1, 2, 2};
template <typename T>
T in() {
  char ch;
  T n = 0;
  bool ng = false;
  while (1) {
    ch = getchar();
    if (ch == '-') {
      ng = true;
      ch = getchar();
      break;
    }
    if (ch >= '0' && ch <= '9') break;
  }
  while (1) {
    if (ch < '0' || ch > '9') break;
    n = n * 10 + (ch - '0');
    ch = getchar();
  }
  return (ng ? -n : n);
}
template <typename T>
inline T POW(T B, T P) {
  if (P == 0) return 1;
  if (P & 1)
    return B * POW(B, P - 1);
  else
    return (POW(B, P / 2) * POW(B, P / 2));
}
template <typename T>
inline T Gcd(T a, T b) {
  if (a < 0) return Gcd(-a, b);
  if (b < 0) return Gcd(a, -b);
  return (b == 0) ? a : Gcd(b, a % b);
}
template <typename T>
inline T Lcm(T a, T b) {
  if (a < 0) return Lcm(-a, b);
  if (b < 0) return Lcm(a, -b);
  return a * (b / Gcd(a, b));
}
template <typename T>
T Bigmod(T base, T power, T MOD) {
  T ret = T(1) % MOD;
  while (power) {
    if (power & 1) ret = (ret * base) % MOD;
    base = (base * base) % MOD;
    power >>= 1;
  }
  return ret;
}
bool isVowel(char ch) {
  ch = toupper(ch);
  if (ch == 'A' || ch == 'U' || ch == 'I' || ch == 'O' || ch == 'E')
    return true;
  return false;
}
template <typename T>
long long int isLeft(T a, T b, T c) {
  return (a.x - b.x) * (b.y - c.y) - (b.x - c.x) * (a.y - b.y);
}
template <typename T>
T ModInverse(T number, T MOD) {
  return Bigmod(number, MOD - T(2), MOD);
}
bool isConst(char ch) {
  if (isalpha(ch) && !isVowel(ch)) return true;
  return false;
}
int toInt(string s) {
  int sm;
  stringstream ss(s);
  ss >> sm;
  return sm;
}
bool isPrime(long long int val) {
  if (val == 2) return true;
  if (val % 2 == 0 || val == 1) return false;
  long long int sqrt_N = (long long int)((double)sqrt(val));
  for (long long int i = 3; i <= sqrt_N; i += 2) {
    if (val % i == 0) return false;
  }
  return true;
}
template <class T>
string convert(T _input) {
  stringstream blah;
  blah << _input;
  return blah.str();
}
bool valid(int r, int c, int x, int y) {
  if (x >= 1 && x <= r && y >= 1 && y <= c) return 1;
  return 0;
}
map<string, long long int> month;
void Month() {
  month["January"] = 1, month["February"] = 2, month["March"] = 3,
  month["April"] = 4, month["May"] = 5, month["June"] = 6;
  month["July"] = 7, month["August"] = 8, month["September"] = 9,
  month["October"] = 10, month["November"] = 11, month["December"] = 12;
}
bool Check(int val, int pos) { return bool(val & (1 << pos)); }
int Set(int val, int pos) { return val | (1 << pos); }
int Reset(int val, int pos) { return val & (~(1 << pos)); }
int Flip(int val, int pos) { return val ^ (1 << pos); }
long long int n, m, caseno, k, L;
long long int arr[109];
int main() {
  long long int n;
  long long int a = 0;
  scanf("%lld", &n);
  long long int mn = -1;
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &arr[i]);
    a += arr[i];
    mn = max(mn, arr[i]);
  }
  for (long long int i = mn; i <= 2000; i++) {
    long long int k = i;
    long long int b = 0;
    for (long long int j = 1; j <= n; j++) {
      long long int t = k - arr[j];
      if (t > 0) {
        b += t;
      }
    }
    if (b > a) {
      printf("%lld", k), printf("\n");
      return 0;
    }
  }
  return 0;
}
