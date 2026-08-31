#include <bits/stdc++.h>
using namespace std;
long long int power(long long int x, long long int y, long long int p) {
  long long int res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
long long int modInverse(long long int n, long long int p) {
  return power(n, p - 2, p);
}
struct point {
  long long int x, y;
};
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int n;
  cin >> n;
  vector<long long int> arr(n);
  for (long long int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  long long int k = *max_element(arr.begin(), arr.end());
  while (true) {
    long long int val1 = 0, val2 = 0;
    for (long long int i = 0; i < n; i++) {
      val2 += arr[i];
      val1 += (k - arr[i]);
    }
    if (val1 > val2) {
      cout << k << "\n";
      return 0;
    }
    k++;
  }
}
