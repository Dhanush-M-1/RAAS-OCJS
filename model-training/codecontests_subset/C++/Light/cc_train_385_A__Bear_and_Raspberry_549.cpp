#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, i;
  cin >> n >> c;
  int s[n];
  for (i = 0; i < n; i++) {
    cin >> s[i];
  }
  int d = 0, max1 = 0;
  for (i = 1; i < n; i++) {
    d = s[i - 1] - s[i];
    if (max1 < d) {
      max1 = d;
    }
  }
  if (max1 - c < 0) {
    cout << 0;
    return 0;
  }
  cout << max1 - c;
  return 0;
}
