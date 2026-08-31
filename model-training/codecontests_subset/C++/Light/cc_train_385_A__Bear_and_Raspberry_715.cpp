#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  vector<int> k(n);
  int max = 0;
  for (int i = 0; i < n; i++) {
    cin >> k[i];
    if (i > 0) {
      max = std::max(k[i - 1] - k[i] - c, max);
    }
  }
  cout << max << endl;
  return 0;
}
