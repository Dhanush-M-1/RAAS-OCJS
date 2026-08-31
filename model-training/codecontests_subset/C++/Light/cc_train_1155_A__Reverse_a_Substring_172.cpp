#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i < n - 1; i++) {
    if (int(s[i] > s[i + 1])) {
      cout << "YES" << endl << i + 1 << ' ' << i + 2;
      return 0;
    }
  }
  cout << "NO";
  return 0;
}
