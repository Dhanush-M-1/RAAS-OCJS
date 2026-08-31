#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int size;
    cin >> size;
    std::vector<int> v(size);
    for (auto& x : v) cin >> x;
    if (v[0] + v[1] > v[size - 1])
      cout << -1 << endl;
    else
      cout << 1 << " " << 2 << " " << size << endl;
  }
  return 0;
}
