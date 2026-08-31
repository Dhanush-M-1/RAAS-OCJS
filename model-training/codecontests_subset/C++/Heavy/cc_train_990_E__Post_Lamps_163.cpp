#include <bits/stdc++.h>
using namespace std;
int needed(const vector<int>& links, int l) {
  int ans = 1;
  for (int curr = 0; curr + l < links.size(); ++ans) {
    int try_curr = links[curr + l];
    if (try_curr == curr) {
      ans = -1;
      break;
    } else {
      curr = try_curr;
    }
  }
  return ans;
}
int main() {
  std::ios::sync_with_stdio(false);
  int n, m, k;
  cin >> n >> m >> k;
  vector<char> ss(n);
  vector<int> links(n);
  for (int i = 0; i < m; ++i) {
    int s;
    cin >> s;
    ss[s] = true;
  }
  if (ss[0]) {
    cout << -1;
    return 0;
  }
  for (int i = 1; i < n; ++i) {
    if (ss[i]) {
      links[i] = links[i - 1];
    } else {
      links[i] = i;
    }
  }
  vector<long long> costs(k);
  for (int i = 0; i < k; ++i) {
    cin >> costs[i];
  }
  long long ans = -1;
  for (int i = 1; i <= k; ++i) {
    long long nee = needed(links, i);
    if (nee != -1) {
      long long c = costs[i - 1] * nee;
      if (ans == -1 || c < ans) {
        ans = c;
      }
    }
  }
  cout << ans;
  return 0;
}
