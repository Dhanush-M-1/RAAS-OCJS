#include <bits/stdc++.h>
using namespace std;
int ctoi(char c) { return int(c - '0'); }
bool goodDate(string s) {
  if (s[9] < '3' || s[9] > '5' || s[8] != '1' || s[7] != '0' || s[6] != '2' ||
      s[9] == '-')
    return false;
  if (s[5] != '-') return false;
  if (s[3] > '1' || s[3] == '-') return false;
  if (s[3] == '1') {
    if (s[4] > '2' || s[4] == '-') return false;
  } else {
    if (s[4] == '0' || s[4] == '-') return false;
  }
  if (s[2] != '-') return false;
  int men = ctoi(s[3]) * 10 + ctoi(s[4]);
  if (s[0] == '-' || s[1] == '-') return false;
  int dien = ctoi(s[0]) * 10 + ctoi(s[1]);
  if (dien == 0) return false;
  if (men == 1 || men == 3 || men == 5 || men == 7 || men == 8 || men == 10 ||
      men == 12) {
    if (dien > 31) return false;
  } else if (men == 4 || men == 6 || men == 9 || men == 11) {
    if (dien > 30) return false;
  } else {
    if (dien > 28) return false;
  }
  return true;
}
map<string, int> dq;
int main() {
  string s;
  cin >> s;
  for (int i = 0; i < s.size() - 9; i++) {
    string date = s.substr(i, 10);
    if (goodDate(date)) {
      dq[date]++;
    }
  }
  map<string, int>::iterator it;
  int best = 0;
  string bestDate = "";
  for (it = dq.begin(); it != dq.end(); it++) {
    if ((*it).second > best) {
      best = (*it).second;
      bestDate = (*it).first;
    }
  }
  cout << bestDate << endl;
}
