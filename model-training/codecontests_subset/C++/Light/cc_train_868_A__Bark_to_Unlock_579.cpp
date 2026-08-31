#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string pass;
  cin >> pass;
  cin >> n;
  int i;
  int flag[2];
  flag[0] = 0;
  flag[1] = 0;
  string kak;
  for (i = 0; i < n; i++) {
    cin >> kak;
    if (kak[0] == pass[0] && kak[1] == pass[1]) {
      cout << "YES" << endl;
      return 0;
    }
    if (kak[0] == pass[1] && kak[1] == pass[0]) {
      cout << "YES" << endl;
      return 0;
    }
    if (kak[1] == pass[0]) {
      flag[0] = 1;
    }
    if (kak[0] == pass[1]) {
      flag[1] = 1;
    }
  }
  if (flag[0] == 1 && flag[1] == 1) {
    cout << "YES" << endl;
  } else
    cout << "NO" << endl;
}
