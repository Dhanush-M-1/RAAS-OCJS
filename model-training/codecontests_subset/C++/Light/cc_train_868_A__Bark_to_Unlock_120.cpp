#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, factor = 0;
  string pass, bark[100];
  cin >> pass;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> bark[i];
    if (bark[i] == pass) {
      cout << "YES" << endl;
      return 0;
    }
  }
  for (int i = 0; i < n; i++) {
    if (bark[i][1] == pass[0]) {
      factor = 1;
      break;
    }
  }
  if (!factor) {
    cout << "NO" << endl;
    return 0;
  }
  for (int i = 0; i < n; i++) {
    if (bark[i][0] == pass[1]) {
      cout << "YES" << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
  return 0;
}
