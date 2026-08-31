#include <bits/stdc++.h>
using namespace std;
const int INF = 2147483647;
int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int to_int(string s) {
  stringstream ss;
  if (s.find('-') != -1) return 0;
  ss << s;
  int r = 0;
  ss >> r;
  return r;
}
bool check(string s) {
  if (s.length() != 10 || s[2] != '-' || s[5] != '-') return false;
  int d = to_int(s.substr(0, 2));
  int m = to_int(s.substr(3, 2));
  int y = to_int(s.substr(6, 4));
  if (y < 2013 || y > 2015 || m < 1 || m > 12 || d < 1 || d > days[m - 1])
    return false;
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  string s;
  cin >> s;
  map<string, int> m;
  for (int i = 0; i < s.size() - 9; i++) {
    string sub = s.substr(i, 10);
    if (!check(sub)) continue;
    if (m.count(sub))
      m.find(sub)->second++;
    else
      m.insert(pair<string, int>(sub, 1));
  }
  pair<string, int> ans = *m.begin();
  for (map<string, int>::iterator it = m.begin(); it != m.end(); it++)
    if (it->second > ans.second) ans = *it;
  cout << ans.first << endl;
  return 0;
}
