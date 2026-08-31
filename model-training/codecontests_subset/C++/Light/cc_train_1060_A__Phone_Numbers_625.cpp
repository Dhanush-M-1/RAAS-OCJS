#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, cnt = 0;
  string s;
  cin >> n;
  cin >> s;
  x = n / 11;
  for (int i = 0; i < n; i++) {
    if (s[i] == '8') {
      cnt++;
    }
    if (cnt == x) {
      break;
    }
  }
  cout << min(x, cnt);
}
