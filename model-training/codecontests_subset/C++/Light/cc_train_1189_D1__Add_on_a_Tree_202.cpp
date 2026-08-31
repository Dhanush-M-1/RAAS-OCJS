#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 1;
vector<long long> v[N];
int main() {
  long long n;
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    long long x, y;
    cin >> x >> y;
    v[x].push_back(y);
    v[y].push_back(x);
  }
  for (int i = 1; i <= n; i++) {
    if (v[i].size() == 2) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
}
