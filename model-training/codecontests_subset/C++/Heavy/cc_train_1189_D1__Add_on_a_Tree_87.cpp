#include <bits/stdc++.h>
using namespace std;
long long power(long long x, long long y, long long p) {
  long long res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
std::vector<long long> edge[100045];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t, i, j, n, m, k, q, temp, x, y;
  {
    long long count = 0;
    bool flag = 0;
    long long a[200050] = {0};
    string s;
    cin >> n;
    for (int i = 0; i < n - 1; i++) {
      cin >> x >> y;
      edge[x].push_back(y);
      edge[y].push_back(x);
    }
    {
      flag = true;
      for (i = 1; i <= n; i++) {
        if (edge[i].size() == 2) {
          flag = false;
        }
      }
      if (flag) {
        cout << "YES" << endl;
      } else {
        cout << "NO" << endl;
      }
    }
  }
  return 0;
}
