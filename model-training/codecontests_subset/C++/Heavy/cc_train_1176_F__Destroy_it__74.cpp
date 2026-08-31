#include <bits/stdc++.h>
using namespace std;
long long fc(int d, int k) { return (k == 9 ? d << 1 : d); }
long long dp[200000][10];
int n;
multiset<int, greater<int> > A[200000][3];
vector<int> ing(int ind, int d) {
  vector<int> a;
  for (auto i : A[ind][0]) {
    if (a.size() == d) break;
    a.push_back(i);
  }
  reverse(a.begin(), a.end());
  return a;
}
long long f(int i, int k) {
  if (i >= n) return 0;
  if (k > 9) return f(i, k - 10);
  if (dp[i][k] > -1) return dp[i][k];
  long long mx = f(i + 1, k);
  vector<int> a = ing(i, 3);
  if (a.size() == 3) do {
      mx = max(mx, f(i + 1, k + 3) + fc(a[0], k) + fc(a[1], k + 1) +
                       fc(a[2], k + 2));
    } while (next_permutation(a.begin(), a.end()));
  a = ing(i, 2);
  if (a.size() == 2) do {
      mx = max(mx, f(i + 1, k + 2) + fc(a[0], k) + fc(a[1], k + 1));
    } while (next_permutation(a.begin(), a.end()));
  a = ing(i, 1);
  if (a.size() == 1) {
    mx = max(mx, f(i + 1, k + 1) + fc(a[0], k));
    if (!A[i][1].empty()) {
      int rx = *A[i][1].begin();
      mx = max(mx, f(i + 1, k + 2) + fc(a[0], k) + fc(rx, k + 1));
      mx = max(mx, f(i + 1, k + 2) + fc(rx, k) + fc(a[0], k + 1));
    }
  }
  if (!A[i][1].empty()) mx = max(mx, f(i + 1, k + 1) + fc(*A[i][1].begin(), k));
  if (!A[i][2].empty()) mx = max(mx, f(i + 1, k + 1) + fc(*A[i][2].begin(), k));
  return dp[i][k] = mx;
}
int main() {
  cin.tie(NULL)->sync_with_stdio(false);
  cin >> n;
  memset(dp, -1, sizeof dp);
  for (int i = 0; i < n; ++i) {
    int k;
    cin >> k;
    int u, v;
    while (k--) {
      cin >> u >> v;
      A[i][u - 1].insert(v);
    }
  }
  cout << f(0, 0);
  return 0;
}
