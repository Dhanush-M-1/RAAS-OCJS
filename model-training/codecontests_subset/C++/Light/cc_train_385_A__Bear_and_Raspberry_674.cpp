#include <bits/stdc++.h>
using namespace std;
long long a, b, c[101], d[101], mx = -1e9, cnt;
int main() {
  cin >> a >> b;
  for (int i = 1; i <= a; ++i) {
    cin >> c[i];
  }
  for (int i = 1; i < a; ++i) {
    d[i] = c[i] - c[i + 1] - b;
  }
  for (int i = 1; i <= a; ++i) {
    mx = max(d[i], mx);
  }
  cout << mx;
  return 0;
}
