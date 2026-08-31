#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
int main() {
  int n, x[N], m = 0, s = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x[i];
  }
  for (int i = 0; i < n; i++) {
    m = min(x[i] - 1, 1000000 - x[i]);
    s = max(s, m);
  }
  cout << s << endl;
  return 0;
}
