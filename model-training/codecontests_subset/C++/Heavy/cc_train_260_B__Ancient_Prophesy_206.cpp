#include <bits/stdc++.h>
using namespace std;
map<string, string> mp;
map<string, int> mpp;
int main(int argc, char** argv) {
  ios::sync_with_stdio(0);
  cin.tie(0);
  string s;
  cin >> s;
  int j = 0;
  for (int j = 0; j < s.size(); j++) {
    string findd = "";
    findd += s[j];
    if (j <= s.size() - 4) {
      findd += s[j + 1];
      findd += s[j + 2];
      findd += s[j + 3];
    }
    if (findd == "2013") {
      string tmp = "";
      for (int i = j + 3; i >= 0 && i >= j - 6; i--) {
        tmp += s[i];
      }
      reverse(tmp.begin(), tmp.end());
      string tmp1 = "";
      string tmp2 = "";
      tmp1 += tmp[3];
      tmp1 += tmp[4];
      tmp2 += tmp[0];
      tmp2 += tmp[1];
      int a = 0;
      a = atoi(tmp2.c_str());
      if (isdigit(tmp[0]) && isdigit(tmp[1]) && isdigit(tmp[3]) &&
          isdigit(tmp[4]) && tmp[2] == '-' && tmp[5] == '-' &&
          ((a > 0 && tmp1 == "01" && a <= 31) ||
           (a > 0 && tmp1 == "03" && a <= 31) ||
           (a > 0 && tmp1 == "05" && a <= 31) ||
           (a > 0 && tmp1 == "07" && a <= 31) ||
           (a > 0 && tmp1 == "09" && a <= 30) ||
           (a > 0 && tmp1 == "11" && a <= 30) ||
           (a > 0 && tmp1 == "02" && a <= 28) ||
           (a > 0 && tmp1 == "04" && a <= 30) ||
           (a > 0 && tmp1 == "06" && a <= 30) ||
           (a > 0 && tmp1 == "08" && a <= 31) ||
           (a > 0 && tmp1 == "10" && a <= 31) ||
           (a > 0 && tmp1 == "12" && a <= 31))) {
        mpp[tmp]++;
      }
    } else if (findd == "2014") {
      string tmp = "";
      for (int i = j + 3; i >= j - 6; i--) {
        tmp += s[i];
      }
      reverse(tmp.begin(), tmp.end());
      string tmp1 = "";
      string tmp2 = "";
      tmp1 += tmp[3];
      tmp1 += tmp[4];
      tmp2 += tmp[0];
      tmp2 += tmp[1];
      int a = 0;
      a = atoi(tmp2.c_str());
      if (isdigit(tmp[0]) && isdigit(tmp[1]) && isdigit(tmp[3]) &&
          isdigit(tmp[4]) && tmp[2] == '-' && tmp[5] == '-' &&
          ((a > 0 && tmp1 == "01" && a <= 31) ||
           (a > 0 && tmp1 == "03" && a <= 31) ||
           (a > 0 && tmp1 == "05" && a <= 31) ||
           (a > 0 && tmp1 == "07" && a <= 31) ||
           (a > 0 && tmp1 == "09" && a <= 31) ||
           (a > 0 && tmp1 == "11" && a <= 31) ||
           (a > 0 && tmp1 == "02" && a <= 28) ||
           (a > 0 && tmp1 == "04" && a <= 30) ||
           (a > 0 && tmp1 == "06" && a <= 30) ||
           (a > 0 && tmp1 == "08" && a <= 30) ||
           (a > 0 && tmp1 == "10" && a <= 30) ||
           (a > 0 && tmp1 == "12" && a <= 30))) {
        mpp[tmp]++;
      }
    } else if (findd == "2015") {
      string tmp = "";
      for (int i = j + 3; i >= j - 6; i--) {
        tmp += s[i];
      }
      reverse(tmp.begin(), tmp.end());
      string tmp1 = "";
      string tmp2 = "";
      tmp1 += tmp[3];
      tmp1 += tmp[4];
      tmp2 += tmp[0];
      tmp2 += tmp[1];
      int a = 0;
      a = atoi(tmp2.c_str());
      if (isdigit(tmp[0]) && isdigit(tmp[1]) && isdigit(tmp[3]) &&
          isdigit(tmp[4]) && tmp[2] == '-' && tmp[5] == '-' &&
          ((a > 0 && tmp1 == "01" && a <= 31) ||
           (a > 0 && tmp1 == "03" && a <= 31) ||
           (a > 0 && tmp1 == "05" && a <= 31) ||
           (a > 0 && tmp1 == "07" && a <= 31) ||
           (a > 0 && tmp1 == "09" && a <= 31) ||
           (a > 0 && tmp1 == "11" && a <= 31) ||
           (a > 0 && tmp1 == "02" && a <= 28) ||
           (a > 0 && tmp1 == "04" && a <= 30) ||
           (a > 0 && tmp1 == "06" && a <= 30) ||
           (a > 0 && tmp1 == "08" && a <= 30) ||
           (a > 0 && tmp1 == "10" && a <= 30) ||
           (a > 0 && tmp1 == "12" && a <= 30))) {
        mpp[tmp]++;
      }
    }
  }
  int mx = 0;
  for (map<string, int>::iterator it = mpp.begin(); it != mpp.end(); it++) {
    mx = max((*it).second, mx);
  }
  for (map<string, int>::iterator it = mpp.begin(); it != mpp.end(); it++) {
    if ((*it).second == mx) {
      cout << (*it).first << endl;
      return 0;
    }
  }
  return 0;
}
