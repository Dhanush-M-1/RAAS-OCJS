#include <bits/stdc++.h>
using namespace std;
int n;
int main() {
  cin >> n;
  double sum = 0;
  int a, best = 0;
  for (int i = 0; i < n; ++i) cin >> a, sum += 2 * a, best = max(best, a);
  if (sum / n == ceil(sum / n))
    sum = sum / n + 1;
  else
    sum = ceil(sum / n);
  cout << max(best, int(sum)) << '\n';
}
