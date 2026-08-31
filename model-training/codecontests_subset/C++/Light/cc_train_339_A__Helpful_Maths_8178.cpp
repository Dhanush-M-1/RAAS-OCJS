#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int a[51], i;
  cin >> s;
  int n = s.length();
  for (i = 0; i < n; i = i + 2) {
    a[i / 2] = s[i] - '0';
  }
  sort(a, a + i / 2);
  n = i / 2;
  cout << a[0];
  for (i = 1; i < n; i++) {
    cout << "+";
    cout << a[i];
  }
  return 0;
}
