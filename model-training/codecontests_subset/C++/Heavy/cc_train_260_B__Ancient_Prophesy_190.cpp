#include <bits/stdc++.h>
using namespace std;
long long int checkyear(char ch1, char ch2, char ch3, char ch4) {
  if (ch1 == '2' && ch2 == '0' && ch3 == '1' &&
      (ch4 == '3' || ch4 == '4' || ch4 == '5'))
    return 1;
  else
    return 0;
}
long long int checkmonth(char ch1, char ch2) {
  if (ch1 == '0' && ch2 == '2')
    return 1;
  else if (ch1 == '0' &&
           (ch2 == '1' || ch2 == '3' || ch2 == '5' || ch2 == '7' || ch2 == '8'))
    return 3;
  else if ((ch1 == '1') && (ch2 == '0' || ch2 == '2'))
    return 3;
  else if ((ch1 == '0') && (ch2 == '4' || ch2 == '6' || ch2 == '9'))
    return 2;
  else if (ch1 == '1' && ch2 == '1')
    return 2;
  else
    return 0;
}
long long int checkday(char ch1, char ch2, long long int month) {
  if (month == 1) {
    if ((ch1 == '0') &&
        (ch2 == '1' || ch2 == '2' || ch2 == '3' || ch2 == '4' || ch2 == '5' ||
         ch2 == '6' || ch2 == '7' || ch2 == '8' || ch2 == '9'))
      return 1;
    else if ((ch1 == '1') &&
             (ch2 == '0' || ch2 == '1' || ch2 == '2' || ch2 == '3' ||
              ch2 == '4' || ch2 == '5' || ch2 == '6' || ch2 == '7' ||
              ch2 == '8' || ch2 == '9'))
      return 1;
    else if ((ch1 == '2') && (ch2 == '0' || ch2 == '1' || ch2 == '2' ||
                              ch2 == '3' || ch2 == '4' || ch2 == '5' ||
                              ch2 == '6' || ch2 == '7' || ch2 == '8'))
      return 1;
    else
      return 0;
  } else if (month == 2) {
    if ((ch1 == '0') &&
        (ch2 == '1' || ch2 == '2' || ch2 == '3' || ch2 == '4' || ch2 == '5' ||
         ch2 == '6' || ch2 == '7' || ch2 == '8' || ch2 == '9')) {
      return 1;
    } else if ((ch1 == '1') &&
               (ch2 == '0' || ch2 == '1' || ch2 == '2' || ch2 == '3' ||
                ch2 == '4' || ch2 == '5' || ch2 == '6' || ch2 == '7' ||
                ch2 == '8' || ch2 == '9')) {
      return 1;
    } else if ((ch1 == '2') &&
               (ch2 == '0' || ch2 == '1' || ch2 == '2' || ch2 == '3' ||
                ch2 == '4' || ch2 == '5' || ch2 == '6' || ch2 == '7' ||
                ch2 == '8' || ch2 == '9')) {
      return 1;
    } else if ((ch1 == '3') && (ch2 == '0')) {
      return 1;
    } else
      return 0;
  } else if (month == 3) {
    if ((ch1 == '0') &&
        (ch2 == '1' || ch2 == '2' || ch2 == '3' || ch2 == '4' || ch2 == '5' ||
         ch2 == '6' || ch2 == '7' || ch2 == '8' || ch2 == '9')) {
      return 1;
    } else if ((ch1 == '1') &&
               (ch2 == '0' || ch2 == '1' || ch2 == '2' || ch2 == '3' ||
                ch2 == '4' || ch2 == '5' || ch2 == '6' || ch2 == '7' ||
                ch2 == '8' || ch2 == '9')) {
      return 1;
    } else if ((ch1 == '2') &&
               (ch2 == '0' || ch2 == '1' || ch2 == '2' || ch2 == '3' ||
                ch2 == '4' || ch2 == '5' || ch2 == '6' || ch2 == '7' ||
                ch2 == '8' || ch2 == '9')) {
      return 1;
    } else if ((ch1 == '3') && (ch2 == '0' || ch2 == '1')) {
      return 1;
    } else
      return 0;
  }
}
int main() {
  char a[100003], b[1000];
  string s;
  scanf("%s", a);
  map<string, long long int> m;
  map<string, long long int>::iterator it, pos;
  long long int len, i = 0, c, d, j = 0, year, month, day;
  len = strlen(a);
  for (i = 0; i <= (len - 10); i++) {
    j = 0;
    year = checkyear(a[i + 6], a[i + 7], a[i + 8], a[i + 9]);
    if (year) {
      month = checkmonth(a[i + 3], a[i + 4]);
      if (month) {
        day = checkday(a[i], a[i + 1], month);
        if (day && a[i + 2] == '-' && a[i + 5] == '-') {
          b[0] = a[i];
          b[1] = a[i + 1];
          b[2] = a[i + 2];
          b[3] = a[i + 3];
          b[4] = a[i + 4];
          b[5] = a[i + 5];
          b[6] = a[i + 6];
          b[7] = a[i + 7];
          b[8] = a[i + 8];
          b[9] = a[i + 9];
          b[10] = '\0';
          s = b;
          m[s]++;
        }
      }
    }
  }
  long long int max = 0;
  it = m.begin();
  for (; it != m.end(); it++) {
    if ((it->second) > max) {
      max = it->second;
      pos = it;
    }
  }
  cout << pos->first;
  return 0;
}
