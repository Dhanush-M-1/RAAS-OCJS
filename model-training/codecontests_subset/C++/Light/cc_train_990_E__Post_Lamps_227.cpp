#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, k;
  cin >> n >> m >> k;
  vector<bool> blocked(n + 1, false);
  for (int i = 0; i < m; ++i) {
    int loc;
    scanf("%d", &loc);
    if (loc == 0) {
      cout << -1 << endl;
      return 0;
    }
    blocked[loc] = true;
  }
  vector<long long int> costs(k);
  for (int i = 0; i < k; ++i) {
    scanf("%lld", &costs[i]);
  }
  vector<int> coord(n + 1);
  coord[0] = 0;
  for (int i = 1; i <= n; ++i) {
    if (blocked[i]) {
      coord[i] = coord[i - 1];
    } else {
      coord[i] = i;
    }
  }
  int now = 0;
  int cons = 0;
  for (int i = 0; i <= n; ++i) {
    if (blocked[i]) {
      ++now;
      if (now > cons) cons = now;
    } else {
      now = 0;
    }
  }
  if (cons >= k) {
    cout << -1 << endl;
    return 0;
  }
  long long int answer = (long long int)n * (long long int)10000000;
  for (int i = cons + 1; i <= k; ++i) {
    long long int count = 0;
    long long int here = 0;
    while (true) {
      count += costs[i - 1];
      if (here + i >= n) {
        break;
      } else {
        here = coord[here + i];
      }
    }
    if (count < answer) answer = count;
  }
  cout << answer << endl;
}
