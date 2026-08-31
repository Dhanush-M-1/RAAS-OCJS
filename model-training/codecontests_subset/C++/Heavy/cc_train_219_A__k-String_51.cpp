#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, count = 0, q = 0, flag = 0;
  char y;
  cin >> k;
  string str;
  cin >> str;
  int length = str.size();
  char dubli[length];
  for (int i = 0; i < length; i++) {
    dubli[i] = '#';
  }
  if (k == 1) {
    cout << str;
    flag = 1;
  } else {
    if (length % k == 0) {
      int part = length / k;
      for (int i = 0; str[i]; i++) {
        count = 1;
        for (int j = i + 1; str[j]; j++) {
          if (str[i] == str[j] && str[i] != '*' && str[i] != '#') {
            count = count + 1;
            y = str[j];
            str[j] = '*';
          }
        }
        if (count % k == 0) {
          int p = count / k;
          int temp = q;
          for (int c = 0; c < k; c++) {
            for (int d = 0; d < p; d++) {
              dubli[temp + d] = y;
            }
            temp = temp + part;
          }
          q = q + p;
        } else if (count % k != 0 && str[i] != '*' && str[i] != '#') {
          if (flag != 1) cout << "-1";
          flag = 1;
          break;
        }
      }
    } else {
      if (flag != 1) cout << "-1";
      flag = 1;
    }
  }
  if (flag != 1) {
    for (int i = 0; i < length; i++) {
      cout << dubli[i];
    }
  }
  return 0;
}
