#include <bits/stdc++.h>
using namespace std;
map<string, int> cnt;
string str;
int ar[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int main() {
  cin >> str;
  for (int i = 0; i < str.size() - 9; i++) {
    string s = str.substr(i, 10);
    if (s[0] == '-' || s[1] == '-' || s[2] != '-' || s[3] == '-' ||
        s[4] == '-' || s[5] != '-' || s[6] == '-' || s[7] == '-' ||
        s[8] == '-' || s[9] == '-')
      continue;
    int d, m, y;
    char c;
    istringstream(s) >> d >> c >> m >> c >> y;
    if (m < 1 || m > 12) continue;
    if (d < 1 || d > ar[m - 1]) continue;
    if (y < 2013 || y > 2015) continue;
    cnt[s]++;
  }
  string x;
  int mx = 0;
  for (map<string, int>::iterator it = cnt.begin(); it != cnt.end(); it++) {
    if (mx < it->second) {
      mx = it->second;
      x = it->first;
    }
  }
  cout << x << endl;
  return 0;
}
