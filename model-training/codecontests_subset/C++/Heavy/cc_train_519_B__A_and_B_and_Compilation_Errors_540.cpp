#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  long long n, temp;
  cin >> n;
  vector<long long> v, v1, v2;
  for (long long i = 1; i <= n; ++i) {
    cin >> temp;
    v.push_back(temp);
  }
  sort(v.begin(), v.end());
  for (long long i1 = 1; i1 <= n - 1; ++i1) {
    cin >> temp;
    v1.push_back(temp);
  }
  sort(v1.begin(), v1.end());
  for (long long i2 = 1; i2 <= n - 2; ++i2) {
    cin >> temp;
    v2.push_back(temp);
  }
  sort(v2.begin(), v2.end());
  for (long long j = 0; j < n; ++j) {
    if (v[j] != v1[j]) {
      cout << v[j] << endl;
      break;
    }
  }
  for (long long j = 0; j < n - 1; ++j) {
    if (v1[j] != v2[j]) {
      cout << v1[j];
      break;
    }
  }
  return 0;
}
