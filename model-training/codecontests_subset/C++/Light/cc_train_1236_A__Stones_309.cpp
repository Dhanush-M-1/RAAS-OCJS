#include <bits/stdc++.h>
using namespace std;
const int N = 200000 + 10;
const long long MOD = 1000000000 + 7;
const long long INF = 1000000000000000000;
void Main() {
  int a, b, c;
  int ans = 0;
  cin >> a >> b >> c;
  for (int i = 0; i <= 100; i++) {
    for (int j = 0; j <= 100; j++) {
      int Nb = b - 2 * i - j;
      int Na = a - i;
      int Nc = c - 2 * j;
      if (Nb >= 0 && Na >= 0 && Nc >= 0) ans = max(ans, 3 * i + 3 * j);
    }
  }
  cout << ans << '\n';
  return;
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    Main();
  }
}
