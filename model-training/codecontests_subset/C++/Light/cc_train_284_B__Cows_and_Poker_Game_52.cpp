#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a = 0, i = 0;
  cin >> n;
  for (int j = 0; j < n; j++) {
    char c;
    cin >> c;
    if (c == 'A')
      a++;
    else if (c == 'I')
      i++;
  }
  if (i == 1)
    cout << 1;
  else if (i > 0)
    cout << 0;
  else if (i == 0)
    cout << a;
  return 0;
}
