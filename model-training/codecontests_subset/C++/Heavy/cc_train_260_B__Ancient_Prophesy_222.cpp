#include <bits/stdc++.h>
using namespace std;
int toInt(string s) {
  int r = 0;
  istringstream sin(s);
  sin >> r;
  return r;
}
long long toInt64(string s) {
  long long r = 0;
  istringstream sin(s);
  sin >> r;
  return r;
}
double toDouble(string s) {
  double r = 0;
  istringstream sin(s);
  sin >> r;
  return r;
}
string toString(long long n) {
  string s, s1;
  while (n / 10 > 0) {
    s += (char)((n % 10) + 48);
    n /= 10;
  }
  s += (char)((n % 10) + 48);
  n /= 10;
  s1 = s;
  for (long long i = 0; i < s.length(); i++) s1[(s.length() - 1) - i] = s[i];
  return s1;
}
bool isUpperCase(char c) { return c >= 'A' && c <= 'Z'; }
bool isLowerCase(char c) { return c >= 'a' && c <= 'z'; }
bool isLetter(char c) { return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z'; }
bool isDigit(char c) { return c >= '0' && c <= '9'; }
char toLowerCase(char c) { return (isUpperCase(c)) ? (c + 32) : c; }
char toUpperCase(char c) { return (isLowerCase(c)) ? (c - 32) : c; }
long long Max[50][50][10], maxx = 0;
int months[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
long long A, B, C;
string s, s1;
void chemidunam() {
  if (s[0] == '-') return;
  if (s[1] == '-') return;
  if (s[2] != '-') return;
  if (s[3] == '-') return;
  if (s[4] == '-') return;
  if (s[5] != '-') return;
  if (s[6] != '2') return;
  if (s[7] != '0') return;
  if (s[8] != '1') return;
  if (s[9] != '3' && s[9] != '4' && s[9] != '5') return;
  int jday = (int)(s[0] - '0') * 10 + (s[1] - '0');
  int jmonth = (int)(s[3] - '0') * 10 + (s[4] - '0');
  if (jmonth < 1 || jmonth > 12) return;
  if (jday < 1 || jday > months[jmonth - 1]) return;
  int jyear = s[9] - '0';
  Max[jday][jmonth][jyear]++;
  if (Max[jday][jmonth][jyear] > maxx) {
    A = jday;
    B = jmonth;
    C = jyear;
    maxx = Max[jday][jmonth][jyear];
  };
}
int main() {
  cin >> s1;
  s = "dd-mm-yyyy";
  for (int i = 0; i + s.length() <= s1.size(); i++) {
    for (int j = 0; j < s.length(); j++) s[j] = s1[i + j];
    chemidunam();
  }
  if (A < 10) cout << "0";
  cout << A;
  cout << "-";
  if (B < 10) cout << "0";
  cout << B;
  cout << "-";
  cout << "201" << C << endl;
}
