#include <bits/stdc++.h>
using namespace std;
const int number = 1000000;
int isprime[number + 2] = {0};
long long expo(long long x, long long y, long long m) {
  long long p = 1;
  while (y > 0) {
    if (y % 2 == 1) p = p * x % m;
    x = x * x % m;
    y = y / 2;
  }
  return (p % m);
}
void sieve() {
  isprime[0] = isprime[1] = 1;
  for (long long i = 2; i < number + 2; i++) {
    if (isprime[i] == 0) {
      for (long long j = i * i; j < number + 2; j += i) isprime[j] = 1;
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long i, j, l, q, t, m, n, h;
  long long k, z, p1, h1, x, y;
  string st = "", st1 = "";
  std::cin >> q;
  for (l = 0; l < q; l++) {
    std::cin >> n;
    x = 0;
    int b[2][2];
    long long x1, x2, x3, x4, y1, y2, y3, y4;
    char a[n][n];
    for (i = 0; i < n; i++)
      for (j = 0; j < n; j++) std::cin >> a[i][j];
    x1 = 0;
    y1 = 1;
    x2 = 1;
    y2 = 0;
    x3 = n - 1;
    y3 = n - 2;
    x4 = n - 2;
    y4 = n - 1;
    if (a[x1][y1] != a[x2][y2] && a[x3][y3] != a[x4][y4]) {
      std::cout << 2 << std::endl;
      if (a[x1][y1] == '0')
        std::cout << x1 + 1 << " " << y1 + 1 << std::endl;
      else
        std::cout << x2 + 1 << " " << y2 + 1 << std::endl;
      if (a[x3][y3] == '1')
        std::cout << x3 + 1 << " " << y3 + 1 << std::endl;
      else
        std::cout << x4 + 1 << " " << y4 + 1 << std::endl;
    } else if (a[x1][y1] != a[x2][y2]) {
      std::cout << 1 << std::endl;
      if (a[x1][y1] == a[x3][y3])
        std::cout << x1 + 1 << " " << y1 + 1 << std::endl;
      else
        std::cout << x2 + 1 << " " << y2 + 1 << std::endl;
    } else if (a[x3][y3] != a[x4][y4]) {
      std::cout << 1 << std::endl;
      if (a[x1][y1] == a[x3][y3])
        std::cout << x3 + 1 << " " << y3 + 1 << std::endl;
      else
        std::cout << x4 + 1 << " " << y4 + 1 << std::endl;
    } else if (a[x1][y1] == a[x3][y3]) {
      std::cout << 2 << std::endl;
      std::cout << x1 + 1 << " " << y1 + 1 << std::endl;
      std::cout << x2 + 1 << " " << y2 + 1 << std::endl;
    } else
      std::cout << 0 << std::endl;
  }
  return 0;
}
