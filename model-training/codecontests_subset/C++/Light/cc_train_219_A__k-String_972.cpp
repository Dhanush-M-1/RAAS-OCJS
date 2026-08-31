#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, c[30];
  memset(c, 0, sizeof(c));
  string a;
  cin >> n >> a;
  for (i = 0; i < a.size(); i++) {
    c[a[i] - 'a']++;
  }
  int flag = 0;
  for (i = 0; i < 26; i++) {
    if (c[i] > 0) {
      if (c[i] % n != 0) {
        flag = 1;
        break;
      }
    }
  }
  if (flag == 1) {
    cout << -1 << endl;
    return 0;
  }
  int p = n;
  while (n--) {
    for (i = 0; i < 26; i++) {
      if (c[i] > 0) {
        int y = c[i] / p;
        while (y--) {
          char x = 'a' + i;
          cout << x;
        }
      }
    }
  }
  cout << endl;
}
