#include <bits/stdc++.h>
using namespace std;
namespace task {
int n, s, a, k;
int main() {
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> a;
    s += a;
    k = max(k, a);
  }
  for (int i = k; i < 100000000; ++i) {
    if (s < n * i - s) {
      return cout << i << '\n', 0;
    }
  }
  return 0;
}
}  // namespace task
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.precision(11);
  cout.setf(ios::fixed);
  return task::main();
}
