#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<pair<int, int>> A(n);
  for (auto& [x, h] : A) cin >> x >> h;
  int n_cut = min(2, (int)A.size());
  for (int i = 1; i < (int)A.size() - 1; ++i) {
    int x_prev = A[i - 1].first, x_next = A[i + 1].first;
    int x = A[i].first, h = A[i].second;
    if (x_prev < x - h) {
      ++n_cut;
    } else if (x + h < x_next) {
      ++n_cut;
      A[i].first = x + h;
    }
  }
  cout << n_cut << endl;
}
