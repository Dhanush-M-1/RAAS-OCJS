#include <bits/stdc++.h>
using namespace std;
string s;
int a[2000] = {};
string r[2000];
const int mon[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
void tr(int p) {
  int res = true;
  for (int i = 0; res && i < 10; i++)
    res = (((i == 2 || i == 5) && s[p + i] == '-') ||
           (i != 2 && i != 5 && s[p + i] != '-'));
  if (!res) return;
  int d = (s[p] - '0') * 10 + s[p + 1] - '0',
      m = (s[p + 3] - '0') * 10 + s[p + 4] - '0',
      y = (((s[p + 6] - '0') * 10 + s[p + 7] - '0') * 10 + s[p + 8] - '0') *
              10 +
          s[p + 9] - '0';
  if (y >= 2013 && y <= 2015 && m >= 1 && m <= 12 && d >= 1 &&
      d <= mon[m - 1]) {
    d += ((y - 2013) * 12 + m - 1) * 31;
    a[d]++;
    r[d] = "";
    for (int i = 0; i < 10; i++) r[d] += s[i + p];
  }
}
int main() {
  cin >> s;
  for (int i = 0; i <= s.size() - 10; i++) tr(i);
  int ans = 0;
  for (int i = 0; i < 1500; i++)
    if (a[i] > a[ans]) ans = i;
  cout << r[ans];
}
