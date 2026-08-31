#include <bits/stdc++.h>
using namespace std;
int n, a, b, x;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &x);
    if (x == 100)
      a++;
    else
      b++;
  }
  b %= 2;
  if (b == 1) a -= 2;
  if (a < 0) {
    puts("NO");
    return 0;
  }
  if (a % 2) {
    puts("NO");
    return 0;
  } else {
    puts("YES");
    return 0;
  }
}
