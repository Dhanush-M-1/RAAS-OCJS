#include <bits/stdc++.h>
using namespace std;
int n, a, k = 0, k1 = 1000000, v = 0;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a;
    v = max(min(a - 1, 1000000 - a), v);
  }
  cout << v;
}
