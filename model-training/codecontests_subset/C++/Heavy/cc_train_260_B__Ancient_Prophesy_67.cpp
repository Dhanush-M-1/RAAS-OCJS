#include <bits/stdc++.h>
using namespace std;
int days[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
bool check(string in) {
  if (in[2] != '-' || in[5] != '-') return false;
  int d = 0, m = 0, y = 0;
  for (int ctr1 = 0; ctr1 < 10; ctr1++) {
    if (ctr1 == 2) {
      d = y;
      y = 0;
      continue;
    }
    if (ctr1 == 5) {
      m = y;
      y = 0;
      continue;
    }
    if (!isdigit(in[ctr1])) return false;
    y = y * 10 + in[ctr1] - '0';
  }
  if (y < 2013 || y > 2015) return false;
  if (m <= 0 || m > 12) return false;
  if (d <= 0 || d > days[m - 1]) return false;
  return true;
}
int main() {
  string prop;
  cin >> prop;
  map<string, int> mp;
  for (int ctr1 = 0; ctr1 < prop.size() - 9; ctr1++) {
    string cur = prop.substr(ctr1, 10);
    if (check(cur)) {
      mp[cur]++;
    }
  }
  string rez;
  int ma = 0;
  for (auto it = mp.begin(); it != mp.end(); it++) {
    if (it->second > ma) {
      ma = it->second;
      rez = it->first;
    }
  }
  cout << rez;
  return 0;
}
