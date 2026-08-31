#include <bits/stdc++.h>
using namespace std;
map<string, int> mp;
string s;
int main() {
  map<string, string> month;
  month["01"] = "31";
  month["02"] = "28";
  month["03"] = "31";
  month["04"] = "30";
  month["05"] = "31";
  month["06"] = "30";
  month["07"] = "31";
  month["08"] = "31";
  month["09"] = "30";
  month["10"] = "31";
  month["11"] = "30";
  month["12"] = "31";
  cin >> s;
  for (int i = int(s.size() - 1); i >= 9; i--) {
    string temp = s.substr(i - 3, 4);
    if (temp == "2013" || temp == "2014" || temp == "2015") {
      mp[s.substr(i - 9, 10)]++;
    }
  }
  string ans = "";
  int mx = -1;
  for (map<string, int>::iterator it = mp.begin(); it != mp.end(); it++) {
    if (it->second > mx) {
      string temp = it->first;
      string m = temp.substr(3, 2);
      string d = temp.substr(0, 2);
      if (d[0] == '-' || d[1] == '-' || m[0] == '-' || m[1] == '-' ||
          m[0] > '1' || (m[0] == '1' && m[1] > '2') ||
          (m[0] == '0' && m[1] == '0') || (d[0] == '0' && d[1] == '0') ||
          temp[2] != '-' || temp[5] != '-')
        continue;
      if (month[m] >= d) {
        mx = it->second;
        ans = it->first;
      }
    }
  }
  cout << ans << endl;
}
