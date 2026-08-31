#include <bits/stdc++.h>
using namespace std;
int main() {
  int l;
  int cnt = 0;
  cin >> l;
  char num[11];
  for (int i = 0; i < 11; i++) {
    num[i] = 0;
  }
  char s[l + 1];
  cin >> s;
  int ar[10] = {0};
  for (int i = 0; i < l; i++) {
    ar[s[i] - 48]++;
  }
  while (l > 0) {
    if (ar[8] > 0) {
      ar[8]--;
      l--;
      if (l >= 10) {
        cnt++;
        l -= 10;
      }
    } else {
      break;
    }
  }
  cout << cnt;
  return 0;
}
