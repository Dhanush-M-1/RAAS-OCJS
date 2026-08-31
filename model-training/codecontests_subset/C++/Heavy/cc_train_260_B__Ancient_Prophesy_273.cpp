#include <bits/stdc++.h>
using namespace std;
string s;
unordered_map<string, int> mp;
const int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
bool check(string s) {
  if (s[2] != '-' || s[5] != '-') return false;
  for (int i = 0; i < 10; ++i)
    if (i != 2 && i != 5 && !isdigit(s[i])) return false;
  int day, month, year;
  char c;
  stringstream ss(s);
  ss >> day >> c >> month >> c >> year;
  if (year < 2013 || year > 2015) return false;
  if (month < 1 || month > 13) return false;
  if (day < 1 || day > days[month]) return false;
  return true;
}
int main() {
  cin >> s;
  for (int i = 0; i <= s.size() - 10; ++i) {
    string t = s.substr(i, 10);
    if (!check(t)) continue;
    mp[t]++;
  }
  int mx = 0;
  string ans;
  for (auto &it : mp) {
    if (it.second > mx) {
      mx = it.second;
      ans = it.first;
    }
  }
  cout << ans << endl;
  return 0;
}
