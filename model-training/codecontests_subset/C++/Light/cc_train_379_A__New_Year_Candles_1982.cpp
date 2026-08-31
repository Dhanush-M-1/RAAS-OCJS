#include <bits/stdc++.h>
#pragma GCC optimize("Ofast,fast-math")
inline void setup() {
  std::ios_base::sync_with_stdio(false);
  std::cin.tie(NULL);
  std::cout.tie(NULL);
}
inline void solve();
int main(int argc, char* argv[]) {
  setup();
  long long t = 1;
  while (t--) solve();
  return 0;
}
using namespace std;
inline void solve() {
  long long a, b;
  cin >> a >> b;
  long long newCandles = a;
  long long burnedOut = 0;
  long long ans = 0;
  while (newCandles || burnedOut >= b) {
    ans += newCandles;
    burnedOut += newCandles;
    newCandles = (burnedOut / b);
    burnedOut -= (newCandles * b);
  }
  cout << ans + newCandles;
}
