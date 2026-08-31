#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  int64_t a, b, result = 0, wasted = 0;
  cin >> a >> b;
  cout << a + ((a - 1) / (b - 1)) << '\n';
  return 0;
}
