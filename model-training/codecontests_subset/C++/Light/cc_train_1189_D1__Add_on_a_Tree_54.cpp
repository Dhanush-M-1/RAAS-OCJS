#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n;
  cin >> n;
  vector<vector<long long>> v(n);
  for (long long i = 0; i < n - 1; i++) {
    long long a, b;
    cin >> a >> b;
    v[a - 1].push_back(b - 1);
    v[b - 1].push_back(a - 1);
  }
  for (long long i = 0; i < n; i++) {
    if (v[i].size() == 2) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
}
