#include <bits/stdc++.h>
using namespace std;
map<string, int> mp;
int main() {
  string str, a;
  while (cin >> str) {
    int k = 0, t = 0;
    int sh[100001], maxx = 0, l;
    string ss[100001];
    memset(sh, 0, sizeof(sh));
    for (int i = 0; i < str.length(); i++) {
      int flag = 0;
      a = str.substr(i, 10);
      if (mp[a] == 0) {
        mp[a] = ++t;
        ss[t] = a;
      }
      int u = mp[a];
      sh[u]++;
      int mm = 0, dd = 0, yy = 0;
      for (int j = 0; j < a.length(); j++) {
        if (j == 2 || j == 5) {
          if (a[j] != '-') flag = 1;
        } else if (a[j] < '0' || a[j] > '9')
          flag = 1;
      }
      dd = (a[0] - '0') * 10 + a[1] - '0';
      mm = (a[3] - '0') * 10 + a[4] - '0';
      yy = (a[6] - '0') * 1000 + (a[7] - '0') * 100 + (a[8] - '0') * 10 + a[9] -
           '0';
      if (mm < 1 || mm > 12) flag = 1;
      if (yy < 2013 || yy > 2015) flag = 1;
      if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 ||
          mm == 12) {
        if (dd <= 0 || dd > 31) flag = 1;
      } else if (mm == 2) {
        if (dd <= 0 || dd > 28) flag = 1;
      } else {
        if (dd <= 0 || dd > 30) flag = 1;
      }
      if (sh[u] > maxx && !flag) {
        maxx = sh[u];
        l = u;
      }
    }
    cout << ss[l] << endl;
  }
  return 0;
}
