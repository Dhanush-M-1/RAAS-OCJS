#include <bits/stdc++.h>
using namespace std;
int main() {
  int a = 0, b = 0, n, x;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x;
    if (x == 100)
      a++;
    else {
      b++;
    }
  }
  if (a % 2 != 0 || (b % 2 != 0 && a <= 1)) {
    printf("NO\n");
  } else {
    printf("YES\n");
  }
  return 0;
}
