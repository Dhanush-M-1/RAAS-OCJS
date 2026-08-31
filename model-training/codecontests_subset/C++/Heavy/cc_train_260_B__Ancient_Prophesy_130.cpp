#include <bits/stdc++.h>
using namespace std;
bool tep(pair<string, int> a, pair<string, int> b) {
  return a.second > b.second;
}
bool f(string s) {
  for (int i = 0; i < 10; i++) {
    if ((i == 2 || i == 5) && s[i] != '-') return 0;
    if ((i != 2 && i != 5) && s[i] == '-') return 0;
  }
  if (s.substr(6) != "2013" && s.substr(6) != "2014" && s.substr(6) != "2015")
    return 0;
  if ((s[3] != '0' && s[4] != '0' && s[4] != '1' && s[4] != '2') ||
      s[3] > '1' || (s[3] == '0' && s[4] == '0'))
    return 0;
  if (s.substr(0, 2) == "00") return 0;
  if (s.substr(3, 2) == "02" && (s[0] >= '3' || (s[0] == '2' && s[1] > '8')))
    return 0;
  if ((s.substr(3, 2) == "04" || s.substr(3, 2) == "06" ||
       s.substr(3, 2) == "09" || s.substr(3, 2) == "11") &&
      (s[0] > '3' || (s[0] == '3' && s[1] > '0')))
    return 0;
  else if (s.substr(3, 2) != "02" &&
           (s[0] > '3' || (s[0] == '3' && s[1] > '1')))
    return 0;
  return 1;
}
int main() {
  string str;
  vector<pair<string, int> > x;
  int xn = 0;
  cin >> str;
  for (int i = 0; i < str.length() - 9; i++) {
    string ss = str.substr(i, 10);
    if (f(ss)) {
      int j;
      for (j = 0; j < xn; j++)
        if (ss == x[j].first) {
          x[j].second++;
          break;
        }
      if (j == xn) {
        xn++;
        x.push_back(make_pair(ss, 1));
      }
    }
  }
  pair<string, int> xx[xn];
  for (int i = 0; i < xn; i++) {
    xx[i].first = x[i].first;
    xx[i].second = x[i].second;
  }
  sort(xx, xx + xn, tep);
  cout << xx[0].first << endl;
  return 0;
}
