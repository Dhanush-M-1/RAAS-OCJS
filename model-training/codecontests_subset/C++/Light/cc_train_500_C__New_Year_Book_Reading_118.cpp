#include <bits/stdc++.h>
using namespace std;
int b[100000], w[100000];
deque<int> init;
bool used[100000];
int main() {
  int n, m, len = 0;
  cin >> n >> m;
  for (int i = 0, _n = n; i < _n; i++) cin >> w[i];
  for (int i = 0, _n = m; i < _n; i++) {
    cin >> b[i];
    b[i]--;
  }
  for (int i = 0, _n = m; i < _n; i++) {
    if (!used[b[i]]) init.push_back(b[i]);
    used[b[i]] = true;
  }
  int ans = 0;
  for (int i = 0, _n = m; i < _n; i++) {
    int idx = 0;
    for (int j = 0, _n = n; j < _n; j++) {
      if (init[j] != b[i])
        ans += w[init[j]];
      else {
        idx = j;
        break;
      }
    }
    init.erase(init.begin() + idx);
    init.push_front(b[i]);
  }
  cout << ans << "\n";
  return 0;
}
