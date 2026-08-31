#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x[100000], h[100000], i;
  cin >> n;
  for (i = 0; i < n; i++) cin >> x[i] >> h[i];
  int start = x[0];
  int count = 1;
  for (i = 1; i < n - 1; i++) {
    if (x[i] - x[i - 1] > h[i])
      count++;
    else if (x[i + 1] - x[i] > h[i]) {
      count++;
      x[i] += h[i];
    }
  }
  if (n == 1) count--;
  cout << count + 1;
}
