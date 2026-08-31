#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cerr << name << " : " << arg1 << std::endl;
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cerr.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
long long MODpow(long long input, long long n, long long difference) {
  long long res = 1, y = input;
  while (n > 0) {
    if (n & 1) res = (res * y) % difference;
    y = (y * y) % difference;
    n /= 2;
  }
  return res % difference;
}
template <class T>
T _abs(T n) {
  return (n < 0 ? -n : n);
}
template <class T>
T _max(T input, T b) {
  return (!(input < b) ? input : b);
}
template <class T>
T _min(T input, T b) {
  return (input < b ? input : b);
}
template <class T>
T gcd(T input, T b) {
  return (b != 0 ? gcd<T>(b, input % b) : input);
}
template <class T>
T lcm(T input, T b) {
  return (input / gcd<T>(input, b) * b);
}
inline int fi() {
  int n = 0;
  int ch = getchar();
  while (ch < '0' || ch > '9') ch = getchar();
  while (ch >= '0' && ch <= '9')
    n = (n << 3) + (n << 1) + ch - '0', ch = getchar();
  return n;
}
inline void fo(int input) {
  char snum[20];
  int iterator = 0;
  do {
    snum[iterator++] = input % 10 + 48;
    input = input / 10;
  } while (input != 0);
  iterator = iterator - 1;
  while (iterator >= 0) putchar(snum[iterator--]);
  putchar('\n');
}
const int MOD = 1e9 + 7, INF = 1e9, MAXN = 5205;
const long long INFLL = 1e18;
const long long unsigned INFLLU = 18446744073709551615ULL;
const long double EPS = 1e-12;
inline int inv(int input, int p = MOD) { return MODpow(input, p - 2, p); }
inline int sign(long double x) { return x < -EPS ? -1 : x > +EPS; }
inline void addMOD(int& input, int val, int p = MOD) {
  if ((input = (input + val)) >= p) input -= p;
}
inline void subMOD(int& input, int val, int p = MOD) {
  if ((input = (input - val)) < 0) input += p;
}
int n;
int preSum[MAXN][MAXN];
bitset<MAXN> input[MAXN];
int hex_to_int(char hex) { return isdigit(hex) ? hex - '0' : hex - 'A' + 10; }
int getsum(int r1, int r2, int c1, int c2) {
  return preSum[r2][c2] - preSum[r2][c1] - preSum[r1][c2] + preSum[r1][c1];
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  char str[MAXN];
  for (int i = 0; i < n; i++) {
    cin >> str;
    reverse(str, str + n / 4);
    for (int j = 0; j < n; j++)
      input[i][j] = (hex_to_int(str[j / 4]) >> j % 4) & 1;
  }
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < n; ++j)
      preSum[i + 1][j + 1] =
          preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j] + input[i][j];
  for (int x = n; x > 0; x--) {
    if (n % x == 0) {
      bool good = false;
      for (int i = 0; i < n && !good; i += x) {
        for (int j = 0; j < n && !good; j += x) {
          int sum = getsum(i, i + x, j, j + x);
          if (sum != x * x && sum != 0) good = true;
        }
      }
      if (!good) {
        cout << x << endl;
        return 0;
      }
    }
  }
  cerr << "Time elapsed :" << clock() * 1000.0 / CLOCKS_PER_SEC << " ms"
       << '\n';
  return 0;
}
