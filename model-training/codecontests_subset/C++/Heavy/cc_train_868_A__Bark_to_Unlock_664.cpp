#include <bits/stdc++.h>
using namespace std;
map<long long, long long> fib;
const int dx4[] = {-1, 0, 1, 0};
const int dy4[] = {0, 1, 0, -1};
const int dx8[] = {-1, 0, 1, 0, -1, -1, 1, 1};
const int dy8[] = {0, 1, 0, -1, -1, 1, -1, 1};
const int dxhorse[] = {-2, -2, -1, -1, 1, 1, 2, 2};
const int dyhorse[] = {1, -1, 2, -2, 2, -2, 1, -1};
template <typename T>
inline T ItoS(T n) {
  stringstream a;
  a << n;
  return a.str();
}
template <typename T>
inline T TrailingZeros(T n) {
  long long cnt = 0;
  for (long long i = 5; n / i >= 1; i *= 5) cnt += n / i;
  return cnt;
}
template <typename T>
inline T StoI(T s) {
  long long sum = 0;
  for (long long i = 0; i < s.size(); i++) {
    s[i] -= '0';
    sum = sum * 10 + s[i];
  }
  return sum;
}
template <typename T>
inline T binary_decimal(T n) {
  long long decimal = 0, i = 0, rem;
  while (n != 0) {
    rem = n % 10;
    n /= 10;
    decimal += rem * pow(2, i);
    ++i;
  }
  return decimal;
}
template <typename T>
inline T LCM(T a, T b) {
  return (a * b) / GCD(a, b);
}
template <typename T>
inline T maxi(T x, T y) {
  if (x > y)
    return x;
  else
    return y;
}
template <typename T>
inline T maxi(T x, T y, T z) {
  return maxi(maxi(x, y), z);
}
template <typename T>
inline T mini(T x, T y) {
  if (x < y)
    return x;
  else
    return y;
}
template <typename T>
inline T mini(T x, T y, T z) {
  return mini(mini(x, y), z);
}
template <typename T>
inline T GCD(T a, T b) {
  long long t;
  while (a) {
    t = a;
    a = b % a;
    b = t;
  }
  return b;
}
template <typename T>
inline T Pow(T base, T exp) {
  long long result = 1;
  while (exp) {
    if (exp & 1) result *= base;
    exp >>= 1;
    base *= base;
  }
  return result;
}
template <typename T>
inline T Mulmod(T a, T b, T c) {
  unsigned long long x = 0, y = a % c;
  while (b > 0) {
    if (b & 1) x = (x + y) % c;
    y = (y << 1) % c;
    b >>= 1;
  }
  return x;
}
template <typename T>
inline T Pow(T base, T exp, T mod) {
  unsigned long long x = 1, y = base;
  while (exp > 0) {
    if (exp & 1) x = Mulmod(x, y, mod);
    y = Mulmod(y, y, mod);
    exp >>= 1;
  }
  return x;
}
template <typename T>
inline T modulo(T a, T b, T c) {
  unsigned long long x = 1, y = a % c;
  while (b > 0) {
    if (b % 2) x = Mulmod(x, y, c);
    y = Mulmod(y, y, c);
    b /= 2;
  }
  return x % c;
}
template <typename T>
inline T BigMod(T a, T b, T m) {
  if (!b) return 1;
  long long x = BigMod(a, b / 2, m);
  x = (x * x) % m;
  if (b % 2) x = (x * a) % m;
  return x;
}
template <typename T>
inline T EGCD(T a, T b, T &x, T &y) {
  if (a == 0) {
    x = 0;
    y = 1;
    return b;
  }
  T x1, y1;
  T d = EGCD(b % a, a, x1, y1);
  x = y1 - (b / a) * x1;
  y = x1;
  return d;
}
template <typename T>
inline T NumOfDivisor(T n) {
  long long cnt = 0;
  int square_root = (int)sqrt(n) + 1;
  for (int i = 1; i < square_root; i++) {
    if (n % i == 0 && i * i != n) cnt += 2;
    if (n % i == 0 && i * i == n) cnt++;
  }
  return cnt;
}
template <typename T>
string to_string(T const &value) {
  stringstream sstr;
  sstr << value;
  return sstr.str();
}
template <class T1, class T2, class T3, class T4>
int lcs(T1 X, T2 Y, T3 m, T4 n) {
  int L[m + 1][n + 1];
  int i, j;
  for (i = 0; i <= m; i++) {
    for (j = 0; j <= n; j++) {
      if (i == 0 || j == 0)
        L[i][j] = 0;
      else if (X[i - 1] == Y[j - 1])
        L[i][j] = L[i - 1][j - 1] + 1;
      else
        L[i][j] = max(L[i - 1][j], L[i][j - 1]);
    }
  }
  return L[m][n];
}
template <class T>
inline long long Fibonacci(T n) {
  if (n == 0) return 0;
  if (n == 1 or n == 2) return fib[n] = 1;
  if (fib[n]) return fib[n];
  long long k = (n + 1) >> 1;
  if (n & 1) {
    fib[n] = Fibonacci(k) * Fibonacci(k) + Fibonacci(k - 1) * Fibonacci(k - 1);
  } else
    fib[n] = ((Fibonacci(k - 1)) << 1) + Fibonacci(k) * Fibonacci(k);
  return fib[n];
}
template <class T, class T2>
inline long long Fibonacci(T n, T2 M) {
  if (n == 0) return 0;
  if (n == 1 or n == 2) return fib[n] = 1;
  if (fib[n]) return fib[n];
  long long k = (n + 1) >> 1;
  if (n & 1) {
    fib[n] = (Fibonacci(k, M) * Fibonacci(k, M) +
              Fibonacci(k - 1, M) * Fibonacci(k - 1, M)) %
             M;
  } else
    fib[n] =
        (((Fibonacci(k - 1, M)) << 1) + Fibonacci(k, M) * Fibonacci(k, M)) % M;
  return fib[n];
}
template <typename T>
inline T scan(T &n) {
  n = 0;
  bool negative = 0;
  char c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') negative = 1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    n = n * 10 + c - 48;
    c = getchar();
  }
  if (negative) n = ~(n - 1);
}
template <typename T>
void print(T n) {
  if (n < 0) {
    putchar('-');
    n = -n;
  }
  if (!n) {
    putchar('0');
    putchar('\n');
    return;
  }
  char buff[12];
  int len = 0;
  while (n) buff[len++] = n % 10 + 48, n /= 10;
  for (int i = len - 1; i >= 0; i--) putchar(buff[i]);
  putchar('\n');
}
template <typename T>
void print(T a, T b) {
  print(a);
  print(b);
}
template <typename T>
void print(T a, T b, T c) {
  print(a);
  print(b);
  print(c);
}
template <typename T>
void Print(T n) {
  if (n < 0) {
    putchar('-');
    n = -n;
  }
  if (!n) {
    putchar('0');
    return;
  }
  char buff[12];
  int len = 0;
  while (n) buff[len++] = n % 10 + 48, n /= 10;
  for (int i = len - 1; i >= 0; i--) putchar(buff[i]);
}
template <class T1, class T2>
void Print(T1 e1, T2 e2) {
  cout << e1 << " " << e2 << endl;
}
template <class T1, class T2, class T3>
void Print(T1 e1, T2 e2, T3 e3) {
  cout << e1 << " " << e2 << " " << e3 << "\n";
}
template <class T1, class T2, class T3, class T4>
void Print(T1 e1, T2 e2, T3 e3, T4 e4) {
  cout << e1 << " " << e2 << " " << e3 << " " << e4 << "\n";
}
int main() {
  int n;
  map<char, bool> fir;
  map<char, bool> sec;
  map<string, bool> mp;
  string s1, s2;
  cin >> s1;
  cin >> n;
  while (n--) {
    cin >> s2;
    fir[s2[0]] = 1;
    sec[s2[1]] = 1;
    mp[s2] = 1;
  }
  if (mp[s1]) return cout << "YES", 0;
  if (fir[s1[1]] and sec[s1[0]]) return cout << "YES", 0;
  cout << "NO";
  return 0;
}
