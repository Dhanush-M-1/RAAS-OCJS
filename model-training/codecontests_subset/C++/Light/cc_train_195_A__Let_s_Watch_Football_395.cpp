#include <bits/stdc++.h>
using namespace std;
const int maxx = 5;
const int mod = 1000000007LL;
const long long inf = 1e9 + 7;
int32_t main() {
  ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  int a, b, c;
  cin >> a >> b >> c;
  int i = 1;
  while ((c + i) * b < a * c) i++;
  cout << i;
  return 0;
}
