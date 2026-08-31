#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, s = 1;
  cin >> n;
  long long x[n], h[n];
  for (int i = 0; i < n; i++) cin >> x[i] >> h[i];
  for (int i = 1; i < n; i++) {
    if (x[i] - x[i - 1] > h[i])
      s++;
    else if (x[i + 1] - x[i] > h[i]) {
      s++;
      x[i] = x[i] + h[i];
    }
  }
  cout << s;
  return 0;
}
