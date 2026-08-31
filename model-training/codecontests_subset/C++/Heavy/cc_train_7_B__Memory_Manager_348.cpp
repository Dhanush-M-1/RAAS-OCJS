#include <bits/stdc++.h>
using namespace std;
const int maxn = 110;
int n, m;
string s;
int a[maxn];
int main() {
  cin >> n >> m;
  int cnt = 0;
  while (n--) {
    cin >> s;
    if (s[0] == 'a') {
      int x;
      cin >> x;
      int num = 0;
      bool flag = false;
      for (int i = 1; i + x - 1 <= m; i++) {
        num = 0;
        for (int j = i; j <= i + x - 1; j++) {
          if (a[j] == 0) num++;
        }
        if (num == x) {
          cnt++;
          flag = true;
          for (int j = i; j <= i + x - 1; j++) a[j] = cnt;
          cout << cnt << endl;
          break;
        }
      }
      if (!flag) cout << "NULL" << endl;
    } else if (s[0] == 'e') {
      int x;
      cin >> x;
      if (x <= 0)
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      else {
        bool flag = false;
        for (int i = 1; i <= m; i++) {
          if (a[i] == x) {
            a[i] = 0;
            flag = true;
          }
        }
        if (!flag) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      }
    } else {
      int k = 1;
      for (int i = 1; i <= m; i++) {
        if (a[i]) {
          a[k++] = a[i];
        }
      }
      for (; k <= m; k++) a[k] = 0;
    }
  }
  return 0;
}
