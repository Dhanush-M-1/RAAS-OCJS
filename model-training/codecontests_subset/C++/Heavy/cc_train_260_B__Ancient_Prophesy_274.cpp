#include <bits/stdc++.h>
using namespace std;
char s[100001];
int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int validate(char* date) {
  if (date[2] != '-' || date[5] != '-') return 0;
  int dashes = 0;
  for (int i = 0; i < 10; i++) dashes += date[i] == '-';
  if (dashes != 2) return 0;
  int day = (date[0] - '0') * 10 + date[1] - '0';
  int month = (date[3] - '0') * 10 + date[4] - '0';
  int year = (date[6] - '0') * 1000 + (date[7] - '0') * 100 +
             (date[8] - '0') * 10 + (date[9] - '0');
  if (year < 2013 || year > 2015) return 0;
  if (month < 1 || month > 12) return 0;
  if (day < 1 || day > days[month]) return 0;
  return 1;
}
int main(void) {
  cin >> s;
  int len = strlen(s);
  map<string, int> counter;
  for (int i = 2, n = len - 7; i < n; i++) {
    if (s[i] == '-') {
      if (validate(s + i - 2)) {
        string date(s + i - 2, 10);
        counter[date]++;
      }
    }
  }
  map<string, int>::iterator ita, itb;
  ita = counter.begin();
  itb = counter.end();
  string answ;
  int maxi = 0;
  for (; ita != itb; ita++) {
    if (ita->second > maxi) {
      maxi = ita->second;
      answ = ita->first;
    }
  }
  cout << answ << endl;
  return 0;
}
