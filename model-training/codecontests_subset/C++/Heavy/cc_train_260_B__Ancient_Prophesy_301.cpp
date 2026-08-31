#include <bits/stdc++.h>
using namespace std;
int main() {
  char a[1000000];
  cin >> a;
  int l = strlen(a);
  int i, j;
  int month;
  int year;
  int date;
  int found[10000][4] = {0};
  int founi = 0;
  int flag;
  int ac[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  for (i = 2; i < l - 7; i++) {
    if (a[i - 2] != '-' && a[i - 1] != '-' && a[i + 0] == '-' &&
        a[i + 1] != '-' && a[i + 2] != '-' && a[i + 3] == '-' &&
        a[i + 4] != '-' && a[i + 5] != '-' && a[i + 6] != '-' &&
        a[i + 7] != '-') {
      month = (a[i + 1] - '0') * 10 + (a[i + 2] - '0');
      date = (a[i - 2] - '0') * 10 + (a[i - 1] - '0');
      year = (a[i + 4] - '0') * 1000 + (a[i + 5] - '0') * 100 +
             (a[i + 6] - '0') * 10 + (a[i + 7] - '0');
      if (month <= 12 && month >= 1 && year <= 2015 && year >= 2013) {
        if (date <= ac[month] && date >= 1) {
          flag = 0;
          for (j = 0; j < founi; j++) {
            if (found[j][0] == year && found[j][1] == month &&
                found[j][2] == date) {
              flag = 1;
              found[j][3]++;
            }
          }
          if (flag == 0) {
            found[founi][0] = year;
            found[founi][1] = month;
            found[founi][2] = date;
            found[founi][3] = 1;
            founi++;
          }
        }
      }
    }
  }
  int max = -1;
  max = -1;
  for (i = 0; i < founi; i++) {
    if (max < found[i][3]) {
      max = found[i][3];
      year = found[i][0];
      month = found[i][1];
      date = found[i][2];
    }
  }
  if (date < 10) {
    cout << "0" << date;
  } else {
    cout << date;
  }
  cout << '-';
  if (month < 10) {
    cout << "0" << month;
  } else {
    cout << month;
  }
  cout << "-";
  cout << year << endl;
  return 0;
}
