#include <bits/stdc++.h>
using namespace std;
map<string, int> m;
string ans;
int cnt = 0;
int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int main() {
  string s;
  cin >> s;
  for (int i = 0; i <= s.length() - 10; i++) {
    if (!(isdigit(s[i]) && isdigit(s[i + 1]) && s[i + 2] == '-' &&
          isdigit(s[i + 3]) && isdigit(s[i + 4]) && s[i + 5] == '-' &&
          isdigit(s[i + 6]) && isdigit(s[i + 7]) && isdigit(s[i + 8]) &&
          isdigit(s[i + 9])))
      continue;
    int d, mo, y;
    sscanf(s.substr(i, 10).c_str(), "%d-%d-%d", &d, &mo, &y);
    if (mo > 12 || mo < 1) continue;
    if (d > days[mo] || d < 1) continue;
    if (y > 2015 || y < 2013) continue;
    string tmp = s.substr(i, 10);
    m[tmp]++;
    if (m[tmp] > cnt) {
      cnt = m[tmp];
      ans = tmp;
    }
  }
  cout << ans;
}
