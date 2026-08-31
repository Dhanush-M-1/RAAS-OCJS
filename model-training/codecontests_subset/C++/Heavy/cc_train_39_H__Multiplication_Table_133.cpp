#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T euclide(T a, T b, T& x, T& y) {
  if (a < 0) {
    T d = euclide(-a, b, x, y);
    x = -x;
    return d;
  }
  if (b < 0) {
    T d = euclide(a, -b, x, y);
    y = -y;
    return d;
  }
  if (b == 0) {
    x = 1;
    y = 0;
    return a;
  } else {
    T d = euclide(b, a % b, x, y);
    T t = x;
    x = y;
    y = t - (a / b) * y;
    return d;
  }
}
template <class T>
inline void checkmin(T& a, T b) {
  if (b < a) a = b;
}
template <class T>
inline void checkmax(T& a, T b) {
  if (b > a) a = b;
}
template <class T>
T Abs(T x) {
  return x > 0 ? x : -x;
}
template <class T>
inline T sqr(T x) {
  return x * x;
}
template <class T>
inline bool isPrime(T n) {
  if (n <= 1) return false;
  for (T i = 2; i * i <= n; i++)
    if (n % i == 0) return false;
  return true;
}
template <class T>
inline T Mod(T n, T m) {
  return (n % m + m) % m;
}
template <class T>
string toString(T n) {
  ostringstream oss;
  oss << n;
  oss.flush();
  return oss.str();
}
int toInt(string s) {
  int r = 0;
  istringstream sin(s);
  sin >> r;
  return r;
}
long long toLl(string s) {
  long long r = 0;
  istringstream sin(s);
  sin >> r;
  return r;
}
template <class T>
void debug(const T& e) {
  cout << e << endl;
}
template <class T1, class T2>
void debug(const T1& e1, const T2& e2) {
  cout << e1 << "\t" << e2 << endl;
}
template <class T1, class T2, class T3>
void debug(const T1& e1, const T2& e2, const T3& e3) {
  cout << e1 << "\t" << e2 << "\t" << e3 << endl;
}
template <class T1, class T2, class T3, class T4>
void debug(const T1& e1, const T2& e2, const T3& e3, const T4& e4) {
  cout << e1 << "\t" << e2 << "\t" << e3 << "\t" << e4 << endl;
}
template <class T1, class T2, class T3, class T4, class T5>
void debug(const T1& e1, const T2& e2, const T3& e3, const T4& e4,
           const T5& e5) {
  cout << e1 << "\t" << e2 << "\t" << e3 << "\t" << e4 << "\t" << e5 << endl;
}
template <class T>
void debug(vector<T>& e) {
  int i;
  for (i = 0; i < (int)e.size(); i++) cout << e[i] << " ";
  cout << endl;
}
template <class T>
void debug(vector<basic_string<T> >& e) {
  int i, j;
  for (i = 0; i < (int)e.size(); i++) {
    for (j = 0; j < (int)e[i].size(); j++) cout << e[i][j];
    cout << endl;
  }
  cout << endl;
}
template <class T>
void debug(vector<vector<T> >& e, int row, int col) {
  int i, j;
  for (i = 0; i < row; i++) {
    for (j = 0; j < col; j++) cout << e[i][j] << "\t";
    cout << endl;
  }
  cout << endl;
}
template <class T>
void debug(T e[100][100], int row, int col) {
  int i, j;
  for (i = 0; i < row; i++) {
    for (j = 0; j < col; j++) cout << e[i][j] << " ";
    cout << endl;
  }
}
template <class T>
void debug(T e[], int row) {
  int i;
  for (i = 0; i < row; i++) cout << e[i] << " ";
  cout << endl;
}
long long Pow(int B, int P) {
  long long R = 1;
  while (P > 0) {
    if (P % 2 == 1) R = (R * B);
    P /= 2;
    B = (B * B);
  }
  return R;
}
int BigMod(long long B, long long P, long long M) {
  long long R = 1;
  while (P > 0) {
    if (P % 2 == 1) {
      R = (R * B) % M;
    }
    P /= 2;
    B = (B * B) % M;
  }
  return (int)R;
}
long long mulmod(long long a, long long b, long long c) {
  long long x = 0, y = a % c;
  while (b > 0) {
    if (b % 2 == 1) {
      x = (x + y) % c;
    }
    y = (y * 2) % c;
    b /= 2;
  }
  return x % c;
}
void binprint(int mask, int n) {
  int i;
  string s = "";
  do {
    s += (mask % 2 + '0');
    mask /= 2;
  } while (mask);
  reverse(s.begin(), s.end());
  s = string(max(n - (int)s.size(), 0), '0') + s;
  for (i = (int)s.size() - n; i < (int)s.size(); i++) printf("%c", s[i]);
  printf("\n");
}
int convert(int num, int base) {
  string str = "";
  while (num) {
    str += num % base + '0';
    num /= base;
  }
  reverse(str.begin(), str.end());
  return toInt(str);
}
int main() {
  int i, j, test, Case = 1, k;
  while (scanf("%d", &k) == 1) {
    for (i = 1; i < k; i++) {
      for (j = 1; j < k; j++) printf("%d ", convert(i * j, k));
      printf("\n");
    }
  }
  return 0;
}
