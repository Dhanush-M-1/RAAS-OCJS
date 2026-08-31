#include <bits/stdc++.h>
using namespace std;
int hash1(string s) {
  int n = 0, b = 1;
  for (int i = 0; i < s.size(); i++, b *= 10) n += s[i] * b;
  return n;
}
int main(int argc, char const *argv[]) {
  string str;
  cin >> str;
  int s;
  int i, j, k, t, p;
  string date;
  map<int, int> m;
  map<int, string> ref;
  for (i = 0; i < str.size(); i++) {
    s = 0;
    string made = "";
    j = i - 1;
    while (1) {
      j++;
      if (s == 0) {
        if (str[j] >= '0' && str[j] <= '9') {
          s = 1;
          made.append(1, str[j]);
          continue;
        } else
          break;
      }
      if (s == 1) {
        if (str[j] >= '0' && str[j] <= '9') {
          s = 2;
          made.append(1, str[j]);
          continue;
        } else
          break;
      }
      if (s == 2) {
        if (str[j] == '-') {
          s = 3;
          made.append(1, str[j]);
          continue;
        } else
          break;
      }
      if (s == 3) {
        if (str[j] >= '0' && str[j] <= '9') {
          s = 4;
          made.append(1, str[j]);
          continue;
        } else
          break;
      }
      if (s == 4) {
        if (str[j] >= '0' && str[j] <= '9') {
          s = 5;
          made.append(1, str[j]);
          continue;
        } else
          break;
      }
      if (s == 5) {
        if (str[j] == '-') {
          s = 6;
          made.append(1, str[j]);
          continue;
        } else
          break;
      }
      if (s == 6) {
        if (str[j] >= '0' && str[j] <= '9') {
          s = 7;
          made.append(1, str[j]);
          continue;
        } else
          break;
      }
      if (s == 7) {
        if (str[j] >= '0' && str[j] <= '9') {
          s = 8;
          made.append(1, str[j]);
          continue;
        } else
          break;
      }
      if (s == 8) {
        if (str[j] >= '0' && str[j] <= '9') {
          s = 9;
          made.append(1, str[j]);
          continue;
        } else
          break;
      }
      if (s == 9) {
        if (str[j] >= '0' && str[j] <= '9') {
          s = 10;
          made.append(1, str[j]);
          continue;
        } else
          break;
      }
      if (s == 10) {
        string d = made.substr(0, 2);
        string mo = made.substr(3, 2);
        string y = made.substr(6, 4);
        int date, month, year;
        istringstream(d) >> date;
        istringstream(mo) >> month;
        istringstream(y) >> year;
        if (!(year >= 2013 && year <= 2015)) break;
        if (date <= 0) break;
        if (!(month >= 1 && month <= 12)) break;
        if (month == 2) {
          if (date > 28) break;
        } else if (month == 1 || month == 3 || month == 5 || month == 7 ||
                   month == 8 || month == 10 || month == 12) {
          if (date > 31) break;
        } else {
          if (date > 30) break;
        }
        int h = hash1(made);
        ref[h] = made;
        if (m.find(h) == m.end())
          m[h] = 1;
        else
          m[h] = m[h] + 1;
        break;
      }
      j++;
    }
  }
  map<int, int>::iterator it;
  int mx = 0;
  string maxs;
  for (it = m.begin(); it != m.end(); it++) {
    if (it->second > mx) {
      mx = it->second;
      maxs = ref[it->first];
    }
  }
  cout << maxs << endl;
  ;
  return 0;
}
