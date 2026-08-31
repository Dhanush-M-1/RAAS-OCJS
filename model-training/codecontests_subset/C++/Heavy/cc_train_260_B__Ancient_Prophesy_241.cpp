#include <bits/stdc++.h>
using namespace std;
long long get() {
  char c = getchar();
  long long x = 0LL;
  while (c < '0' || c > '9') c = getchar();
  while (c >= '0' && c <= '9') {
    x *= 10LL;
    x += (c - '0');
    c = getchar();
  }
  return x;
}
string s;
int dm[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
map<string, int> mp;
int main() {
  ios::sync_with_stdio(0);
  cin >> s;
  for (int i = 0; i < s.size() - 9; i++) {
    string t = s.substr(i, 10);
    string d = t.substr(0, 2), m = t.substr(3, 2), y = t.substr(6, 4);
    if (t[2] != '-' || t[5] != '-') continue;
    bool f = true;
    for (int j = 0; j < 2; j++)
      if (!isdigit(d[j]) || !isdigit(m[j])) f = false;
    for (int j = 0; j < 4; j++)
      if (!isdigit(y[j])) f = false;
    if (!f) continue;
    int dd, mm, yy;
    dd = mm = yy = 0;
    for (int j = 0; j < 2; j++) {
      dd = dd * 10 + (d[j] - '0');
      mm = mm * 10 + (m[j] - '0');
    }
    for (int j = 0; j < 4; j++) yy = yy * 10 + (y[j] - '0');
    if (dd < 1 || dd > dm[mm]) continue;
    if (mm < 1 || mm > 12) continue;
    if (yy < 2013 || yy > 2015) continue;
    mp[t]++;
  }
  int mx = 0;
  for (__typeof(mp.begin()) it = (mp.begin()); it != (mp).end(); it++) {
    if (it->second > mx) mx = it->second;
  }
  for (__typeof(mp.begin()) it = (mp.begin()); it != (mp).end(); it++) {
    if (it->second == mx) {
      cout << it->first;
      return 0;
    }
  }
  return 0;
}
