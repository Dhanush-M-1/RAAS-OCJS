#include <bits/stdc++.h>
using namespace std;
int n;
char pwd[5];
char word[105][5];
int main() {
  while (cin >> pwd) {
    cin >> n;
    bool flag = false;
    for (int i = 0; i < n; i++) {
      cin >> word[i];
      if (word[i][0] == pwd[0] && word[i][1] == pwd[1]) flag = true;
    }
    if (flag) {
      cout << "YES\n";
      continue;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (word[i][1] == pwd[0] && word[j][0] == pwd[1]) {
          flag = true;
          break;
        }
      }
      if (flag) break;
    }
    if (flag)
      cout << "YES\n";
    else
      cout << "NO\n";
  }
}
