#include <bits/stdc++.h>
using namespace std;
int x[100005], h[100005];
int main() {
  ifstream fin("date.in");
  ofstream fout("date.out");
  int n, i, last, sol = 0;
  cin >> n;
  for (i = 1; i <= n; ++i) cin >> x[i] >> h[i];
  last = -2000000010;
  x[n + 1] = 2000000010;
  for (i = 1; i <= n; ++i)
    if (x[i] - h[i] > last) {
      last = x[i];
      ++sol;
    } else if (x[i] + h[i] < x[i + 1]) {
      ++sol;
      last = x[i] + h[i];
    } else {
      last = x[i];
    }
  cout << sol;
  return 0;
}
