#include <bits/stdc++.h>
using namespace std;
string s;
map<string, int> m;
string ans;
int bns = 0;
int dd[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
bool check(string s) {
  string ss;
  ss = s.substr(5, 5);
  if (ss != "-2013" && ss != "-2014" && ss != "-2015") return false;
  if (s[2] != '-') return false;
  if (!isdigit(s[0]) || !isdigit(s[1]) || !isdigit(s[3]) || !isdigit(s[4]))
    return false;
  int m = (s[3] - '0') * 10 + (s[4] - '0');
  int d = (s[0] - '0') * 10 + (s[1] - '0');
  if (m > 12 || m == 0) return false;
  if (d > dd[m] || d == 0) return false;
  return true;
}
int main() {
  ios::sync_with_stdio(false);
  cin >> s;
  for (int i = 0; i < s.size() - 9; i++) {
    string ss = s.substr(i, 10);
    if (check(ss)) m[ss]++;
  }
  for (auto i : m) {
    if (i.second > bns) {
      ans = i.first;
      bns = i.second;
    }
  }
  cout << ans << endl;
  return 0;
}
