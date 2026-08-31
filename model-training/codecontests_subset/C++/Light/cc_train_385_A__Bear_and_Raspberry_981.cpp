#include <bits/stdc++.h>
using namespace std;
int main() {
  stack<int> v;
  int n, k, i, ma, a;
  cin >> n >> k;
  ma = 0;
  for (i = 1; i <= n; i++) {
    if (i != 1) {
      cin >> a;
      if (v.top() - a > ma) ma = v.top() - a;
      v.push(a);
    } else {
      cin >> a;
      v.push(a);
    }
  }
  if (ma - k >= 0) {
    ma = ma - k;
    cout << ma << endl;
  } else
    cout << 0 << endl;
}
