#include <bits/stdc++.h>
template <typename T>
T inline SQR(const T &a) {
  return a * a;
}
template <typename T>
T inline ABS(const T &a) {
  return a < 0 ? -a : a;
}
const double EPS = 1e-9;
inline int SGN(double a) {
  return ((a > EPS) ? (1) : ((a < -EPS) ? (-1) : (0)));
}
inline int CMP(double a, double b) { return SGN(a - b); }
using namespace std;
int ndays[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int main(int argc, char *argv[]) {
  ios::sync_with_stdio(false);
  string s;
  cin >> s;
  map<string, int> occ;
  int i = 0, j = 9;
  while (j < int((s).size())) {
    if (s[i + 2] == s[i + 5] && s[i + 5] == '-') {
      int mm = -1, dd = -1, yy = -1;
      if (s[i] != '-' && s[i + 1] != '-') {
        dd = 10 * (s[i] - '0') + (s[i + 1] - '0');
      }
      if (s[i + 3] != '-' && s[i + 4] != '-') {
        mm = 10 * (s[i + 3] - '0') + (s[i + 4] - '0');
      }
      if (s[i + 6] != '-' && s[i + 7] != '-' && s[i + 8] != '-' &&
          s[i + 9] != '-') {
        yy = 1000 * (s[i + 6] - '0') + 100 * (s[i + 7] - '0') +
             10 * (s[i + 8] - '0') + (s[i + 9] - '0');
      }
      if ((mm != -1) && (dd != -1) && (yy != -1)) {
        if (2013 <= yy && yy <= 2015) {
          if (1 <= mm && mm <= 12) {
            if (1 <= dd && dd <= ndays[mm]) {
              occ[s.substr(i, 10)]++;
            }
          }
        }
      }
    }
    i++, j++;
  }
  int mx = -1;
  string res;
  for (__typeof((occ).begin()) dt = occ.begin(); dt != occ.end(); dt++) {
    if (dt->second > mx) {
      mx = dt->second;
      res = dt->first;
    }
  }
  cout << res << "\n";
  return 0;
}
