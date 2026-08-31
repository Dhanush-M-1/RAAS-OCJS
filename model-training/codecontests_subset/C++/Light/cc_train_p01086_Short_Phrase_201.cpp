#include <bits/stdc++.h>
using namespace std;

int main() {
  int n;
  while (cin >> n, n) {
    auto c = vector<int>(n);
    for (int i = 0; i < n; ++i) {
      string w; cin >> w;
      c[i] = w.length();
    }
    auto solve = [&]() {
      for (int i = 0; i < n; ++i) {
        auto phrase = vector<int>{5, 7, 5, 7, 7};
        int idx = 0;
        for (int j = i; j < n; ++j) {
          if (phrase[idx] > 0) phrase[idx] -= c[j];
          if (phrase[idx] < 0) break;
          if (phrase[idx] == 0) ++idx;
          if (idx == 5) return i + 1;
        }
      }
      return 0;
    };
    cout << solve() << endl;
  }
  return 0;
}

