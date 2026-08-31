#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  int p[n], pr[n - 1];
  for (int i = 0; i < n; i++) {
    cin >> p[i];
    if (i > 0) pr[i - 1] = p[i - 1] - p[i] - c;
  }
  int max = 0;
  for (int i = 0; i < n - 1; i++) {
    if (max <= pr[i]) {
      max = pr[i];
    }
  }
  cout << max << endl;
  return 0;
}
