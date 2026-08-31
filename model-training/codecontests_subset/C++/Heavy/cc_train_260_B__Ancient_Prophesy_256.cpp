#include <bits/stdc++.h>
using namespace std;
map<string, int> cnt;
const int day[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
void check(string s) {
  if (count(s.begin(), s.end(), '-') != 2) {
    return;
  }
  string ddS, mmS, yyS;
  string cur = "";
  for (char x : s) {
    if (x == '-') {
      if (ddS == "") {
        ddS = cur;
      } else if (mmS == "") {
        mmS = cur;
      } else if (yyS == "") {
        yyS = cur;
      }
      cur = "";
    } else {
      cur += x;
    }
  }
  yyS = cur;
  if (ddS == "" or mmS == "" or yyS == "") return;
  if (yyS[0] == '0') return;
  int dd = stoi(ddS);
  int mm = stoi(mmS);
  int yy = stoi(yyS);
  if (yy >= 2013 and yy <= 2015) {
    if (mm >= 1 and mm <= 12) {
      if (dd > 0) {
        if (dd <= day[mm]) {
          if (ddS.size() == 1) {
            ddS = "0" + ddS;
          }
          if (mmS.size() == 1) {
            mmS = "0" + mmS;
          }
          string built = ddS + "-" + mmS + "-" + yyS;
          cnt[built]++;
        }
      }
    }
  }
}
signed main() {
  ios::sync_with_stdio(0);
  cin.sync_with_stdio(0);
  cin.tie(0);
  string s;
  cin >> s;
  for (int add = 9; add <= 9; add++) {
    for (int i = 0; i + add < s.size(); i++) {
      string a;
      for (int j = 0; j <= add; j++) {
        a += s[i + j];
      }
      check(a);
    }
  }
  int ma = 0;
  string mas = "?";
  for (auto x : cnt) {
    if (x.second >= ma) {
      ma = x.second;
      mas = x.first;
    }
  }
  cout << mas << '\n';
}
