#include <bits/stdc++.h>
using namespace std;
const int mon[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
string ans, s;
int len, L;
inline void check(int y, int m, int d) {
  string res = "";
  for (int i = 1; i <= 4; ++i) {
    res += char(y % 10 + '0');
    y /= 10;
  }
  res += '-';
  for (int i = 1; i <= 2; ++i) {
    res += char(m % 10 + '0');
    m /= 10;
  }
  res += '-';
  for (int i = 1; i <= 2; ++i) {
    res += char(d % 10 + '0');
    d /= 10;
  }
  reverse(res.begin(), res.end());
  if (s.find(res) == string::npos) return;
  int book = 0;
  for (int i = 0; i < L; ++i) {
    if (s.substr(i, 10) == res) {
      book++;
      if (book > len) {
        len = book;
        ans = res;
      }
    }
  }
}
int main() {
  cin >> s;
  L = s.size();
  for (int y = 2013; y <= 2015; ++y) {
    for (int m = 1; m <= 12; ++m) {
      for (int d = 1; d <= mon[m]; ++d) {
        check(y, m, d);
      }
    }
  }
  cout << ans << endl;
  return 0;
}
