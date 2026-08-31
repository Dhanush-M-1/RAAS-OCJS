#include <bits/stdc++.h>
void seieve();
long long maxx(long long, long long);
long long minn(long long, long long);
using namespace std;
const long long mod = 1000000007;
const long long limits = (long long)1e18;
long long primes[1000001] = {0};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0), cout.tie(0);
  long long t, i, j = 0, k, n, m, o, p;
  cin >> n;
  long long a[n], mx = -1;
  long long suuum = 0;
  for (i = 0; i < n; i++) {
    cin >> a[i];
    suuum += a[i];
    if (a[i] > mx) mx = a[i];
  }
  for (i = mx; i < 400; i++) {
    long long sum = 0;
    for (j = 0; j < n; j++) {
      sum += i - a[j];
    }
    if (sum > suuum) {
      cout << i << endl;
      break;
    }
  }
  return 0;
}
void seieve() {
  long long i, p;
  primes[0] = 1;
  primes[1] = 1;
  for (p = 2; p * p <= 1000000; p++) {
    if (primes[p] == 0) {
      for (i = p * 2; i <= 1000000; i += p) primes[i] = 1;
    }
  }
}
long long maxx(long long a, long long b) { return (a > b) ? a : b; }
long long minn(long long a, long long b) { return (a < b) ? a : b; }
