#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void rread(T& num) {
  num = 0;
  T f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') num = num * 10 + ch - '0', ch = getchar();
  num *= f;
}
inline int getgcd(int x, int y) {
  if (!x) return y;
  return getgcd(y % x, x);
}
inline int power(int x, int k, int p) {
  int res = 1;
  for (; k; k >>= 1, x = (long long)x * x % p)
    if (k & 1) res = (long long)res * x % p;
  return res;
}
const double pi = acos(-1);
inline void judge() { freopen("input.txt", "r", stdin); }
int n;
string s[10];
int main() {
  cin >> s[1] >> s[2];
  rread(n);
  cout << s[1] << " " << s[2] << endl;
  for (int(i) = (1); (i) <= (n); (i)++) {
    cin >> s[3] >> s[4];
    for (int(j) = (3); (j) <= (4); (j)++) {
      bool flag = 0;
      for (int(k) = (1); (k) <= (2); (k)++)
        if (s[j] == s[k]) {
          flag = 1;
          s[k] = s[7 - j];
          break;
        }
      if (flag) break;
    }
    cout << s[1] << " " << s[2] << endl;
  }
  return 0;
}
