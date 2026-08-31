#include <bits/stdc++.h>
using namespace std;
bool valid(string s) {
  int day = (s[0] - '0') * 10 + s[1] - '0';
  int month = (s[3] - '0') * 10 + s[4] - '0';
  int year =
      (s[6] - '0') * 1000 + (s[7] - '0') * 100 + (s[8] - '0') * 10 + s[9] - '0';
  if (year > 2012 && year < 2016) {
    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 ||
        month == 10 || month == 12) {
      if (day < 32 && day > 0) {
        return true;
      }
    } else if (month == 2) {
      if (day < 29 && day > 0) {
        return true;
      }
    } else {
      if (month < 13 && day < 31 && day > 0) {
        return true;
      }
    }
  }
  return false;
}
int main() {
  string s;
  cin >> s;
  vector<string> a;
  for (int i = 0; s[i + 9] != '\0'; i++) {
    if (s[i + 2] == '-' && s[i + 5] == '-' && s[i] != '-' && s[i + 1] != '-' &&
        s[i + 3] != '-' && s[i + 4] != '-') {
      string t = string(s.begin() + i, s.begin() + i + 10);
      if (valid(t)) {
        a.push_back(t);
      }
    }
  }
  int ma = 0, ind = -1;
  sort(a.begin(), a.end());
  for (int i = 0; i < a.size(); i++) {
    int t = count(a.begin() + i, a.end(), a[i]);
    if (t >= ma) {
      ma = t;
      ind = i;
    }
    i += t - 1;
  }
  cout << a[ind];
}
