#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  for (int k = 0; k < n - 1; k++) {
    if (s[k] > s[k + 1]) {
      cout << "YES" << endl;
      cout << k + 1 << " " << k + 2;
      return 0;
    }
  }
  cout << "NO";
  return 0;
}
