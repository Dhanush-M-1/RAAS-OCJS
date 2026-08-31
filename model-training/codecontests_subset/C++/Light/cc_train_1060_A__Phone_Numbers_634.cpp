#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c8 = 0;
  string s;
  cin >> n;
  cin >> s;
  for (int i = 0; i < n; i++) {
    if (s[i] == '8') {
      c8++;
    }
  }
  int a = n / 11;
  cout << min(a, c8);
}
