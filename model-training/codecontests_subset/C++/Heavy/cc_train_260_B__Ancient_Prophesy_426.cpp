#include <bits/stdc++.h>
using namespace std;
string s;
string tmp;
string ans;
int mx;
map<string, int> m;
const int MD[] = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
const bool flg[] = {0, 0, 1, 0, 0, 1, 0, 0, 0, 0};
bool check(int l, int r) {
  int g = 0, d = 0, m = 0, y = 0;
  for (int i = l; i <= r; i++) {
    if (s[i] == '-' && flg[i - l])
      g++;
    else if (s[i] == '-' && !flg[i - l])
      return false;
  }
  if (g != 2) {
    return false;
  }
  for (int i = l + 6; i <= l + 9; i++) {
    y = y * 10 + s[i] - '0';
  }
  if (y > 2015 || y < 2013) {
    return false;
  }
  for (int i = l + 3; i <= l + 4; i++) {
    m = m * 10 + s[i] - '0';
  }
  if (m <= 0 || m > 12) {
    return false;
  }
  for (int i = l; i <= l + 1; i++) {
    d = d * 10 + s[i] - '0';
  }
  if (d <= 0 || d > MD[m]) {
    return false;
  }
  return true;
}
int main() {
  cin >> s;
  int l = 0, r = 9;
  int sz = s.size();
  while (r <= sz) {
    tmp = "";
    tmp = s.substr(l, 10);
    if (check(l, r)) {
      m[tmp]++;
      if (m[tmp] > mx) {
        mx = m[tmp];
        ans = "";
        ans = tmp;
      }
    }
    l++;
    r++;
  }
  cout << ans;
  return 0;
}
