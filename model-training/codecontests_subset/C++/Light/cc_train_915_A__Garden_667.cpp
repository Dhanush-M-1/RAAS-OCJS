#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  int a[110];
  int x;
  int time, best;
  best = 9999999;
  cin >> n >> k;
  for (x = 1; x <= n; x++) {
    cin >> a[x];
  }
  for (x = 1; x <= n; x++) {
    if (k % a[x] == 0) {
      time = k / a[x];
      if (best > time) {
        best = time;
      }
    }
  }
  cout << best << endl;
}
