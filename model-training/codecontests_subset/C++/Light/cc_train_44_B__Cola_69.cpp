#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c;
  cin >> n >> a >> b >> c;
  n *= 10;
  int sum = 0;
  for (int i = 0; i <= min(a, n / 5); i++) {
    int t = n - i * 5;
    for (int j = 0; j <= min(b, t / 10); j++) {
      int p = t - j * 10;
      if (p % 20 == 0 && p / 20 <= c) sum++;
    }
  }
  cout << sum << endl;
  return 0;
}
