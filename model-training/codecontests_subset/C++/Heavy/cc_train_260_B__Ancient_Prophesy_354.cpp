#include <bits/stdc++.h>
using namespace std;
void lpss(vector<int> &lps, string &s) {
  lps[0] = 0;
  lps[1] = 0;
  int i = 2, j = 0;
  while (i < s.length()) {
    if (s[i] == s[j + 1]) {
      lps[i] = ++j;
      ++i;
    } else {
      if (j != 0)
        j = lps[j];
      else {
        lps[i] = 0;
        ++i;
      }
    }
  }
}
int chk(string &s, string &p, vector<int> &lps) {
  int i = 0, j = 0, c = 0;
  while (i < s.length()) {
    if (s[i] == p[j + 1]) {
      i++;
      j++;
      if (j == p.length() - 1) {
        c++;
        j = lps[j];
      }
    } else {
      if (j != 0)
        j = lps[j];
      else
        i++;
    }
  }
  return c;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int test = 1;
  while (test--) {
    string s;
    cin >> s;
    string d[31] = {"01", "02", "03", "04", "05", "06", "07", "08",
                    "09", "10", "11", "12", "13", "14", "15", "16",
                    "17", "18", "19", "20", "21", "22", "23", "24",
                    "25", "26", "27", "28", "29", "30", "31"};
    string m[12] = {"01", "02", "03", "04", "05", "06",
                    "07", "08", "09", "10", "11", "12"};
    string y[3] = {"2013", "2014", "2015"};
    string ans;
    ans.reserve(15);
    int mx = 0;
    for (int dd = 0; dd < 31; dd++) {
      for (int mm = 0; mm < 12; mm++) {
        for (int yy = 0; yy < 3; yy++) {
          if ((mm == 1 && dd <= 27) ||
              (((mm == 3) || (mm == 5) || (mm == 8) || (mm == 10)) &&
               dd <= 29) ||
              (mm == 0 || mm == 2 || mm == 4 || mm == 6 || mm == 7 || mm == 9 ||
               mm == 11)) {
            string p;
            p.reserve(15);
            p = "#";
            p += d[dd];
            p += "-";
            p += m[mm];
            p += "-";
            p += y[yy];
            vector<int> lps(p.length());
            lpss(lps, p);
            int c = chk(s, p, lps);
            if (c > mx) {
              mx = c;
              ans = p.substr(1);
            }
          }
        }
      }
    }
    cout << ans;
  }
}
