#include <bits/stdc++.h>
using namespace std;
int d, m, y, res;
string line, cur, best;
map<string, int> s;
int main() {
  res = 0;
  getline(cin, line);
  for (int i = (0); i < (line.length() + 1); i++) {
    cur.clear();
    for (int j = (0); j < (10); j++) cur += line[i + j];
    if (!isdigit(cur[0]) || !isdigit(cur[1]) || !isdigit(cur[3]) ||
        !isdigit(cur[4]) || !isdigit(cur[6]) || !isdigit(cur[7]) ||
        !isdigit(cur[8]) || !isdigit(cur[9]) || isdigit(cur[2]) ||
        isdigit(cur[5]))
      continue;
    d = 10 * (cur[0] - '0') + (cur[1] - '0');
    m = 10 * (cur[3] - '0') + (cur[4] - '0');
    y = 1000 * (cur[6] - '0') + 100 * (cur[7] - '0') + 10 * (cur[8] - '0') +
        (cur[9] - '0');
    if (m < 1 || m > 12 || y < 2013 || y > 2015) continue;
    if (d < 1) continue;
    if (m < 8) {
      if (m % 2) {
        if (d > 31) continue;
      } else {
        if (d > 30 || (m == 2 && d > 28)) continue;
      }
    } else {
      if (m % 2) {
        if (d > 30) continue;
      } else {
        if (d > 31) continue;
      }
    }
    map<string, int>::iterator it = s.find(cur);
    if (it == s.end()) {
      s.insert(make_pair(cur, 1));
      if (!res) {
        res = 1;
        best = cur;
      }
    } else {
      ++it->second;
      if (it->second > res) {
        res = it->second;
        best = cur;
      }
    }
  }
  cout << best << endl;
  return 0;
}
