#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int n = s.length();
  int n1 = 0, n2 = 0, n3 = 0, n4;
  for (int i = 0; i < n; i++) {
    if (s[i] == '1') n1 += 1;
    if (s[i] == '2') n2 += 1;
    if (s[i] == '3') n3 += 1;
    if (s[i] == '+') n4 += 1;
  }
  for (int j = 1; j <= n1; j++) {
    cout << 1;
    if (n4 > 0) {
      cout << '+';
      --n4;
    }
  }
  for (int j = 1; j <= n2; j++) {
    cout << 2;
    if (n4 > 0) {
      cout << '+';
      --n4;
    }
  }
  for (int j = 1; j <= n3; j++) {
    cout << 3;
    if (n4 > 0) {
      cout << '+';
      --n4;
    }
  }
}
