#include <bits/stdc++.h>
#pragma warning(disable : 4996)
using namespace std;
namespace Xrocks {}
using namespace Xrocks;
namespace Xrocks {
class in {
} user_input;
class out {
} output;
in& operator>>(in& X, int& Y) {
  scanf("%d", &Y);
  return X;
}
in& operator>>(in& X, char* Y) {
  scanf("%s", Y);
  return X;
}
in& operator>>(in& X, float& Y) {
  scanf("%f", &Y);
  return X;
}
in& operator>>(in& X, double& Y) {
  scanf("%lf", &Y);
  return X;
}
in& operator>>(in& X, char& C) {
  scanf("%c", &C);
  return X;
}
in& operator>>(in& X, string& Y) {
  cin >> Y;
  return X;
}
in& operator>>(in& X, long long& Y) {
  scanf("%lld", &Y);
  return X;
}
template <typename T>
in& operator>>(in& X, vector<T>& Y) {
  for (auto& x : Y) user_input >> x;
  return X;
}
template <typename T>
out& operator<<(out& X, const T& Y) {
  cout << Y;
  return X;
}
template <typename T>
out& operator<<(out& X, vector<T>& Y) {
  for (auto& x : Y) output << x << " ";
  return X;
}
out& operator<<(out& X, const int& Y) {
  printf("%d", Y);
  return X;
}
out& operator<<(out& X, const char& C) {
  printf("%c", C);
  return X;
}
out& operator<<(out& X, const string& Y) {
  printf("%s", Y.c_str());
  return X;
}
out& operator<<(out& X, const long long& Y) {
  printf("%lld", Y);
  return X;
}
out& operator<<(out& X, const float& Y) {
  printf("%f", Y);
  return X;
}
out& operator<<(out& X, const double& Y) {
  printf("%lf", Y);
  return X;
}
out& operator<<(out& X, const char Y[]) {
  printf("%s", Y);
  return X;
}
template <typename T>
T max(T A) {
  return A;
}
template <typename T, typename... args>
T max(T A, T B, args... S) {
  return max(A > B ? A : B, S...);
}
template <typename T>
T min(T A) {
  return A;
}
template <typename T, typename... args>
T min(T A, T B, args... S) {
  return min(A < B ? A : B, S...);
}
template <typename T>
void vectorize(int y, vector<T>& A) {
  A.resize(y);
}
template <typename T, typename... args>
void vectorize(int y, vector<T>& A, args&&... S) {
  A.resize(y);
  vectorize(y, S...);
}
long long fast(long long a, long long b, long long pr) {
  if (b == 0) return 1 % pr;
  long long ans = 1 % pr;
  while (b) {
    if (b & 1) ans = (ans * a) % pr;
    b >>= 1;
    a = (a * a) % pr;
  }
  return ans;
}
int readInt() {
  int n = 0;
  int ch = getchar_unlocked();
  int sign = 1;
  while (ch < '0' || ch > '9') {
    if (ch == '-') sign = -1;
    ch = getchar_unlocked();
  }
  while (ch >= '0' && ch <= '9')
    n = (n << 3) + (n << 1) + ch - '0', ch = getchar_unlocked();
  n = n * sign;
  return n;
}
long long readLong() {
  long long n = 0;
  int ch = getchar_unlocked();
  int sign = 1;
  while (ch < '0' || ch > '9') {
    if (ch == '-') sign = -1;
    ch = getchar_unlocked();
  }
  while (ch >= '0' && ch <= '9')
    n = (n << 3) + (n << 1) + ch - '0', ch = getchar_unlocked();
  n = n * sign;
  return n;
}
long long readBin() {
  long long n = 0;
  int ch = getchar_unlocked();
  int sign = 1;
  while (ch < '0' || ch > '1') {
    if (ch == '-') sign = -1;
    ch = getchar_unlocked();
  }
  while (ch >= '0' && ch <= '1')
    n = (n << 1) + (ch - '0'), ch = getchar_unlocked();
  return n;
}
long long inv_(long long val,
               long long pr = static_cast<long long>(1000000007)) {
  return fast(val, pr - 2, pr);
}
}  // namespace Xrocks
class solve {
  vector<pair<pair<int, int>, int>> mask_for[10];

 public:
  solve() {
    for (int i = 0; i <= 6; i++) {
      for (int j = 0; j <= i; j++) {
        int num = j * 7 + (i - j) * 4;
        mask_for[num % 10].push_back({{i - j, j}, num / 10});
      }
    }
    int t;
    user_input >> t;
    string S;
    vector<pair<int, int>> ans;
    for (int i = 0; i < t; i++) {
      user_input >> S;
      reverse(S.begin(), S.end());
      S.push_back('0');
      if (solver(S, 0, 0, ans)) {
        vector<long long> A(6);
        for (auto& x : ans) {
          for (int j = 0; j < x.first; j++) A[j] = A[j] * 10 + 4;
          for (int j = x.first; j < x.first + x.second; j++)
            A[j] = A[j] * 10 + 7;
          for (int j = x.first + x.second; j < 6; j++) A[j] *= 10;
        }
        ans.clear();
        for (int i = 0; i < 6; i++) {
          output << A[i] << " ";
        }
        output << "\n";
      } else
        output << "-1\n";
    }
  }
  bool solver(string& S, int Pos, int c, vector<pair<int, int>>& ans) {
    if (Pos == S.length()) {
      return c == 0;
    }
    int dig = S[Pos] - '0';
    dig -= c;
    int add_carry = 0;
    if (dig < 0) dig += 10, ++add_carry;
    for (auto& x : mask_for[dig]) {
      if (solver(S, Pos + 1, add_carry + x.second, ans)) {
        ans.push_back(x.first);
        return true;
      }
    }
    return false;
  }
};
int32_t main() {
  int t = 1, i = 1;
  if (0 || 0) scanf("%d", &t);
  while (t--) {
    if (0) printf("Case #%d: ", i++);
    new solve;
  }
  output << "\n";
  return 0;
}
