#include <bits/stdc++.h>
using namespace std;
bool check(string s) {
  if (s.length() < 10) {
    return false;
  }
  if (s[2] != '-' || s[5] != '-') {
    return false;
  }
  if (s[6] != '2' || s[7] != '0' || s[8] != '1' ||
      (s[9] != '3' && s[9] != '4' && s[9] != '5')) {
    return false;
  }
  if (s[0] < '0' || s[0] > '3') return false;
  if (s[1] < '0' || s[1] > '9') return false;
  if (s[3] < '0' || s[3] > '2') return false;
  if (s[4] < '0' || s[4] > '9') return false;
  long long d = (long long)(s[0] - '0') * 10 + (long long)(s[1] - '0');
  long long m = (long long)(s[3] - '0') * 10 + (long long)(s[4] - '0');
  if (m < 1 || m > 12) {
    return false;
  }
  if (m == 4 || m == 6 || m == 9 || m == 11) {
    if (d < 1 || d > 30) {
      return false;
    }
  } else if (m == 2) {
    if (d < 1 || d > 28) {
      return false;
    }
  } else {
    if (d < 1 || d > 31) {
      return false;
    }
  }
  return true;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  string s;
  cin >> s;
  map<string, long long> mp;
  long long n = s.length();
  for (long long i = 0; i < n; i++) {
    string s1 = s.substr(i, 10);
    if (check(s1)) {
      mp[s1]++;
    }
  }
  long long maxi = -1;
  string s2;
  for (auto j : mp) {
    if (j.second > maxi) {
      maxi = j.second;
      s2 = j.first;
    }
  }
  cout << s2 << "\n";
  return 0;
}
