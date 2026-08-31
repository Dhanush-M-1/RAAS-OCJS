#include <bits/stdc++.h>
using namespace std;
long a, b, c, n, res = 0;
int main() {
  setlocale(LC_ALL, "");
  cin >> n >> a >> b >> c;
  n *= 2;
  for (long i = 0; i <= a; i++) {
    for (long j = 0; j <= b && i + j * 2 <= n; j++) {
      if ((n - i - j * 2) % 4 == 0 && (n - i - j * 2) / 4 <= c) {
        res++;
      }
    }
  }
  printf("%d", res);
}
