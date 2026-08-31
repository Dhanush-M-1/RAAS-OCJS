#include <bits/stdc++.h>
using namespace std;
long long n, m, ans;
string str;
map<string, long long> m1;
long long solve() {
  cin >> str;
  n = (long long)str.size();
  for (long long i = 0; i <= n - 10; ++i) {
    string s = str.substr(i, 10);
    vector<long long> v1;
    for (long long j = 0; j <= 9; ++j) {
      if (s[j] == '-') v1.push_back(j);
    }
    if ((long long)v1.size() == 2 && v1[0] == 2 && v1[1] == 5) {
      long long f = 0;
      string s1 = s.substr(0, 2);
      string s2 = s.substr(3, 2);
      string s3 = s.substr(6, 4);
      long long a1 = stoll(s1), a2 = stoll(s2), a3 = stoll(s3);
      if (a3 >= 2013 && a3 <= 2015) {
        if (a2 == 1 && a1 >= 1 && a1 <= 31)
          f = 1;
        else if (a2 == 2 && a1 >= 1 && a1 <= 28)
          f = 1;
        else if (a2 == 3 && a1 >= 1 && a1 <= 31)
          f = 1;
        else if (a2 == 4 && a1 >= 1 && a1 <= 30)
          f = 1;
        else if (a2 == 5 && a1 >= 1 && a1 <= 31)
          f = 1;
        else if (a2 == 6 && a1 >= 1 && a1 <= 30)
          f = 1;
        else if (a2 == 7 && a1 >= 1 && a1 <= 31)
          f = 1;
        else if (a2 == 8 && a1 >= 1 && a1 <= 31)
          f = 1;
        else if (a2 == 9 && a1 >= 1 && a1 <= 30)
          f = 1;
        else if (a2 == 10 && a1 >= 1 && a1 <= 31)
          f = 1;
        else if (a2 == 11 && a1 >= 1 && a1 <= 30)
          f = 1;
        else if (a2 == 12 && a1 >= 1 && a1 <= 31)
          f = 1;
      }
      if (f) m1[s]++;
    }
  }
  for (auto it : m1) ans = max(ans, it.second);
  for (auto it : m1) {
    if (ans == it.second) {
      cout << it.first;
      return 0;
    }
  }
  return 0;
}
signed main() {
  ios::sync_with_stdio(0);
  long long t = 1;
  while (t--) solve();
  return 0;
}
