#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int i, j;
  int n = s.size();
  for (i = 0; i < n; i = i + 2) {
    for (j = 0; j < n - i - 2; j = j + 2) {
      if (s[j] > s[j + 2]) {
        swap(s[j], s[j + 2]);
      }
    }
  }
  cout << s;
  return 0;
}
