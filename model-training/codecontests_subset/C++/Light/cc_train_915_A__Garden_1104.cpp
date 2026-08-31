#include <bits/stdc++.h>
using namespace std;
template <class T>
int size(const T &x) {
  return x.size();
}
template <class T>
T mod(T a, T b) {
  return (b + (a % b)) % b;
}
const int INF = ~(1 << 31);
const double EPS = 1e-9;
const double PI = acos(-1);
int main() {
  int k, n, a;
  cin >> n >> k;
  int mn = INF;
  for (__typeof(0) i = 0; i < (n); i++) {
    cin >> a;
    if ((k % a) != 0) continue;
    mn = min(mn, k / a);
  }
  cout << mn << '\n';
  return 0;
}
