#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int a[101], j = 0;
  cin >> s;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == '+') {
      continue;
    } else {
      a[j++] = s[i] - '0';
    }
  }
  sort(a, a + j);
  for (int k = 0; k <= j - 1; k++) {
    cout << a[k];
    if (k < j - 1) {
      cout << "+";
    }
  }
}
