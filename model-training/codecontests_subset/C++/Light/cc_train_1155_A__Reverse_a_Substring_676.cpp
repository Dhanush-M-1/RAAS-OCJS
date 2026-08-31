#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int a = 0, b = 0, flag = 0;
  if (n == 1) {
    cout << "NO" << endl;
  } else {
    for (int i = 0; i < n - 1; i++) {
      if (int(s[i + 1]) < int(s[i])) {
        flag = 1;
        a = i + 1;
        b = i + 2;
        break;
      }
    }
    if (flag == 0) {
      cout << "NO" << endl;
    } else {
      cout << "YES" << endl;
      cout << a << " " << b << endl;
    }
  }
  return 0;
}
