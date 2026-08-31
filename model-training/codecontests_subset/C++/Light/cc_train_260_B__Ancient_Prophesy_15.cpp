#include <bits/stdc++.h>
using namespace std;
string s;
const int day[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int main() {
  cin >> s;
  map<string, int> mp;
  int v = INT_MIN;
  string ans;
  int len = s.length();
  for (int i = 0; i + 9 < len; i++) {
    string x = s.substr(i, 10);
    int d = 0, m = 0, y = 0, j = 0;
    if (sscanf(((x + "*1").c_str()), "%2d-%2d-%4d*%d", &d, &m, &y, &j) != 4)
      continue;
    if (y < 2013 || y > 2015 || m < 1 || m > 12 || d < 1 || d > day[m - 1])
      continue;
    mp[x]++;
    if (mp[x] > v) {
      v = mp[x];
      ans = x;
    }
  }
  cout << ans;
  return 0;
}
