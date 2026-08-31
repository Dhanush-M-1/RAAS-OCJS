#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, ans;
  char t[11];
  cin >> s;
  int m[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  int len = 0, day = 0, mon = 0, year = 0, flag = 0, cnt, max = 0;
  len = s.length();
  for (year = 2013; year <= 2015; year++) {
    for (mon = 1; mon <= 12; mon++) {
      for (day = 1; day <= m[mon]; day++) {
        sprintf(t, "%02d-%02d-%04d", day, mon, year);
        cnt = 0;
        for (int i = 0; i <= len - 10; i++) {
          flag = 0;
          for (int j = 0; j < 10; j++) {
            if (t[j] != s[j + i]) {
              flag = 1;
              break;
            }
          }
          if (flag == 0) {
            cnt++;
          }
        }
        if (cnt > max) {
          max = cnt;
          ans = t;
        }
      }
    }
  }
  cout << ans;
  return 0;
}
