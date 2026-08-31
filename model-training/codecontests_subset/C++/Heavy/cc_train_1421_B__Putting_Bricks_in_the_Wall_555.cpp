#include <bits/stdc++.h>
using namespace std;
template <class T>
using TMatrix = vector<vector<T>>;
template <class T>
using TVector = vector<T>;
using TString = string;
template <class T1, class T2>
using THashMap = unordered_map<T1, T2>;
void read(int& x) { scanf("%i", &x); }
void write(const int x) { printf("%i", x); }
void read(long long& x) { scanf("%lli", &x); }
void write(const long long& x) { printf("%lli", x); }
void read(double& x) { scanf("%lf", &x); }
void write(const double& x) { printf("%lf", x); }
void read(char& c, bool whiteSpaces = false) {
  while (1) {
    c = getchar();
    if (whiteSpaces || !isspace(c)) {
      break;
    }
  }
}
void write(const char c) { printf("%c", c); }
void read(TString& result, bool untilEol = false) {
  result.clear();
  char c;
  if (!untilEol) {
    while (1) {
      c = getchar();
      if (!isspace(c) || c == EOF) break;
    }
    result.push_back(c);
  }
  while (1) {
    c = getchar();
    if (c == EOF || c == '\n' || (!untilEol && isspace(c))) break;
    result.push_back(c);
  }
}
void write(const TString& s) { printf("%s", s.c_str()); }
void writeYES(const bool condition) {
  printf("%s\n", condition ? "YES" : "NO");
}
void writeYes(const bool condition) {
  printf("%s\n", condition ? "Yes" : "No");
}
template <class T>
void writeIf(const bool condition, const T& forTrue, const T& forFalse) {
  cout << (condition ? forTrue : forFalse) << endl;
}
template <class T1, class T2>
void read(pair<T1, T2>& x) {
  read(x.first);
  read(x.second);
}
template <class T1, class T2>
void write(pair<T1, T2>& x) {
  write(x.first);
  write(' ');
  write(x.second);
}
template <class T>
void writeln(const T& x) {
  write(x);
  write('\n');
}
template <class T1, class T2>
void read(T1& x1, T2& x2) {
  read(x1);
  read(x2);
}
template <class T1, class T2, class T3>
void read(T1& x1, T2& x2, T3& x3) {
  read(x1);
  read(x2);
  read(x3);
}
template <class T1, class T2, class T3, class T4>
void read(T1& x1, T2& x2, T3& x3, T4& x4) {
  read(x1);
  read(x2);
  read(x3);
  read(x4);
}
template <class T1, class T2, class T3, class T4, class T5>
void read(T1& x1, T2& x2, T3& x3, T4& x4, T5& x5) {
  read(x1);
  read(x2);
  read(x3);
  read(x4);
  read(x5);
}
template <class T1, class T2, class T3, class T4, class T5, class T6>
void read(T1& x1, T2& x2, T3& x3, T4& x4, T5& x5, T6& x6) {
  read(x1);
  read(x2);
  read(x3);
  read(x4);
  read(x5);
  read(x6);
}
template <class T1, class T2, class T3, class T4, class T5, class T6, class T7>
void read(T1& x1, T2& x2, T3& x3, T4& x4, T5& x5, T6& x6, T7& x7) {
  read(x1);
  read(x2);
  read(x3);
  read(x4);
  read(x5);
  read(x6);
  read(x7);
}
template <class T1, class T2>
void write(const T1& x1, const T2& x2) {
  write(x1);
  write(' ');
  write(x2);
}
template <class T1, class T2>
void writeln(const T1& x1, const T2& x2) {
  write(x1, x2);
  write('\n');
}
template <class T1, class T2, class T3>
void write(const T1& x1, const T2& x2, const T3& x3) {
  write(x1, x2);
  write(' ');
  write(x3);
}
template <class T1, class T2, class T3>
void writeln(const T1& x1, const T2& x2, const T3& x3) {
  write(x1, x2, x3);
  write('\n');
}
template <class T1, class T2, class T3, class T4>
void write(const T1& x1, const T2& x2, const T3& x3, const T4& x4) {
  write(x1, x2, x3);
  write(' ');
  write(x4);
}
template <class T1, class T2, class T3, class T4>
void writeln(const T1& x1, const T2& x2, const T3& x3, const T4& x4) {
  write(x1, x2, x3, x4);
  write('\n');
}
namespace NVector {
template <class T>
void Read(TVector<T>& v, int length = -1) {
  if (length == -1) {
    read(length);
  }
  v.resize(length);
  for (auto& elem : v) {
    read(elem);
  }
}
template <class T>
void Write(const TVector<T>& v, TString del = " ", bool needEndl = true) {
  for (int i = 0; i < v.size(); i++) {
    cout << v[i];
    if (i < v.size() - 1) {
      cout << del;
    }
  }
  if (needEndl) {
    cout << endl;
  }
}
template <class T>
TVector<T> Filter(const TVector<T>& v, std::function<bool(T)> filter) {
  TVector<T> result;
  for (const auto& elem : v) {
    if (filter(elem)) {
      result.push_back(elem);
    }
  }
  return move(result);
}
template <class T>
T Max(const TVector<T>& v) {
  return *max_element(v.begin(), v.end());
}
template <class T>
void Sort(TVector<T>& v) {
  sort(v.begin(), v.end());
}
template <class T>
void SortR(TVector<T>& v) {
  sort(v.begin(), v.end());
  reverse(v.begin(), v.end());
}
template <class T>
void Reverse(TVector<T>& v) {
  reverse(v.begin(), v.end());
}
template <class T>
T Min(const TVector<T>& v) {
  return *min_element(v.begin(), v.end());
}
template <class T>
T Sum(const TVector<T>& v) {
  T result = 0;
  for (const auto& elem : v) {
    result += elem;
  }
  return result;
}
template <class T>
T Mult(const TVector<T>& v) {
  T result = 1;
  for (const auto& elem : v) {
    result *= elem;
  }
  return result;
}
template <class T>
TVector<int> FromInt(T number) {
  TVector<int> v;
  while (number) {
    v.push_back(number % 10);
    number /= 10;
  }
  reverse(v.begin(), v.end());
  return move(v);
}
template <class T>
T ToInt(const TVector<int>& v) {
  T ans = 0;
  for (const auto e : v) {
    ans = ans * 10 + e;
  }
  return ans;
}
template <class T>
T Mex(const TVector<T>& v) {
  unordered_set<T> s(v.begin(), v.end());
  T value;
  for (value = 1; s.find(value) != s.end(); value += 1) {
  }
  return value;
}
template <class T>
bool Contains(const TVector<T>& v, const T& searchedElem) {
  for (const auto& elem : v) {
    if (elem == searchedElem) {
      return true;
    }
  }
  return false;
}
}  // namespace NVector
namespace NMath {
TVector<bool> SieveOfEratosthenes;
template <class T>
T Gcd(T x, T y) {
  while (x) {
    y %= x;
    swap(x, y);
  }
  return y;
}
template <class T>
T Lcm(T x, T y) {
  return (x / Gcd(x, y)) * y;
}
template <class T>
T Gcd(const vector<T>& v) {
  T ans = v.front();
  for (const auto& elem : v) {
    ans = Gcd(ans, elem);
  }
  return ans;
}
template <class T>
T Lcm(const vector<T>& v) {
  T ans = v.front();
  for (const auto& elem : v) {
    ans = Lcm(ans, elem);
  }
  return ans;
}
int GcdEx(const int a, const int b, int& x, int& y) {
  if (!a) {
    x = 0;
    y = 1;
    return b;
  }
  int x1, y1;
  int d = GcdEx(b % a, a, x1, y1);
  x = y1 - (b / a) * x1;
  y = x1;
  return d;
}
int CalcInverseNumber(const int number, const int mod) {
  int x, y;
  int g = GcdEx(number, mod, x, y);
  if (g != 1) {
    return -1;
  }
  return x = (x % mod + mod) % mod;
}
template <class T>
T Factorial(T n) {
  T result = 1;
  while (n > 0) {
    result *= n--;
  }
  return result;
}
template <class T>
T FactorialWithMod(T n, T mod) {
  if (n >= mod) {
    return 0;
  }
  T result = 1;
  while (n > 0) {
    result = (result * n) % mod;
    --n;
  }
  return result;
}
template <class T1, class T2>
T1 BinPow(T1 value, T2 extent) {
  T1 res = 1;
  while (extent > 0) {
    if (extent & 1) {
      res *= value;
    }
    extent >>= 1;
    value *= value;
  }
  return res;
}
template <class T1, class T2>
T1 BinPowWithMod(T1 value, T2 extent, T1 mod) {
  T1 res = 1;
  value %= mod;
  while (extent > 0) {
    if (extent & 1) {
      res = (value * res) % mod;
    }
    extent >>= 1;
    value = (value * value) % mod;
  }
  return res;
}
void PrecalcPrimes(const int length) {
  SieveOfEratosthenes.resize(length + 1, true);
  SieveOfEratosthenes[0] = SieveOfEratosthenes[1] = false;
  for (int i = 2; i * i <= length; ++i) {
    if (SieveOfEratosthenes[i]) {
      for (int j = i * i; j <= length; j += i) {
        SieveOfEratosthenes[j] = false;
      }
    }
  }
}
template <class T>
bool IsPrime(T value) {
  if (value < SieveOfEratosthenes.size() - 1) return SieveOfEratosthenes[value];
  for (T i = 2; i * i <= value; ++i) {
    if (value % i == 0) {
      return false;
    }
  }
  return true;
}
template <class T>
T NMemberOfArithmeticProgression(const T& a1, const T& n, const T& d) {
  return a1 + d * (n - 1);
}
template <class T>
T SumOfArithmeticProgression(const T& a1, const T& n, const T& d) {
  return (a1 + NMemberOfArithmeticProgression(a1, n, d)) * n / 2;
}
template <class T>
T Min(const T& a, const T& b) {
  return a < b ? a : b;
}
template <class T>
T Max(const T& a, const T& b) {
  return a > b ? a : b;
}
template <class T>
T Abs(const T& value) {
  return value >= 0 ? value : -value;
}
template <class T>
TVector<T> Factorize(T value) {
  TVector<T> res;
  for (T i = 2; i * i <= value; i++) {
    while (value % i == 0) {
      res.push_back(i);
      value /= i;
    }
  }
  if (value > 1) {
    res.push_back(value);
  }
  return res;
}
template <class T>
TVector<T> GetDivisors(T value) {
  TVector<T> res;
  for (T i = 1; i * i <= value; i++) {
    if (value % i == 0) {
      res.push_back(i);
      if (i * i != value) res.push_back(value / i);
    }
  }
  sort(res.begin(), res.end());
  return res;
}
double Log(const double a, const double b) { return log(b) / log(a); }
}  // namespace NMath
int solve();
int main(int argc, char* argv[]) {
  return solve();
  return 0;
}
template <class T>
void Read(TMatrix<T>& matrix, int n = -1, int m = -1) {
  if (n == -1) {
    read(n, m);
  } else if (m == -1) {
    m = n;
  }
  matrix.clear();
  matrix.resize(n, TVector<T>(m));
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      read(matrix[i][j]);
    }
  }
}
int solve() {
  int t;
  read(t);
  while (t--) {
    TMatrix<char> mat;
    int n;
    read(n);
    Read<char>(mat, n);
    TVector<pair<int, int>> ans;
    if (mat[0][1] == mat[1][0]) {
      if (mat[n - 1][n - 2] == mat[1][0]) {
        ans.push_back({n, n - 1});
      }
      if (mat[n - 2][n - 1] == mat[1][0]) {
        ans.push_back({n - 1, n});
      }
    } else if (mat[n - 1][n - 2] == mat[n - 2][n - 1]) {
      if (mat[n - 1][n - 2] == mat[1][0]) {
        ans.push_back({2, 1});
      }
      if (mat[n - 2][n - 1] == mat[0][1]) {
        ans.push_back({1, 2});
      }
    } else {
      ans.push_back({1, 2});
      if (mat[n - 1][n - 2] == mat[1][0]) {
        ans.push_back({n, n - 1});
      }
      if (mat[n - 2][n - 1] == mat[1][0]) {
        ans.push_back({n - 1, n});
      }
    }
    writeln<int>((int)ans.size());
    for (int i = 0; i < ans.size(); i++) {
      writeln(ans[i].first, ans[i].second);
    }
  }
  return 0;
}
