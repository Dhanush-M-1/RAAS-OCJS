#include <bits/stdc++.h>
using namespace std;
void pl(long long a) { printf("%lld\n", a); }
void pll(long long a, long long b) { printf("%lld %lld\n", a, b); }
void plll(long long a, long long b, long long c) {
  printf("%lld %lld %lld ", a, b, c);
}
void sss(string s) { cout << s, printf("\n"); }
long long string_to_ll(string s) {
  stringstream ss;
  ss << s;
  long long n;
  ss >> n;
  return n;
}
string ll_to_string(long long n) {
  stringstream ss;
  ss << n;
  string s;
  ss >> s;
  return s;
}
double DIS(double x1, double y1, double x2, double y2) {
  return sqrt(pow(x1 - x2, 2.0) + pow(y1 - y2, 2.0));
}
int flag, flag1;
int main() {
  string s, s1;
  int i, n;
  cin >> s >> n;
  while (n--) {
    cin >> s1;
    if (s[0] == s1[1]) flag = 1;
    if (s[1] == s1[0]) flag1 = 1;
    if (s == s1) {
      flag = 1;
      flag1 = 1;
    }
  }
  if (flag && flag1)
    sss("YES");
  else
    sss("NO");
  return 0;
}
