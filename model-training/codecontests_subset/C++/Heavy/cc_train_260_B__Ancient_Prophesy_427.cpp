#include <bits/stdc++.h>
using namespace std;
int a[200000];
int day[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
vector<string> b;
int main() {
  string s, d;
  int i, j;
  cin >> s;
  int ma, k, da, m, y;
  for (i = 0; i < s.length(); i++) {
    if (s[i] == '-') a[i]++;
    if (i > 0) a[i] += a[i - 1];
  }
  for (i = 0; i < s.length() - 9; i++)
    if (s[i + 2] == '-' && s[i + 5] == '-' && a[i + 9] - a[i - 1] == 2) {
      da = (s[i] - 48) * 10 + s[i + 1] - 48;
      m = (s[i + 3] - 48) * 10 + s[i + 4] - 48;
      y = (s[i + 6] - 48) * 1000 + (s[i + 7] - 48) * 100 +
          (s[i + 8] - 48) * 10 + (s[i + 9] - 48);
      if (1 <= m && m <= 12 && 1 <= da && da <= day[m] && 2013 <= y &&
          y <= 2015) {
        for (d = "", j = 0; j <= 9; j++) d += s[i + j];
        b.push_back(d);
      }
    }
  sort(b.begin(), b.end());
  ma = 0, d = "", k = 0;
  for (i = 0; i < b.size(); i++) {
    if (i == 0 || b[i] == b[i - 1])
      k++;
    else
      k = 1;
    if (k > ma) ma = k, d = b[i];
  }
  cout << d;
  return 0;
}
