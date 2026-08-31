#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1);
const double eps = 1e-9;
const int inf = 2000000000;
const long long infLL = 9000000000000000000;
inline bool checkBit(long long n, int i) { return n & (1LL << i); }
inline long long setBit(long long n, int i) {
  return n | (1LL << i);
  ;
}
inline long long resetBit(long long n, int i) { return n & (~(1LL << i)); }
int dx[] = {0, 0, +1, -1};
int dy[] = {+1, -1, 0, 0};
inline bool EQ(double a, double b) { return fabs(a - b) < 1e-9; }
inline bool isLeapYear(long long year) {
  return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
}
inline void normal(long long &a) {
  a %= 1000000007;
  (a < 0) && (a += 1000000007);
}
inline long long modMul(long long a, long long b) {
  a %= 1000000007, b %= 1000000007;
  normal(a), normal(b);
  return (a * b) % 1000000007;
}
inline long long modAdd(long long a, long long b) {
  a %= 1000000007, b %= 1000000007;
  normal(a), normal(b);
  return (a + b) % 1000000007;
}
inline long long modSub(long long a, long long b) {
  a %= 1000000007, b %= 1000000007;
  normal(a), normal(b);
  a -= b;
  normal(a);
  return a;
}
inline long long modPow(long long b, long long p) {
  long long r = 1;
  while (p) {
    if (p & 1) r = modMul(r, b);
    b = modMul(b, b);
    p >>= 1;
  }
  return r;
}
inline long long modInverse(long long a) { return modPow(a, 1000000007 - 2); }
inline long long modDiv(long long a, long long b) {
  return modMul(a, modInverse(b));
}
int main() {
  string s;
  getline(cin, s);
  int l = s.length();
  int pos = 1, neg = 0, ques = 0, n = 0;
  for (int i = 0; i < l; ++i) {
    if (s[i] == '+')
      ++pos;
    else if (s[i] == '-')
      ++neg;
    else if (s[i] == '?')
      ++ques;
    else if (s[i] == '=') {
      i += 2;
      while (i < l) {
        n *= 10;
        n += s[i] - '0';
        ++i;
      }
    }
  }
  if (!(pos - n * neg <= n && n <= n * pos - neg)) {
    ;
    cout << "Impossible";
    return 0;
  }
  cout << "Possible" << '\n';
  int sum = 0, sign;
  for (int i = 0; i < l; ++i) {
    if (s[i] == '=') {
      cout << "= " << n;
      break;
    }
    if (i == 0) {
      --pos;
      for (int j = 1; j <= n; ++j) {
        if (sum + j + pos - n * neg <= n && n <= sum + j + n * pos - neg) {
          sum += j;
          cout << j << " ";
          break;
        }
      }
    } else if (s[i] != '?') {
      if (s[i] == '+') {
        sign = 1;
        --pos;
        cout << "+"
             << " ";
      } else if (s[i] == '-') {
        sign = -1;
        --neg;
        cout << "- ";
      }
    } else if (s[i] == '?') {
      for (int j = 1; j <= n; ++j) {
        if (sum + sign * j + pos - n * neg <= n &&
            n <= sum + sign * j + n * pos - neg) {
          sum += sign * j;
          cout << j << " ";
          break;
        }
      }
    }
  }
}
