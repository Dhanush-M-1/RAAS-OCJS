#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:16777216")
using namespace std;
vector<int> mods = {1000000007, 1000000009, 998244353};
const double pi = acos(-1.0);
const int inf = 0x3f3f3f3f;
const int maxn = 200005;
const int mod = mods[0];
const int day[15] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
void task() {
  string s;
  cin >> s;
  std::map<string, int> u;
  string ans = "";
  int d, m, y, r, mx = 0;
  for (int i = 0; i + 10 <= s.size(); i++) {
    string x = s.substr(i, 10);
    if (sscanf((x + "*1").c_str(), "%2d-%2d-%4d*%d", &d, &m, &y, &r) == 4) {
      if (m > 0 && m <= 12 && y >= 2013 && y <= 2015 && d > 0 && d <= day[m]) {
        u[x]++;
        if (u[x] > mx) {
          mx = u[x];
          ans = x;
        }
      }
    }
  }
  cout << ans << "\n";
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int T = 1;
  for (int __ = 1; __ <= T; __++) {
    task();
  }
  return 0;
}
