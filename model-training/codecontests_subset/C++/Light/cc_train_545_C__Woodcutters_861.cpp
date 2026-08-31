#include <bits/stdc++.h>
using namespace std;
int n, cnt, x[100000], h[100000], state[100000];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  for (int i = 0; i < n; ++i) cin >> x[i] >> h[i];
  for (int i = 0; i < n; ++i) {
    if (i == 0 || x[i] - x[i - 1] > h[i] + h[i - 1] ||
        (state[i - 1] != 1 && x[i] - x[i - 1] > h[i])) {
      state[i] = -1;
      ++cnt;
    } else if (i == n - 1 || x[i + 1] - x[i] > h[i]) {
      state[i] = 1;
      ++cnt;
    }
  }
  cout << cnt;
}
