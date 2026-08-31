#include <bits/stdc++.h>
using namespace std;
long long k, p;
long long mult(long long x, long long y) {
  long long r = x * y;
  vector<long long> g;
  while (r) {
    g.push_back(r % k);
    r /= k;
  }
  for (int i = g.size() - 1; i >= 0; i--) {
    r = r * 10 + g[i];
  }
  return r;
}
int main() {
  cin >> k;
  for (int i = 1; i < k; i++)
    for (int j = 1; j < k; j++)
      if (j == k - 1)
        cout << mult(i, j) << endl;
      else
        cout << mult(i, j) << " ";
  return 0;
}
