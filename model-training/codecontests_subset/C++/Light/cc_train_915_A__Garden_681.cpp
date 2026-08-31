#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, m = 100000, a;
  cin >> n >> k;
  for (int i = 0; i < n; ++i) {
    cin >> a;
    if (k % a == 0) {
      m = min(k / a, m);
    }
  }
  cout << m << endl;
  return 0;
}
