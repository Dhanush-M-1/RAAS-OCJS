#include <bits/stdc++.h>
using namespace std;
map<string, int> m;
int d[13] = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
bool check(string a) {
  for (int i = 0; i < 10; i++) {
    if (i == 2 || i == 5) {
      if (a[i] != '-') return false;
    } else {
      if (a[i] < '0' || a[i] > '9') return false;
    }
  }
  int year = (a[6] - '0') * 1000 + (a[7] - '0') * 100 + (a[8] - '0') * 10 +
             (a[9] - '0');
  int month = (a[3] - '0') * 10 + (a[4] - '0');
  int date = (a[0] - '0') * 10 + (a[1] - '0');
  if (year < 2013 || year > 2015) return false;
  if (month <= 0 || month > 12) return false;
  if (date > d[month] || date <= 0) return false;
  return true;
}
int main() {
  string s;
  cin >> s;
  for (int i = 0; i <= s.size() - 10; i++) {
    if (check(s.substr(i, 10))) {
      m[s.substr(i, 10)]++;
    }
  }
  int maxc = -1;
  string id;
  for (map<string, int>::iterator it = m.begin(); it != m.end(); it++) {
    if ((it->second) > maxc) {
      id = (it->first);
      maxc = (it->second);
    }
  }
  cout << id;
  return 0;
}
