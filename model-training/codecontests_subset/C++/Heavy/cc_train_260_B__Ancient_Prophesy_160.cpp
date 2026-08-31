#include <bits/stdc++.h>
using namespace std;
long long power(long long b, long long e, long long m) {
  if (e == 0) return 1;
  if (e % 2)
    return b * power(b * b % m, (e - 1) / 2, m) % m;
  else
    return power(b * b % m, e / 2, m);
}
long long power(long long b, long long e) {
  if (e == 0) return 1;
  if (e % 2)
    return b * power(b * b, (e - 1) / 2);
  else
    return power(b * b, e / 2);
}
bool id(char c) { return (c >= 48 && c <= 57); }
bool check(string s) {
  bool t = true;
  if (s[2] != '-' || s[5] != '-') t = false;
  if (!t) return t;
  if (!id(s[0]) || !id(s[1]) || !id(s[3]) || !id(s[4]) || !id(s[6]) ||
      !id(s[7]) || !id(s[8]) || !id(s[9]))
    t = false;
  if (!t) return t;
  string dd, mm, yyyy;
  dd = s.substr(0, 2);
  mm = s.substr(3, 2);
  yyyy = s.substr(6, 4);
  int d = stoi(dd);
  int m = stoi(mm);
  int y = stoi(yyyy);
  if (d <= 0) return false;
  if (y < 2013 || y > 2015) t = false;
  if (!t) return t;
  if (m == 2 && d <= 28)
    return true;
  else if (m == 2)
    return false;
  if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
    if (d <= 31)
      return true;
    else
      return false;
  } else {
    if (d <= 30)
      return true;
    else
      return false;
  }
}
int main(int argc, char const *argv[]) {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  string s, k;
  cin >> s;
  long long l = s.length(), count;
  map<string, long long> m;
  for (auto i = 0; i <= l - 10; i++) {
    k = s.substr(i, 10);
    if (check(k)) m[k]++;
  }
  k = m.begin()->first;
  count = m.begin()->second;
  auto j = m.begin();
  j++;
  while (j != m.end()) {
    if (j->second > count) {
      count = j->second;
      k = j->first;
    }
    j++;
  }
  cout << k;
  return 0;
}
