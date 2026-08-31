#include <bits/stdc++.h>
using namespace std;
const int block_size = 320;
const long long mod = 1e9 + 7;
const long double eps = 1e-9;
const int inf = mod;
const double PI = atan(1) * 4;
template <typename T>
inline int sign(const T &a) {
  if (a < 0) return -1;
  if (a > 0) return 1;
  return 0;
}
template <typename T>
inline void in(T &x) {
  x = 0;
  T f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  x *= f;
}
long long n;
string s[1000];
long long ext[2];
long long sum = 0;
long long val[1000];
int main() {
  string f;
  int cnt = 1;
  cin >> f;
  while (1) {
    cin >> f;
    if (f == "=") {
      cin >> n;
      break;
    } else {
      s[cnt++] = f;
      cin >> f;
    }
  }
  ext[0] = 1;
  ext[1] = n;
  s[0] = "+";
  for (long long i = 1; i < cnt; i++) {
    if (s[i] == "-") {
      ext[0] -= n;
      ext[1] -= 1;
    } else {
      ext[0] += 1;
      ext[1] += n;
    }
  }
  if (n < ext[0] || n > ext[1]) {
    cout << "Impossible", exit(0);
    ;
  }
  for (long long i = 0; i < cnt; i++) {
    val[i] = 1;
    if (s[i] == "+")
      sum++;
    else
      sum--;
  }
  for (long long i = 0; i < cnt; i++) {
    if (sum > n) {
      if (s[i] == "-") {
        auto adjust = min(sum - n, n - val[i]);
        sum -= adjust;
        val[i] += adjust;
      }
    }
    if (sum < n) {
      if (s[i] == "+") {
        auto adjust = min(n - sum, n - val[i]);
        sum += adjust;
        val[i] += adjust;
      }
    }
  }
  cout << "Possible" << endl;
  cout << val[0];
  for (long long i = 1; i < cnt; i++) {
    cout << " " << s[i] << ' ' << val[i];
  }
  cout << " = " << n;
  return 0;
}
