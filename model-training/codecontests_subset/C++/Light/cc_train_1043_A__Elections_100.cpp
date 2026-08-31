#include <bits/stdc++.h>
using namespace std;
struct Solution {
  void RunTest(size_t test_id) {
    int n;
    cin >> n;
    vector<int64_t> v(n);
    int64_t mx = 0;
    for (int i = 0; i < n; ++i) {
      cin >> v[i];
      mx = max(mx, v[i]);
    }
    int64_t a = 0, b = 0;
    for (int i = 0; i < n; ++i) {
      a += v[i];
      b += mx - v[i];
    }
    while (a >= b) {
      b += n;
      ++mx;
    }
    cout << mx << endl;
  }
};
int main() {
  std::ios_base::sync_with_stdio(false);
  constexpr size_t t = 1;
  Solution executor;
  for (size_t i = 0; i < t; ++i) {
    executor.RunTest(i);
  }
}
