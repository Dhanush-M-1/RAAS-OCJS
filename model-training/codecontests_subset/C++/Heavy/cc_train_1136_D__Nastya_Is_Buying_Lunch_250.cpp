#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  vector<int> v(n);
  for (int i = 0; i < n; ++i) {
    cin >> v[i];
    --v[i];
  }
  vector<vector<int>> willPass(n);
  for (int i = 0; i < m; ++i) {
    int a, b;
    cin >> a >> b;
    --a;
    --b;
    willPass[a].push_back(b);
  }
  vector<int> isBarrier(n);
  isBarrier[v.back()] = true;
  int barrierSize = 1;
  int answer = 0;
  for (int step = 1; step < n; ++step) {
    int currentStartPos = n - step - 1;
    int passSuccess = 0;
    for (auto toPass : willPass[v[currentStartPos]]) {
      if (isBarrier[toPass]) {
        ++passSuccess;
      }
    }
    if (passSuccess == barrierSize) {
      ++answer;
    } else {
      isBarrier[v[currentStartPos]] = true;
      ++barrierSize;
    }
  }
  cout << answer << "\n";
  return 0;
}
