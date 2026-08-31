#include <bits/stdc++.h>
using namespace std;
const int maxn = 100010;
const int d[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int t, n;
string s;
map<int, int> red;
void output(int idx, int a[]) {
  for (int i = 0; i <= idx; i++) cout << a[i] << endl;
}
void work() {
  red.clear();
  int idx = 0;
  string res[maxn], a = "";
  for (int i = 0; i < s.length(); i++) {
    if (s[i] == '-') {
      res[idx++] = a;
      a = "";
    } else {
      a.push_back(s[i]);
    }
  }
  res[idx] = a;
  for (int i = idx; i >= 2; i--) {
    if (res[i].length() >= 4) {
      int tmp = (res[i][0] - '0') * 1000 + (res[i][1] - '0') * 100 +
                (res[i][2] - '0') * 10 + (res[i][3] - '0');
      if (tmp >= 2013 && tmp <= 2015) {
        int dd = tmp * 10000;
        if (res[i - 1].length() == 2) {
          tmp = (res[i - 1][0] - '0') * 10 + (res[i - 1][1] - '0');
          if (tmp > 0 && tmp <= 12) {
            dd += tmp * 100;
            if (res[i - 2].length() >= 2) {
              int mm = tmp;
              tmp = (res[i - 2][res[i - 2].length() - 2] - '0') * 10 +
                    (res[i - 2][res[i - 2].length() - 1] - '0');
              if (tmp > 0 && tmp <= d[mm]) {
                dd += tmp;
                red[dd]++;
              }
            }
          }
        }
      }
    }
  }
  int amt = 0, ans;
  for (map<int, int>::iterator it = red.begin(); it != red.end(); it++) {
    if (it->second >= amt) {
      amt = it->second;
      ans = it->first;
    }
  }
  for (int i = 0; i < 2; i++) {
    if (ans % 100 < 10)
      cout << "0" << ans % 100 << "-";
    else
      cout << ans % 100 << "-";
    ans /= 100;
  }
  cout << ans << endl;
}
int main() {
  ios::sync_with_stdio(false);
  while (cin >> s) work();
  return 0;
}
