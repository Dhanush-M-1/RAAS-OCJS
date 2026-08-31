#include <bits/stdc++.h>
using namespace std;
template <typename T>
void cmin(T& a, T b) {
  if (b < a) a = b;
}
template <typename T>
void cmax(T& a, T b) {
  if (a < b) a = b;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int a, b;
  while (cin >> a >> b) {
    int ans = a;
    int mod = 0;
    while (a >= b) {
      mod = a % b;
      a /= b;
      ans += a;
      a += mod;
    }
    cout << ans << endl;
  }
  return 0;
}
