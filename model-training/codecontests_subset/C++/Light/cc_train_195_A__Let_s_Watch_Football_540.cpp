#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  long long a, b, c;
  cin >> a >> b >> c;
  long long t = (c * a + b - 1) / b;
  cout << t - c << '\n';
  return 0;
}
