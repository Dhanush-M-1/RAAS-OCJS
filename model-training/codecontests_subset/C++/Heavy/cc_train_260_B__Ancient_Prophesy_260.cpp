#include <bits/stdc++.h>
using namespace std;
int read() {
  int x;
  scanf("%d", &x);
  return x;
}
long long readL() {
  long long x;
  scanf("%I64d", &x);
  return x;
}
bool isdigits(string s) {
  int sl = s.length();
  for (int i = 0; i < sl; i++) {
    if (!isdigit(s[i])) return false;
  }
  return true;
}
int sstoi(string s) {
  istringstream buffer(s);
  int value;
  buffer >> value;
  return value;
}
bool ispattern(string s) {
  int sl = s.length();
  if (sl != 10) return false;
  if (s[2] != '-' || s[5] != '-') return false;
  int f = s.find('-');
  if (f < 2 || f > 5 || (f > 2 && f < 5)) return false;
  if (!isdigits(s.substr(0, 2)) || !isdigits(s.substr(3, 2)) ||
      !isdigits(s.substr(6, 4)))
    return false;
  int dd = sstoi(s.substr(0, 2));
  if (dd < 1 || dd > 31) return false;
  int mm = sstoi(s.substr(3, 2));
  if (mm < 1 || mm > 12 || (mm == 2 && dd > 28) ||
      ((mm == 4 || mm == 6 || mm == 9 || mm == 11) && dd > 30))
    return false;
  int yyyy = sstoi(s.substr(6, 4));
  if (yyyy < 2013 || yyyy > 2015) return false;
  return true;
}
string res;
map<string, int> m;
int main() {
  string s;
  cin >> s;
  int sl = s.length();
  if (sl < 10) return cout << -1, 0;
  for (int i = 0; i <= sl - 9; i++) {
    if (ispattern(s.substr(i, 10))) m[s.substr(i, 10)]++;
  }
  int mx = -1e9;
  for (auto e : m) {
    if (e.second > mx) {
      mx = e.second;
      res = e.first;
    }
  }
  if (mx == -1e9) return cout << -1, 0;
  cout << res;
  return 0;
}
