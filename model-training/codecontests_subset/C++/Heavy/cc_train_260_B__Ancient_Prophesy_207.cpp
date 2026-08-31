#include <bits/stdc++.h>
using namespace std;
map<string, int> date;
int month_len[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int main() {
  for (int y = 2013; y <= 2015; y++) {
    for (int m = 1; m <= 12; m++) {
      for (int d = 1; d <= month_len[m]; d++) {
        stringstream ss;
        ss << setfill('0') << setw(2) << d << '-';
        ss << setfill('0') << setw(2) << m << '-' << y;
        date[ss.str()] = 0;
      }
    }
  }
  string s;
  cin >> s;
  for (int i = 0; i <= s.length() - 10; i++)
    if (date.count(s.substr(i, 10))) date[s.substr(i, 10)]++;
  string ans;
  int max_cnt = -1;
  for (map<string, int>::iterator it = date.begin(); it != date.end(); it++)
    if (it->second > max_cnt) {
      ans = it->first;
      max_cnt = it->second;
    }
  cout << ans << endl;
  return 0;
}
