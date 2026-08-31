#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  long long n;
  cin >> n;
  long long mid = 500000;
  long long maxi = 0, mini = 0;
  long long x;
  for (long long i = 1; i <= n; ++i) {
    cin >> x;
    if (x <= mid)
      maxi = x - 1;
    else if (mini != 0)
      continue;
    else
      mini = 1000000 - x;
  }
  cout << max(maxi, mini) << '\n';
}
