#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n;
  string s, a;
  cin >> n;
  long long r = LONG_MIN;
  long long int x[n + 10], h[n + 10];
  for (int i = 0; i < n; i++) cin >> x[i] >> h[i];
  x[n] = LONG_MAX;
  int cnt = 0;
  for (int i = 0; i < n; i++) {
    if (x[i] - h[i] > r) {
      r = x[i];
      cnt++;
    } else if (x[i] + h[i] < x[i + 1]) {
      r = x[i] + h[i];
      cnt++;
    } else {
      r = x[i];
    }
  }
  cout << cnt << endl;
}
