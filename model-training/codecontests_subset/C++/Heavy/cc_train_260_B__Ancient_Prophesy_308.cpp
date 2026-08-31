#include <bits/stdc++.h>
using namespace std;
int stoi(string &s) {
  int n = 0;
  for (int i = 0; i < s.size(); i++) {
    n *= 10;
    n += s[i] - 48;
  }
  return n;
}
string itos(int n) {
  string s;
  s.push_back(n / 10 + 48);
  s.push_back(n % 10 + 48);
  return s;
}
int date[32][13][3];
int main() {
  string s;
  cin >> s;
  int d, m, y;
  for (int i = 6; i < s.size() - 3; i++) {
    string yyyy = s.substr(i, 4);
    if (yyyy == "2013" || yyyy == "2014" || yyyy == "2015") {
      if (s[i - 1] != '-') continue;
      if (s[i - 2] == '-') continue;
      if (s[i - 3] == '-') continue;
      if (s[i - 4] != '-') continue;
      if (s[i - 5] == '-') continue;
      if (s[i - 6] == '-') continue;
      y = stoi(yyyy);
      string dd = s.substr(i - 6, 2);
      string mm = s.substr(i - 3, 2);
      d = stoi(dd);
      m = stoi(mm);
      switch (m) {
        case 1:
          if (d > 31) d = -1;
          break;
        case 2:
          if (d > 28) d = -1;
          break;
        case 3:
          if (d > 31) d = -1;
          break;
        case 4:
          if (d > 30) d = -1;
          break;
        case 5:
          if (d > 31) d = -1;
          break;
        case 6:
          if (d > 30) d = -1;
          break;
        case 7:
          if (d > 31) d = -1;
          break;
        case 8:
          if (d > 31) d = -1;
          break;
        case 9:
          if (d > 30) d = -1;
          break;
        case 10:
          if (d > 31) d = -1;
          break;
        case 11:
          if (d > 30) d = -1;
          break;
        case 12:
          if (d > 31) d = -1;
          break;
        default:
          d = -1;
          break;
      }
      if (d == -1 || d == 0) continue;
      date[d][m][y - 2013]++;
    }
  }
  int t = 0;
  for (int i = 0; i < 32; i++)
    for (int j = 0; j < 13; j++)
      for (int k = 0; k < 3; k++)
        if (t < date[i][j][k]) {
          d = i;
          m = j;
          y = k + 2013;
          t = date[i][j][k];
        }
  string dd = itos(d);
  string mm = itos(m);
  cout << dd << "-" << mm << "-" << y;
  return 0;
}
