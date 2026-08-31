#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, n;
  bool possible;
  long long a1[100000];
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> n;
    possible = false;
    for (int j = 0; j < n; j++) {
      cin >> a1[j];
    }
    for (int j = 2; j < n; j++) {
      if (a1[j] >= a1[0] + a1[1]) {
        possible = true;
        cout << 1 << " " << 2 << " " << j + 1 << endl;
        break;
      }
    }
    if (possible == false) cout << -1 << endl;
  }
  return 0;
}
