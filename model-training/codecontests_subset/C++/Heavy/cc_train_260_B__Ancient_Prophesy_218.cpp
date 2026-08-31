#include <bits/stdc++.h>
const int mod = ((1E9) + 7);
const int intmax = ((1E9) + 7);
using namespace std;
string s[1120];
int lps[15];
int count_[1120];
void cal_lcp(string &p) {
  int j = -1;
  int i = 0;
  lps[0] = -1;
  while (i < p.size()) {
    while (j >= 0 && p[i] != p[j]) j = lps[j];
    i++;
    j++;
    lps[i] = j;
  }
}
void kmp(string &t, string &p, int x) {
  int i = 0, j = 0;
  while (i < t.size()) {
    while (j >= 0 && t[i] != p[j]) j = lps[j];
    i++;
    j++;
    if (j == p.size()) count_[x]++;
  }
}
string to_string_(int a) {
  stringstream ss;
  ss << a;
  string t;
  ss >> t;
  return t;
}
int main() {
  ios::sync_with_stdio(0);
  int test, a, b, c;
  int n, m;
  int max_ = 0, pos = -1;
  string text;
  cin >> text;
  int x = 0;
  for (int i = 1; i <= 31; i++)
    for (int j = 1; j <= 12; j++)
      for (int k = 2013; k <= 2015; k++) {
        if (j == 2 && i > 28) break;
        if (j <= 7 && j % 2 == 0 && i == 31) break;
        if (j > 7 && j % 2 != 0 && i == 31) break;
        if (i < 10) s[x] += '0';
        s[x] += to_string_(i);
        s[x] += '-';
        if (j < 10) s[x] += '0';
        s[x] += to_string_(j);
        s[x] += '-';
        s[x] += to_string_(k);
        x++;
      }
  for (int i = 0; i < x; i++) {
    cal_lcp(s[i]);
    kmp(text, s[i], i);
    if (count_[i] > max_) {
      pos = i;
      max_ = count_[i];
    }
  }
  cout << s[pos];
  return 0;
}
