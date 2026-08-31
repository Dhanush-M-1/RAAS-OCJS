#include <bits/stdc++.h>
using namespace std;
long long int M = 1000000007;
long long int gcd(long long int a, long long int b) {
  return (b == 0) ? a : gcd(b, a % b);
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int t = 1;
  while (t--) {
    map<string, string> months;
    months["01"] = "31";
    months["02"] = "28";
    months["03"] = months["05"] = months["07"] = months["08"] = months["10"] =
        months["12"] = "31";
    months["04"] = months["06"] = months["09"] = months["11"] = "30";
    map<string, long long int> m;
    string s;
    cin >> s;
    for (long long int i = 6; i < s.length() - 3; i++) {
      if (s.substr(i, 3) == "201") {
        if (s[i + 3] == '3' || s[i + 3] == '4' || s[i + 3] == '5') {
          if (s[i - 1] == '-' && s[i - 4] == '-' && s[i - 6] != '-' &&
              s[i - 5] != '-' && s[i - 3] != '-' && s[i - 2] != '-') {
            if (s.substr(i - 3, 2) >= "01" && s.substr(i - 3, 2) <= "12") {
              string sub = s.substr(i - 3, 2);
              string day = s.substr(i - 6, 2);
              if (day >= "01" && day <= months[sub]) {
                if (m.count(s.substr(i - 6, 10)) == 0)
                  m[s.substr(i - 6, 10)] = 1;
                else
                  m[s.substr(i - 6, 10)] += 1;
              }
            }
          }
        }
      }
    }
    long long int mx = 0;
    string ans;
    for (auto i : m) {
      if (i.second > mx) {
        mx = i.second;
        ans = i.first;
      }
    }
    cout << ans << "\n";
  }
  return 0;
}
