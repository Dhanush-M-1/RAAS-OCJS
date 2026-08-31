#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long int n;
  cin >> n;
  long long int a[n];
  long long int s = 0;
  long long int m = INT_MIN;
  for (long long int i = 0; i < n; i++) {
    cin >> a[i];
    s += a[i];
    m = max(a[i], m);
  }
  cout << max(m, (2 * s / n + 1));
}
