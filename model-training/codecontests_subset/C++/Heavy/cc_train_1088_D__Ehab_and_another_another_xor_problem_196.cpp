#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  auto ask = [](long long c, long long d) {
    cout << "? " << c << " " << d << endl;
    long long x;
    cin >> x;
    return x;
  };
  long long ans1 = 0, ans2 = 0;
  long long big = ask(0, 0);
  for (long long i = 29; i >= 0; i--) {
    long long z1 = ask(ans1 ^ (1LL << i), ans2);
    long long z2 = ask(ans1, ans2 ^ (1LL << i));
    if (z1 == z2) {
      if (big == 1) {
        ans1 ^= (1LL << i);
      } else {
        ans2 ^= (1LL << i);
      }
      big = z1;
    } else {
      if (z2 == 1) {
        ans1 ^= (1LL << i);
        ans2 ^= (1LL << i);
      }
    }
  }
  cout << "! " << ans1 << " " << ans2 << '\n';
  return 0;
}
