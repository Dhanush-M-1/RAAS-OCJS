#include <bits/stdc++.h>
using namespace std;
long long i, j, x, n, y, m, k, k1, k2, ost, ur, a[100500], b[1300500], pos;
vector<long long> f[100500];
map<long long, long long> g;
int main() {
  cin >> n >> x >> y;
  k = 0;
  while (n * y > x * 100) {
    x++;
    k++;
  }
  cout << k << endl;
  return 0;
}
