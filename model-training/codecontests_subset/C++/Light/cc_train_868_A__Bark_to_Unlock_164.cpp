#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string str;
  cin >> str;
  scanf("%d", &n);
  string str1[n + 1];
  for (int i = 1; i <= n; i++) cin >> str1[i];
  int c = 0;
  for (int i = 1; i <= n; i++) {
    if (str1[i] == str) {
      c = 1;
      break;
    }
  }
  if (c == 0) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if ((str1[i][str1[i].size() - 1] == str[0]) && (str1[j][0] == str[1])) {
          c = 1;
          break;
        }
      }
    }
  }
  if (c == 1)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
