#include <bits/stdc++.h>
using namespace std;
map<string, int> mp;
int main() {
  int T[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  string s, t, Ans = "", M;
  int d = 0, m = 0, y = 0, x = 0;
  cin >> s;
  for (int i = 0; i <= s.length() - 10; i++) {
    t = s.substr(i + 6, 4);
    if (t != "2013" && t != "2014" && t != "2015") continue;
    if (s[i + 2] != '-' || s[i + 5] != '-') continue;
    if (s[i + 3] == '-' || s[i + 4] == '-') continue;
    if (s[i] == '-' || s[i + 1] == '-') continue;
    m = 10 * int(s[i + 3] - '0') + int(s[i + 4] - '0');
    d = 10 * int(s[i] - '0') + int(s[i + 1] - '0');
    if (m > 12 || d > T[m] || d == 0) continue;
    M = s.substr(i, 10);
    mp[M]++;
    if (mp[M] > x) Ans = M, x = mp[M];
  }
  cout << Ans;
}
