#include <bits/stdc++.h>
using namespace std;
int x[100005], h[100005];
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> x[i] >> h[i];
  int s = min(2, n);
  for (int i = 1; i < n - 1; i++) {
    if (x[i] - h[i] > x[i - 1])
      s++;
    else if (x[i] + h[i] < x[i + 1])
      s++, x[i] = x[i] + h[i];
  }
  cout << s;
  return 0;
}
