#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, ret = 0, count = 0;
  char s[10000];
  cin >> n;
  getchar();
  scanf("%s", s);
  for (i = 0; i < n; i++) {
    if (s[i] == '8') {
      ret = 1;
      count++;
    }
  }
  if (ret == 0 || n < 11)
    cout << "0";
  else {
    for (i = count; i >= 1; i--) {
      if ((n - i) >= 10 * i) {
        cout << i;
        break;
      }
    }
  }
  return 0;
}
