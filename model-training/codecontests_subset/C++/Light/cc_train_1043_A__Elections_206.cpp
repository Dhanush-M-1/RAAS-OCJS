#include <bits/stdc++.h>
using namespace std;
void die(long long x) {
  cout << x << flush;
  exit(0);
}
int n;
int sum, maxi, k;
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    sum += x;
    maxi = max(maxi, x);
  }
  k = (2 * sum) / n + 1;
  cout << max(k, maxi);
  return 0;
}
