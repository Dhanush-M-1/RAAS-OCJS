#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, a = 0, b = 0;
  scanf("%d", &n);
  if (n == 1) {
    cout << "NO";
    return (0);
  }
  for (int i = 0; i < n; i++) {
    scanf("%d", &x);
    if (x == 100)
      a++;
    else
      b++;
  }
  if (a % 2)
    cout << "NO";
  else {
    if (!(b % 2))
      cout << "YES";
    else if (b % 2 && a >= 2)
      cout << "YES";
    else
      cout << "NO";
  }
  return 0;
}
