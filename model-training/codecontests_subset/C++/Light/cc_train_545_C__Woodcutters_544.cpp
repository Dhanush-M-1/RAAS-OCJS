#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  vector<long long> v(n), h(n);
  for (long long i = 0; i < n; i++) cin >> v[i] >> h[i];
  if (n <= 2) {
    cout << n << endl;
    return 0;
  }
  long long k = 2, a = v[0];
  for (long long i = 1; i < n - 1; i++) {
    if ((v[i] - h[i]) > a) {
      k++;
      a = v[i];
    } else if ((v[i] + h[i]) < v[i + 1]) {
      k++;
      a = v[i] + h[i];
    } else
      a = v[i];
  }
  cout << k << endl;
  return 0;
}
