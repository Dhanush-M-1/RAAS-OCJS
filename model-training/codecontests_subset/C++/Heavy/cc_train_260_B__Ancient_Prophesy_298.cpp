#include <bits/stdc++.h>
using namespace std;
long long gcd(long long x, long long y) { return y == 0 ? x : gcd(y, x % y); }
int toInt(char xx) { return xx - '0'; }
char toChar(int xx) { return xx + '0'; }
bool isDigit(char xx) { return ('0' <= xx && xx <= '9'); }
bool isCharacter(char xx) {
  return (('a' <= xx && xx <= 'z') || ('A' <= xx && xx <= 'Z'));
}
void swapInt(int &x, int &y) {
  x = x ^ y;
  y = x ^ y;
  x = x ^ y;
}
inline void clear_buffer() {
  string tmp;
  getline(cin, tmp);
}
struct Date {
  int d, m, y;
  Date() { d = m = y = 0; }
  bool operator<(const Date &other) const {
    if (y != other.y) return y < other.y;
    if (d != other.d) return d < other.d;
    if (m != other.m) return m < other.m;
    return false;
  }
  void display() {
    if (d >= 10) {
      printf("%d-", d);
    } else {
      printf("0");
      printf("%d-", d);
    }
    if (m >= 10) {
      printf("%d-", m);
    } else {
      printf("0");
      printf("%d-", m);
    }
    printf("%d\n", y);
  }
};
const int dx[4] = {-1, 1, 0, 0};
const int dy[4] = {0, 0, -1, 1};
const int Mod = 10;
const int maxn = (1e6) + 10;
bool exitInput = false;
const int days_in_month[15] = {0,  31, 28, 31, 30, 31, 30,
                               31, 31, 30, 31, 30, 31};
const char gach = '-';
int dd, mm, yy;
map<Date, int> mp;
string s;
bool isCorrectFormat(int i) {
  if (s[i + 2] != gach || s[i + 5] != gach) return false;
  for (int j = 0; j < 9; ++j) {
    if (j != 2 && j != 5 && s[i + j] == gach) return false;
  }
  return true;
}
bool isValidFormat(int i) {
  int d, m, y;
  d = toInt(s[i]) * 10 + toInt(s[i + 1]);
  m = toInt(s[i + 3]) * 10 + toInt(s[i + 4]);
  y = toInt(s[i + 6]) * 1000 + toInt(s[i + 7]) * 100 + toInt(s[i + 8]) * 10 +
      toInt(s[i + 9]);
  dd = d;
  mm = m;
  yy = y;
  if (y < 2013 || y > 2015) {
    return false;
  }
  if (m < 1 || m > 12) {
    return false;
  }
  if (d < 1 || d > days_in_month[m]) return false;
  return true;
}
void read() { cin >> s; }
void init() {}
void solve() {
  int len = s.size();
  for (int i = 0; i <= len - 8; ++i) {
    if (isCorrectFormat(i)) {
      if (isValidFormat(i)) {
        Date x;
        x.d = dd;
        x.m = mm;
        x.y = yy;
        mp[x]++;
      }
    }
  }
  int tmp_cnt = 0;
  map<Date, int>::iterator it;
  for (it = mp.begin(); it != mp.end(); ++it) {
    Date x = (*it).first;
    tmp_cnt = max(tmp_cnt, (*it).second);
  }
  for (it = mp.begin(); it != mp.end(); ++it) {
    if (tmp_cnt == (*it).second) {
      Date x = (*it).first;
      x.display();
      return;
    }
  }
}
int main() {
  int ntest = 1;
  int itest = 1;
  for (itest = 1; itest <= ntest; ++itest) {
    read();
    if (exitInput) {
      break;
    }
    init();
    solve();
  }
  return 0;
}
