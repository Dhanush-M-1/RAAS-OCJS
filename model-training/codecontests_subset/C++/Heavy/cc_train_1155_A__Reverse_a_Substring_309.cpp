#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
long long int rvsr(long long int n) {
  string s = to_string(n);
  reverse(s.begin(), s.end());
  stringstream obj(s);
  obj >> n;
  return n;
}
long long int power(long long int x, long long int y) {
  long long int res = 1;
  x = x;
  while (y > 0) {
    if (y & 1) res = (res * x);
    y = y >> 1;
    x = (x * x);
  }
  return res;
}
long long int logtwo(long long int n) {
  if (n == 1) return 0;
  return logtwo(n / 2) + 1;
}
long long int isprime(long long int n) {
  for (long long int c1 = 2; c1 * c1 <= n; c1++) {
    if (n % c1 == 0) {
      return 0;
    }
  }
  return 1;
}
long long int twop(long long int n) {
  long long int x = 0;
  while (n % 2 == 0) {
    n /= 2;
    x++;
  }
  return x;
}
template <typename T, typename T1>
T amin(T &a, T1 b) {
  if (b < a) a = b;
  return a;
}
long long int t, n;
int c[70];
bool compare(string &s1, string &s2) { return s1.size() < s2.size(); }
int isSubstring(string s1, string s2) {
  int M = s1.length();
  int N = s2.length();
  for (int i = 0; i <= N - M; i++) {
    int j;
    for (j = 0; j < M; j++)
      if (s2[i + j] != s1[j]) break;
    if (j == M) return i;
  }
  return -1;
}
void solve() {
  long long int n;
  cin >> n;
  string s;
  cin >> s;
  char x = s[0];
  int h = 0, l = 0;
  for (long long int i = 0; i < s.length(); i++) {
    if (s[i] > x) {
      x = s[i];
      l = i;
    } else {
      if (s[i] < x && h == 0) {
        h = i;
        break;
      }
    }
  }
  if (h) {
    cout << "YES\n";
    cout << l + 1 << " " << h + 1 << "\n";
  } else {
    cout << "NO\n";
  }
  return;
}
int main() {
  t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
