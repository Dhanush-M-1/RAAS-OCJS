#include <bits/stdc++.h>
using namespace std;
inline long long MAX2(long long a, long long int b) {
  return (a) > (b) ? (a) : (b);
}
inline long long MAX3(long long a, long long b, long long c) {
  return (a) > (b) ? ((a) > (c) ? (a) : (c)) : ((b) > (c) ? (b) : (c));
}
inline long long MIN2(long long a, long long b) {
  return (a) < (b) ? (a) : (b);
}
inline long long MIN3(long long a, long long b, long long c) {
  return (a) < (b) ? ((a) < (c) ? (a) : (c)) : ((b) < (c) ? (b) : (c));
}
using namespace std;
int main() {
  {
    int n, i;
    cin >> n;
    vector<int> a(n);
    int maxi = -1000000000, sum = 0;
    for (i = 0; i < n; i++) {
      cin >> a[i];
      maxi = max(maxi, a[i]);
      sum += a[i];
    }
    int k = max(maxi, (int)ceil((2.0 * sum + 1) / n));
    cout << k;
  }
  return 0;
}
