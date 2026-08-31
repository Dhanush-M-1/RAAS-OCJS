#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9 + 7;
string s;
map<string, int> cnt;
int days[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
string ans = "0";
void solve(string x) {
  if (x[2] != '-' or x[5] != '-') return;
  for (int i = 0; i < 10; i++) {
    if ((i == 2 or i == 5) and x[i] != '-') return;
    if (i == 2 or i == 5) continue;
    if (x[i] < '0' or x[i] > '9') return;
  }
  int day = (x[0] - '0') * 10 + x[1] - '0';
  int month = (x[3] - '0') * 10 + x[4] - '0';
  int year =
      (x[6] - '0') * 1000 + (x[7] - '0') * 100 + (x[8] - '0') * 10 + x[9] - '0';
  if (year < 2013 or year > 2015) return;
  if (month < 1 or month > 12) return;
  if (day < 1 or day > days[month]) return;
  if (cnt.find(x) == cnt.end())
    cnt[x] = 1;
  else
    cnt[x]++;
  if (cnt[x] > cnt[ans]) ans = x;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> s;
  cnt["0"] = -1;
  for (int i = 0; i + 9 < s.size(); i++) {
    solve(s.substr(i, 10));
  }
  cout << ans;
  return 0;
}
