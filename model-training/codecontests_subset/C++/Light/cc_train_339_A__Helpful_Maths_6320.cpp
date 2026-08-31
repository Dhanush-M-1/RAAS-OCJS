#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int a[5] = {0};
  for (int i = 0; i < s.length(); i += 2) a[s[i] - '0']++;
  int count = 0;
  for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= a[i]; j++) {
      cout << i;
      count++;
      if (count < s.length() / 2 + 1) cout << "+";
    }
  }
  return 0;
}
