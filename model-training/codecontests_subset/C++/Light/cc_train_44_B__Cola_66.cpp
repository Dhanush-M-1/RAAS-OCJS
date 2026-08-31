#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, cnt = 0;
  cin >> n >> a >> b >> c;
  n *= 10;
  for (int i = 0; i <= a; i++) {
    for (int j = 0; j <= b; j++) {
      if (i * 5 + j * 10 <= n && (n - (i * 5 + j * 10)) % 20 == 0 &&
          (n - (i * 5 + j * 10)) / 20 <= c)
        cnt++;
    }
  }
  cout << cnt;
  return 0;
}
