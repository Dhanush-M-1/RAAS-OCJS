#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  if (!a)
    return b;
  else
    return gcd(b % a, a);
}
void solve() {
  double n, x, y;
  cin >> n >> x >> y;
  double a = y * n / 100;
  cout << (x <= ceil(a) ? ceil(a) - x : 0);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  solve();
}
