#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int cnt = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'I') cnt++;
  }
  if (cnt == 0) {
    for (int i = 0; i < n; i++)
      if (s[i] == 'A') cnt++;
    cout << cnt;
  } else if (cnt == 1) {
    cout << 1;
  } else {
    cout << 0;
  }
}
