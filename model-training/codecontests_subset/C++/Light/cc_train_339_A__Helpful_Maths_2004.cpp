#include <bits/stdc++.h>
using namespace std;
int cnt[105], num[105];
int main() {
  int i;
  char s[105], a[105];
  cin >> s;
  int ln = strlen(s);
  for (i = 0; i < ln; i += 2) {
    int nm = s[i] - '0';
    num[nm]++;
  }
  int flg = 0;
  for (int i = 1; i <= num[1]; i++) {
    if (flg == 1) {
      cout << "+";
    }
    flg = 1;
    cout << 1;
  }
  for (int i = 1; i <= num[2]; i++) {
    if (flg == 1) {
      cout << "+";
    }
    flg = 1;
    cout << 2;
  }
  for (int i = 1; i <= num[3]; i++) {
    if (flg == 1) {
      cout << "+";
    }
    flg = 1;
    cout << 3;
  }
  return 0;
}
