#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  long long ans1 = 0;
  long long ans2 = 0;
  vector<int> v;
  cin >> n;
  for (long long i = 0; i < n; i++) {
    long long x;
    cin >> x;
    v.push_back(x);
  }
  long long k = 1;
  long long j = 1000000;
  for (int i = 0; i < n; i++) {
    if (abs(k - v[i]) < abs(j - v[i])) {
      ans1 = v[i] - 1;
    } else {
      ans2 = 1000000 - (v[i]);
      break;
    }
  }
  cout << max(ans1, ans2);
  return 0;
}
