#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
int main() {
  long long n, k;
  long long h, maxx;
  maxx = INT_MIN;
  cin >> n >> k;
  long long arr[n];
  for (long long i = 0; i < n; i++) {
    cin >> arr[i];
    if (k % arr[i] == 0) {
      maxx = max(maxx, arr[i]);
    }
  }
  h = k / maxx;
  cout << h << "\n";
  return 0;
}
