#include <bits/stdc++.h>
using namespace std;
int solve(int n, int k) {
  int total_candles = n;
  int candles = n;
  while (candles >= k) {
    total_candles += candles / k;
    candles = candles / k + candles % k;
  }
  return total_candles;
}
int main() {
  int a, b;
  cin >> a >> b;
  cout << solve(a, b);
  return 0;
}
