#include <bits/stdc++.h>
using namespace std;
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
    n = n * 10 + (ch - '0');
    ch = getchar();
    if (ch < '0' || ch > '9') break;
  }
  return (ng ? -n : n);
}
template <typename T>
inline T Dist(T x1, T y1, T x2, T y2) {
  return sqrt((x1 - x2 * x1 - x2) + (y1 - y2 * y1 - y2));
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
inline T ABS(T a) {
  if (a < 0)
    return -a;
  else
    return a;
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
long long Bigmod(long long base, long long power, long long MOD) {
  long long ret = 1;
  while (power) {
    if (power & 1) ret = (ret * base) % MOD;
    base = (base * base) % MOD;
    power >>= 1;
  }
  return ret;
}
long long ModInverse(long long number, long long MOD) {
  return Bigmod(number, MOD - 2, MOD);
}
int Set(int N, int pos) { return N = N | (1 << pos); }
int Reset(int N, int pos) { return N = N & ~(1 << pos); }
bool Chkbit(int N, int pos) { return (bool)(N & (1 << pos)); }
bool isVowel(char ch) {
  ch = toupper(ch);
  if (ch == 'A' || ch == 'U' || ch == 'I' || ch == 'O' || ch == 'E')
    return true;
  return false;
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
long long int toLlint(string s) {
  long long int sm;
  stringstream ss(s);
  ss >> sm;
  return sm;
}
template <typename T>
long long int isLeft(T a, T b, T c) {
  return (a.x - b.x) * (b.y - c.y) - (b.x - c.x) * (a.y - b.y);
}
int ar[22], n, dp[20][10];
char s[22];
int Solve(int pos, int carry) {
  if (pos == -1) {
    return (!carry);
  }
  int &res = dp[pos][carry];
  if (res != -1) return res;
  res = 0;
  for (int i = 0; i <= 6; i++) {
    for (int j = 0; j <= 6; j++) {
      if (i + j > 6) continue;
      int tot = (carry + i * 4 + j * 7);
      if (tot % 10 == ar[pos]) {
        res |= Solve(pos - 1, tot / 10);
      }
      if (res) break;
    }
    if (res) break;
  }
  return res;
}
int Store[10][21];
void Path(int pos, int carry) {
  if (pos == -1) {
    return;
  }
  for (int i = 0; i <= 6; i++) {
    for (int j = 0; j <= 6; j++) {
      if (i + j > 6) continue;
      int tot = (carry + i * 4 + j * 7);
      if (tot % 10 == ar[pos]) {
        int tp = Solve(pos - 1, tot / 10);
        if (tp) {
          int id = 0;
          for (int k = 0; k < i; k++) Store[id++][pos] = 4;
          for (int k = 0; k < j; k++) Store[id++][pos] = 7;
          Path(pos - 1, tot / 10);
          return;
        }
      }
    }
  }
}
int main() {
  int t;
  t = in<int>();
  for (int cs = 1; cs < t + 1; cs++) {
    scanf("%s", &s);
    n = strlen(s);
    for (int i = 0; i < n; i++) ar[i] = (s[i] - '0');
    memset(dp, -1, sizeof(dp));
    memset(Store, 0, sizeof(Store));
    int ans = Solve(n - 1, 0);
    if (ans) {
      Path(n - 1, 0);
      long long int Sum = 0;
      for (int i = 0; i < 6; i++) {
        long long int ans = 0;
        for (int j = 0; j < n; j++) {
          ans = ans * 10 + Store[i][j];
        }
        printf("%lld ", ans);
      }
      printf("\n");
    } else {
      printf("-1\n");
    }
  }
  return 0;
}
