#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ull = unsigned long long;
using ld = long double;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  ;
  double n, b;
  int a;
  cin >> n >> a >> b;
  int ans = ceil((n * b) / 100) - a;
  if (ans <= 0)
    cout << 0;
  else
    cout << ans;
  return 0;
}
