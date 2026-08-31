#include <bits/stdc++.h>
using namespace std;
int const MAX = 1000 * 100 + 10;
int const MAX2 = 1000 * 1000 + 10;
int const MAX3 = 5000 + 10;
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int n;
  cin >> n;
  string x;
  cin >> x;
  int in = 0;
  for (int i = 0; i < x.size(); i++) {
    if (x[i] == 'I') in++;
  }
  int ans = 0;
  for (int i = 0; i < x.size(); i++) {
    if (x[i] == 'I' && in == 1) ans++;
    if (x[i] == 'A' && in == 0) ans++;
  }
  cout << ans;
}
