#include <bits/stdc++.h>
using namespace std;
long long ans, res, p, q, x;
int cnt[10];
void solve() {
  string str, st = "", st1 = "", st2 = "", m = "";
  cin >> str;
  string s1 = "2013";
  string s2 = "2014";
  string s3 = "2015";
  map<string, long long> mp;
  for (int i = 6; i < str.size() - 3; i++) {
    st = str.substr(i, 4);
    if (st == s1 || st == s2 || st == s3) {
      st1 = "", st2 = "";
      if (str[i - 4] != '-') continue;
      if (str[i - 1] != '-') continue;
      st1 = st1 + str[i - 3] + str[i - 2];
      st2 = st2 + str[i - 6] + str[i - 5];
      if ((st1[0] >= '0' || st1[0] <= '9') &&
          (st1[1] >= '0' && st1[1] <= '9')) {
        if ((st2[0] >= '0' && st2[0] <= '9') &&
            (st2[1] >= '0' && st2[1] <= '9')) {
          if (st1 == "00" || st2 == "00") continue;
          if ((st1 == "04" || st1 == "6" || st1 == "09" || st1 == "11") &&
              st2 <= "30") {
            m = "";
            m = m + st2 + "-" + st1 + "-" + st;
            mp[m]++;
          } else if (st1 == "02" && st2 <= "28") {
            m = "";
            m = m + st2 + "-" + st1 + "-" + st;
            mp[m]++;
          } else if ((st1 == "01" || st1 == "03" || st1 == "05" ||
                      st1 == "07" || st1 == "08" || st1 == "10" ||
                      st1 == "12") &&
                     st2 <= "31") {
            m = "";
            m = m + st2 + "-" + st1 + "-" + st;
            mp[m]++;
          }
        }
      }
    }
  }
  for (auto it = mp.begin(); it != mp.end(); ++it) {
    ans = max(ans, it->second);
  }
  for (auto it = mp.begin(); it != mp.end(); ++it) {
    if (it->second == ans) {
      cout << it->first << "\n";
      return;
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int tt = 1;
  while (tt--) solve();
}
