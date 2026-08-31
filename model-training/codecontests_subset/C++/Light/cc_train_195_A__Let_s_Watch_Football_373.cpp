#include <bits/stdc++.h>
using namespace std;
void solve() {
  int a, b, c;
  cin >> a >> b >> c;
  int data = c * a;
  int kitna = b * c;
  int bacha = data - kitna;
  int ans = bacha / b + (bacha % b != 0);
  cout << ans << endl;
}
signed main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL);
  solve();
}
