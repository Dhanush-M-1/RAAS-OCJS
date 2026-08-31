#include <bits/stdc++.h>
using namespace std;
int mes[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
map<string, int> M;
void Valid(string s) {
  int ct = 0;
  for (int i = 0; i < s.size(); i++)
    if (s[i] == '-') s[i] = ' ', ct++;
  if (ct != 2) return;
  if (s[2] != ' ' || s[5] != ' ') return;
  istringstream in(s);
  int d, m, a;
  in >> d >> m >> a;
  if (m <= 0 || m > 12) return;
  if (a < 2013 || a > 2015) return;
  if (d <= 0 || d > mes[m - 1]) return;
  s[2] = s[5] = '-';
  M[s]++;
}
int main() {
  string s;
  while (cin >> s) {
    for (int i = 0; i < s.size(); i++)
      if (i + 9 < s.size()) Valid(s.substr(i, 10));
    int maxi = 0;
    string ans = "";
    map<string, int>::iterator it;
    for (it = M.begin(); it != M.end(); ++it) {
      if (maxi < it->second) maxi = it->second, ans = it->first;
    }
    cout << ans << endl;
  }
}
