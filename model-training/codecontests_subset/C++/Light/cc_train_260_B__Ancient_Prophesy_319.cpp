#include <bits/stdc++.h>
using namespace std;
int y, m, d, j, n = 0, i,
                day[15] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
map<string, int> mp;
string x, v, s;
int main() {
  cin >> s;
  for (i = 0; i + 10 <= s.size(); i++) {
    x = s.substr(i, 10);
    if (sscanf((x + "*1").c_str(), "%2d-%2d-%4d*%d", &d, &m, &y, &j) != 4)
      continue;
    if (y < 2013 || y > 2015 || m < 1 || m > 12 || d < 1 || d > day[m])
      continue;
    mp[x]++;
    if (n < mp[x]) n = mp[x], v = x;
  }
  cout << v;
}
