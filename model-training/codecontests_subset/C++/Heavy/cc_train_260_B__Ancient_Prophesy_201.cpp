#include <bits/stdc++.h>
using namespace std;
int month[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int ans[33][33][2222], n, k;
string t, res;
int dig(char c) { return (int)(c - '0'); }
void check() {
  if (t[2] != '-' || t[5] != '-') return;
  int cnt = 0;
  for (int i = 0; i < 10; i++)
    if (t[i] == '-') cnt++;
  if (cnt > 2) return;
  int d = dig(t[0]) * 10 + dig(t[1]);
  int m = dig(t[3]) * 10 + dig(t[4]);
  int y = dig(t[6]) * 1000 + dig(t[7]) * 100 + dig(t[8]) * 10 + dig(t[9]);
  if (m < 1 || m > 12) return;
  if (d < 1 || d > month[m]) return;
  if (y < 2013 || y > 2015) return;
  ans[d][m][y]++;
  if (ans[d][m][y] > k) {
    k = ans[d][m][y];
    res = t;
  }
}
int main() {
  string s;
  cin >> s;
  n = s.size();
  for (int i = 0; i < n; i++) {
    t = "00-00-0000";
    for (int j = i, at = 0; j < i + 10 && j < n; j++, at++) t[at] = s[j];
    check();
  }
  cout << res << endl;
  return 0;
}
