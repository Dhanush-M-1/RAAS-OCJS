#include <bits/stdc++.h>
using namespace std;
long long amax(long long a[], long long n) {
  long long max = 0;
  for (long long i = 0; i < n; i++) {
    if (a[i] > max) max = a[i];
  }
  return max;
}
long long amin(long long a[], long long n) {
  long long min = 1000000000;
  for (long long i = 0; i < n; i++) {
    if (a[i] < min) min = a[i];
  }
  return min;
}
bool sortinrev(const pair<int, int> &a, const pair<int, int> &b) {
  return (a.first > b.first);
}
int main() {
  long long t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    long long a[n];
    for (long long i = 0; i < n; i++) cin >> a[i];
    sort(a, a + n);
    long long a1 = a[n / 2];
    long long b1 = a[(n / 2) - 1];
    long long c = a[(n / 2) + 1];
    if (a[0] + a[1] <= a[n - 1])
      cout << 1 << " " << 2 << " " << n << endl;
    else
      cout << -1 << endl;
  }
  return 0;
}
