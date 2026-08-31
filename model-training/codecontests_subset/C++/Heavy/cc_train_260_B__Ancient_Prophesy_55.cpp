#include <bits/stdc++.h>
using namespace std;
struct Date {
  int d, m, y;
};
bool operator<(Date a, Date b) {
  return make_pair(make_pair(a.d, a.m), a.y) <
         make_pair(make_pair(b.d, b.m), b.y);
}
int days[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
string s;
bool cor_date(int i) {
  for (int j = 0; j < 10; j++) {
    if ((j == 2) || (j == 5)) {
      if (s[i + j] != '-') return 0;
    } else {
      if (s[i + j] == '-') return 0;
    }
  }
  int y = (((s[i + 6] - '0') * 10 + (s[i + 7] - '0')) * 10 + (s[i + 8] - '0')) *
              10 +
          (s[i + 9] - '0');
  int m = (s[i + 3] - '0') * 10 + (s[i + 4] - '0');
  int d = (s[i + 0] - '0') * 10 + (s[i + 1] - '0');
  if ((y <= 2015) && (y >= 2013) && (m <= 12) && (m >= 1) && (d >= 1) &&
      (d <= days[m - 1])) {
    return 1;
  }
  return 0;
}
Date get_date(int i) {
  int y = (((s[i + 6] - '0') * 10 + (s[i + 7] - '0')) * 10 + (s[i + 8] - '0')) *
              10 +
          (s[i + 9] - '0');
  int m = (s[i + 3] - '0') * 10 + (s[i + 4] - '0');
  int d = (s[i + 0] - '0') * 10 + (s[i + 1] - '0');
  Date D;
  D.y = y;
  D.m = m;
  D.d = d;
  return D;
}
string Dat(Date d) {
  string s;
  s += d.d / 10 + '0';
  s += d.d % 10 + '0';
  s += '-';
  s += d.m / 10 + '0';
  s += d.m % 10 + '0';
  s += '-';
  s += d.y / 1000 + '0';
  d.y %= 1000;
  s += d.y / 100 + '0';
  d.y %= 100;
  s += d.y / 10 + '0';
  d.y %= 10;
  s += d.y + '0';
  return s;
}
map<Date, int> ma;
int main() {
  cin >> s;
  for (int i = 0; i <= (int)s.size() - 10; i++) {
    if (cor_date(i)) {
      ma[get_date(i)]++;
    }
  }
  int mx = 0;
  Date D;
  bool flag = 0;
  for (map<Date, int>::iterator it = ma.begin(); it != ma.end(); it++) {
    if (it->second > mx) {
      mx = it->second;
      D = it->first;
      flag = 0;
    } else {
      if (it->second == mx) {
        flag = 1;
      }
    }
  }
  cout << Dat(D) << endl;
  return 0;
}
