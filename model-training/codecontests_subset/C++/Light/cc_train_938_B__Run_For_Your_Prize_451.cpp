#include <bits/stdc++.h>
using namespace std;
long long n;
long long a[100005];
bool check(long long t) {
  for (long long i = 1; i <= n; i++) {
    if (((a[i] - 1) > t) && ((1000000LL - a[i]) > t)) return false;
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  for (long long i = 1; i <= n; i++) cin >> a[i];
  long long hi = 1e6;
  long long lo = 0;
  while (hi > lo) {
    long long mid = lo + (hi - lo) / 2;
    if (check(mid))
      hi = mid;
    else
      lo = mid + 1;
  }
  cout << lo << endl;
  return 0;
}
