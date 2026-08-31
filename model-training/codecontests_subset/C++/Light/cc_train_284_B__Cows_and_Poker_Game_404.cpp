#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a = 0, i = 0;
  cin >> n;
  while (n--) {
    char c;
    cin >> c;
    if (c == 'A')
      a++;
    else if (c == 'I')
      i++;
  }
  cout << (i == 0 ? a : (i == 1 ? 1 : 0));
  return 0;
}
