#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  string s;
  cin >> s;
  int a[4] = {0};
  for (int i = 0; i < s.length(); i++) {
    if (s[i] == '1')
      a[1]++;
    else if (s[i] == '2')
      a[2]++;
    else if (s[i] == '3')
      a[3]++;
  }
  int f = 0;
  for (int i = 1; i <= 3; i++) {
    if (a[i]) {
      for (int j = 1; j <= a[i]; j++) {
        if (f == 0 && j == 1) {
          cout << i;
          f = 1;
        } else
          cout << "+" << i;
      }
    }
  }
  return 0;
}
