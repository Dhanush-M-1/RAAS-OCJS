#include <bits/stdc++.h>
using namespace std;
int v[100000 + 1], h[100000 + 1];
int main() {
  int n, i, sol;
  cin >> n;
  for (i = 0; i < n; i++) cin >> v[i] >> h[i];
  v[n] = INT_MAX;
  sol = 1;
  for (i = 1; i < n; i++) {
    if (v[i] - v[i - 1] > h[i])
      sol++;
    else if (v[i + 1] - v[i] > h[i]) {
      v[i] += h[i];
      sol++;
    }
  }
  cout << sol;
  return 0;
}
