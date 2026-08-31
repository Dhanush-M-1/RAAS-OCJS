#include <bits/stdc++.h>
using namespace std;
char str[123456];
char it[123];
char day[13][5] = {"31", "28", "31", "30", "31", "30",
                   "31", "31", "30", "31", "30", "31"};
map<string, int> m;
map<string, int>::iterator ut;
int main() {
  scanf("%s", str);
  int len = strlen(str);
  m.clear();
  for (int i = 0; i < len - 3; i++) {
    if (str[i] == '-' && str[i + 3] == '-' && str[i + 4] == '2' &&
        str[i + 5] == '0' && str[i + 6] == '1') {
      int flag = 0;
      for (int j = 0; j < 10; j++) {
        it[j] = str[i + j - 2];
      }
      it[10] = '\0';
      if (it[9] < '3' || it[9] > '5') flag = 1;
      if (it[3] < '0' || it[3] > '9' || it[3] > '1') flag = 1;
      if (it[3] == '0') {
        if (it[4] < '0' || it[4] > '9' || it[4] == '0') flag = 1;
      }
      if (it[3] == '1') {
        if (it[4] < '0' || it[4] > '9' || it[4] > '2') flag = 1;
      }
      if (it[0] < '0' || it[0] > '9') flag = 1;
      if (it[0] == '0') {
        if (it[1] <= '0' || it[1] > '9') flag = 1;
      } else {
        if (it[1] < '0' || it[1] > '9') flag = 1;
      }
      int u = (it[3] - '0') * 10 + (it[4] - '0');
      char t[3];
      t[0] = it[0], t[1] = it[1];
      t[2] = '\0';
      if (strcmp(t, day[u - 1]) > 0) flag = 1;
      if (!flag) {
        string t = "";
        for (int j = 0; j < 10; j++) t += it[j];
        m[t]++;
      }
    }
  }
  string ans;
  int u = -1;
  for (ut = m.begin(); ut != m.end(); ut++) {
    if (ut->second > u) {
      u = ut->second;
      ans = ut->first;
    }
  }
  cout << ans << endl;
  return 0;
}
