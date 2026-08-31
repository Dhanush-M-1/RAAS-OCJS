#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, count = 0;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i < n; i++) {
    if (s[i] == '8') {
      count++;
    }
  }
  if (n < 11 || count == 0) {
    cout << 0 << endl;
  } else {
    cout << min(n / 11, count) << endl;
  }
  return 0;
}
