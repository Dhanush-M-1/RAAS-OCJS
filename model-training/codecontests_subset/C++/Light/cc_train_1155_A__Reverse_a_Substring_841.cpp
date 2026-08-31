#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  char sub[n];
  for (int i = 0; i < n; i++) {
    cin >> sub[i];
  }
  bool check = true;
  for (int i = 0; i < n - 1; i++) {
    if (sub[i] > sub[i + 1]) {
      cout << "YES" << endl;
      cout << i + 1 << " " << i + 1 + 1 << endl;
      check = false;
      break;
    }
  }
  if (check == true) {
    cout << "NO" << endl;
  }
  return 0;
}
