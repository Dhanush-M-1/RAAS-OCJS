#include <bits/stdc++.h>
using namespace std;
map<string, int> mm;
const int months[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
bool isnum(char a) {
  if (a < '0' || a > '9') return false;
  return true;
}
bool judge(string a) {
  if (!(isnum(a[0]) && isnum(a[1]) && isnum(a[3]) && isnum(a[4]) &&
        isnum(a[6]) && isnum(a[7]) && isnum(a[8]) && isnum(a[9])))
    return false;
  if (a[2] != '-' || a[5] != '-') return false;
  int year = (a[6] - '0') * 1000 + (a[7] - '0') * 100 + (a[8] - '0') * 10 +
             (a[9] - '0');
  int month = (a[3] - '0') * 10 + (a[4] - '0');
  int day = (a[0] - '0') * 10 + (a[1] - '0');
  if (year < 2013 || year > 2015) return false;
  if (month < 1 || month > 12) return false;
  if (day < 1 || day > months[month]) return false;
  return true;
}
int main() {
  string str, s;
  while (cin >> str) {
    mm.clear();
    s = "21-12-2013";
    for (int i = 0; i <= str.size() - 10; i++) {
      for (int j = 0; j != 10; j++) {
        s[j] = str[i + j];
      }
      mm[s]++;
    }
    map<string, int>::iterator it;
    int mmax = -1;
    for (it = mm.begin(); it != mm.end(); ++it) {
      if (mmax < (it->second)) {
        if (judge(it->first)) {
          s = it->first;
          mmax = it->second;
        }
      }
    }
    cout << s << endl;
  }
}
