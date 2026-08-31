#include <bits/stdc++.h>
using namespace std;
long long n, u, i;
int main() {
  cin >> n;
  for (i = 2; i * i <= n; i++) {
    if (n % i == 0 && u == 0) {
      u = i, n /= i;
    }
    if (n % i == 0 && n > i) {
      cout << 1 << endl << u * i << endl;
      return 0;
    }
  }
  if (u == 0) {
    puts("1\n0");
  } else {
    puts("2");
  }
}
