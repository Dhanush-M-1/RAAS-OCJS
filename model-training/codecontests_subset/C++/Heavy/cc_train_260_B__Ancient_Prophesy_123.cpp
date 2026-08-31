#include <bits/stdc++.h>
using namespace std;
int w[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
string s;
int getint(string p) {
  int res = 0;
  for (int j = 0; j < p.length(); j++)
    if (p[j] == '-')
      return -1;
    else {
      res = res * 10 + (p[j] - '0');
    }
  return res;
}
map<string, int> mm;
map<string, int>::iterator it;
int main() {
  cin >> s;
  string ans;
  int m = 0, index;
  for (int i = 0; i < s.length(); i++)
    if (s[i] == '-' && i >= 2 && i <= s.length() - 4) {
      int k1 = getint(s.substr(i - 2, 2));
      int k2 = getint(s.substr(i + 1, 2));
      int k3 = getint(s.substr(i + 4, 4));
      if (k2 > 0 && k2 < 13)
        if (k1 > 0 && k1 <= w[k2])
          if (k3 >= 2013 && k3 <= 2015) {
            string s1 = s.substr(i - 2, 10);
            mm[s1]++;
          }
    }
  for (it = mm.begin(); it != mm.end(); it++)
    if (m < it->second) m = it->second, ans = it->first;
  cout << ans;
  return 0;
}
