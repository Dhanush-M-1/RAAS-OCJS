#include <bits/stdc++.h>
struct compare {
  bool operator()(const int& l, const int& r) { return l > r; }
};
using namespace std;
priority_queue<int, vector<int>, compare> pq;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, m, k;
  cin >> n >> m >> k;
  int s[m];
  for (int i = 0; i < m; ++i) cin >> s[i];
  long long a[k + 1];
  for (int i = 1; i < k + 1; ++i) cin >> a[i];
  int c = 0;
  vector<int> u;
  for (int i = 0; i < n; i++) {
    if (c == m)
      u.push_back(i);
    else if (i == s[c])
      c++;
    else
      u.push_back(i);
  }
  if (u.size() == 0) {
    cout << -1;
    return 0;
  } else if (u[0]) {
    cout << -1;
    return 0;
  }
  long long mi = 1e14;
  for (int kk = 1; kk <= k; kk++) {
    int cnt = 0;
    int f = 0;
    int i = 0;
    while (i < n) {
      int ind = upper_bound(u.begin(), u.end(), i + 1) - u.begin();
      ind = max(ind, 0);
      if (ind >= u.size()) ind = u.size() - 1;
      while (ind > 0 && u[ind] > i) ind--;
      if (u[ind] > i) {
        f = 1;
        break;
      } else if (u[ind] <= i - kk) {
        f = 1;
        break;
      } else {
        i = u[ind] + kk;
        cnt++;
      }
    }
    if (!f) {
      mi = min(mi, cnt * a[kk]);
    }
  }
  if (mi >= (long long)1e14)
    cout << -1 << "\n";
  else
    cout << mi << "\n";
}
