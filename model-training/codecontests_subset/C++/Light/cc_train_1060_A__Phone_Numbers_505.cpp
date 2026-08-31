#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  c = 0;
  string s;
  cin >> n >> s;
  for (int i = 0; i < n; i++) {
    if (s[i] == '8') {
      c += 1;
    }
  }
  cout << min(n / 11, c);
}
