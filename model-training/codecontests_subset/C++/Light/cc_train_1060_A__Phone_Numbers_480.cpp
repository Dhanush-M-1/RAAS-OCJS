#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  string s;
  cin >> s;
  int c = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == '8') {
      c++;
    }
  }
  int ss = 0;
  for (int i = c; i > 0; i--) {
    if ((n >= (11 * i))) {
      ss = i;
      break;
    }
  }
  cout << ss << endl;
  return 0;
}
