#include <bits/stdc++.h>
using namespace std;
const string f = "dd-mm-yyyy";
int month[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int main() {
  bool ff;
  string s, a;
  int da, mo, ye;
  map<string, int> mp;
  cin >> s;
  for (int i = 0; i <= s.size() - f.size(); i++) {
    a = s.substr(i, f.size());
    ff = true;
    for (int j = 0; j < a.size(); j++) {
      if (f[j] != '-' && !isdigit(a[j])) ff = false;
      if (f[j] == '-' && a[j] != '-') ff = false;
    }
    if (!ff) continue;
    if (sscanf(a.c_str(), "%2d-%2d-%4d", &da, &mo, &ye) == 3) {
      if (ye >= 2013 && ye <= 2015 && mo < 13 && mo > 0 && da <= month[mo] &&
          da > 0)
        mp[a]++;
    }
  }
  int maxn = 0;
  for (map<string, int>::iterator it = mp.begin(); it != mp.end(); it++)
    maxn = max(maxn, it->second);
  for (map<string, int>::iterator it = mp.begin(); it != mp.end(); it++)
    if (it->second == maxn) cout << it->first << endl;
  return 0;
}
