#include <bits/stdc++.h>
using namespace std;
long long int m, n, c, d, j, k, l, r, x, t, y, u, a, b, z, i, e, f;
vector<long long int> v;
int main() {
  cin >> n;
  for (i = 1; i < n; i++) {
    for (j = 1; j < n; j++) {
      cout << i * j / n * 10 + ((i * j) % n) << " ";
    }
    cout << endl;
  }
}
