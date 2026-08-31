#include <bits/stdc++.h>
int dx[] = {0, 0, 1, -1, 1, -1, 1, -1};
int dy[] = {1, -1, 0, 0, -1, 1, 1, -1};
const double PI = acos(-1), EPS = 1e-7;
const int OO = 0x3f3f3f3f, N = 1e5 + 5, mod = 1e9 + 7;
using namespace std;
long long gcd(long long x, long long y) { return (!y) ? x : gcd(y, x % y); }
long long lcm(long long x, long long y) { return ((x / gcd(x, y)) * y); }
void file() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
bool ok(string s) {
  int y = s[6] - '0';
  y *= 10;
  y += (s[7] - '0');
  y *= 10;
  y += (s[8] - '0');
  y *= 10;
  y += (s[9] - '0');
  if (!(y >= 2013 && y <= 2015)) return 0;
  int m = s[3] - '0';
  m *= 10;
  m += s[4] - '0';
  int d = s[0] - '0';
  d *= 10;
  d += s[1] - '0';
  if (!(m >= 1 && m <= 12)) return 0;
  if (!(d >= 1 && d <= 31)) return 0;
  if (d > 28 && m == 2) return 0;
  if (d == 31 &&
      (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12))
    return 1;
  else if (d == 31)
    return 0;
  return 1;
}
int main() {
  file();
  string s;
  cin >> s;
  string d = "13-12-2013";
  map<string, int> mp;
  for (int i = 0; i <= (int)s.size() - (int)d.size(); i++) {
    string cur = s.substr(i, (int)d.size());
    int cnt = 0;
    for (int j = 0; j < (int)cur.size(); j++)
      if (cur[j] == '-') cnt++;
    if (cnt != 2 || cur[2] != '-' || cur[5] != '-') continue;
    if (ok(cur)) {
      mp[cur]++;
    }
  }
  int mx = 0;
  string ans;
  for (auto t : mp) {
    if (t.second > mx) {
      mx = t.second;
      ans = t.first;
    }
  }
  cout << ans;
}
