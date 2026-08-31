#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int count = 0, c = 1;
  char t = s[0];
  for (int i = 0; i < n - 1; i++) {
    if (s[i] <= s[i + 1]) {
      t = s[i + 1];
      c = i + 2;
    }
    if (s[i + 1] < t) {
      cout << "YES"
           << "\n"
           << c << " " << i + 2;
      count++;
      break;
    }
  }
  if (count == 0) cout << "NO";
}
