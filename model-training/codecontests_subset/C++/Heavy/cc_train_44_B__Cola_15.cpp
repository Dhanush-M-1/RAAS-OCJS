#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long lcm(long long a, long long b) { return a * (b / (gcd(a, b))); }
inline int toInt(string s) {
  int v;
  istringstream sin(s);
  sin >> v;
  return v;
}
inline long long toLL(string s) {
  long long v;
  istringstream sin(s);
  sin >> v;
  return v;
}
template <class T>
inline string toString(T x) {
  ostringstream sout;
  sout << x;
  return sout.str();
}
using namespace std;
long long n;
int a, b, c;
int main() {
  std::ios_base::sync_with_stdio(false);
  long long n;
  cin >> n;
  cin >> a >> b >> c;
  n *= 10;
  int ways = 0;
  for (int i = 0; i <= a; i++) {
    for (int j = 0; j <= b; j++) {
      long long rem = n - (5 * i + 10 * j);
      if (rem >= 0 && rem % 20 == 0) {
        if (rem / 20 <= c) ++ways;
      }
    }
  }
  cout << ways << "\n";
}
