#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ara[100000], temp[100000], tm = 0, ans[5], i, j, c = 0;
  stack<int> a;
  tm = c;
  cin >> n;
  for (i = 0; i < 3; i++) {
    for (j = 0; j < n - i; j++) {
      cin >> ara[j];
    }
    sort(ara, ara + (n - i));
    if (i != 0) {
      for (j = 0; j < n - i; j++) {
        if (temp[j] != ara[j]) {
          ans[c] = temp[j];
          c++;
          break;
        }
      }
      if (c == tm) {
        if (i == 1) {
          ans[c] = temp[n - 1];
          c++;
          tm = c;
        } else {
          ans[c] = temp[n - 2];
          c++;
          tm = c;
        }
      } else {
        tm = c;
      }
    }
    for (j = 0; j < n - i; j++) {
      temp[j] = ara[j];
    }
  }
  for (i = 0; i < 2; i++) {
    cout << ans[i] << endl;
  }
}
