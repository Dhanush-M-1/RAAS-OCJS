#include <bits/stdc++.h>
using namespace std;
char s[100100];
int days[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int toInt(int i, int n) {
  int res = 0;
  for (int j = (0); j < ((n)); ++j) res = 10 * res + (s[i + j] - '0');
  return res;
}
bool good(int i) {
  if (s[i + 2] != '-' || s[i + 5] != '-') return false;
  for (int j = (0); j < ((10)); ++j)
    if (j != 2 && j != 5)
      if (s[i + j] == '-') return false;
  int d = toInt(i, 2), m = toInt(i + 3, 2), y = toInt(i + 6, 4);
  if (y < 2013 || y > 2015) return false;
  if (m < 1 || m > 12) return false;
  if (d < 1 || d > days[m - 1]) return false;
  return true;
}
int main() {
  scanf("%s", s);
  int n = strlen(s);
  map<string, int> cnt;
  for (int i = (0); i < ((n - 9)); ++i)
    if (good(i)) {
      string ss(s + i, s + i + 10);
      ++cnt[ss];
    }
  int mx = 0;
  for (map<string, int>::const_iterator i = cnt.begin(); i != cnt.end(); ++i)
    mx = max(mx, i->second);
  for (map<string, int>::const_iterator i = cnt.begin(); i != cnt.end(); ++i)
    if (i->second == mx) {
      cout << i->first << endl;
      return 0;
    }
  return 0;
}
