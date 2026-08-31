#include <bits/stdc++.h>
using namespace std;
long long binpow(long long a, long long b) {
  a = a % 1000000007;
  long long res = 1;
  while (b > 0) {
    if (b & 1) res *= a % 1000000007;
    a = a * a % 1000000007;
    b = b >> 1;
  }
  return res;
}
void speedup() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
}
int main() {
  speedup();
  int n;
  cin >> n;
  int sum = 0;
  int k;
  int ma = 0;
  for (int i = 0; i < n; i++) {
    cin >> k;
    sum += k;
    ma = max(ma, k);
  }
  sum = 2 * sum + 1;
  int j = ceil((double)sum / n);
  cout << max(ma, j) << "\n";
}
