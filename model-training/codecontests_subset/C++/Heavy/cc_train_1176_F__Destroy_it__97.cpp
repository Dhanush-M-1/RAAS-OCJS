#include <bits/stdc++.h>
using namespace std;
vector<vector<long long>> memo(2e5 + 10, vector<long long>(11, -1));
long long ks(vector<vector<vector<long long>>> &v, long long n, long long c) {
  if (n >= v.size()) return 0;
  if (memo[n][c] != -1) return memo[n][c];
  long long n11, n12, n13, n2, n21, n3;
  sort(v[n][1].rbegin(), v[n][1].rend());
  sort(v[n][2].rbegin(), v[n][2].rend());
  sort(v[n][3].rbegin(), v[n][3].rend());
  n11 = n12 = n13 = n2 = n21 = n3 = 0;
  if (v[n][1].size() >= 1) {
    n11 = v[n][1][0] + ks(v, n + 1, (c + 1) % 10);
    if (c + 1 >= 10) n11 += v[n][1][0];
  }
  if (v[n][1].size() >= 2) {
    n12 = v[n][1][0] + v[n][1][1] + ks(v, n + 1, (c + 2) % 10);
    if (c + 2 >= 10) n12 += v[n][1][0];
  }
  if (v[n][1].size() >= 3) {
    n13 = v[n][1][0] + v[n][1][1] + v[n][1][2] + ks(v, n + 1, (c + 3) % 10);
    if (c + 3 >= 10) n13 += v[n][1][0];
  }
  if (v[n][2].size() >= 1) {
    n2 = v[n][2][0] + ks(v, n + 1, (c + 1) % 10);
    if (c + 1 >= 10) n2 += v[n][2][0];
  }
  if (v[n][2].size() >= 1 && v[n][1].size() >= 1) {
    n21 = v[n][2][0] + ks(v, n + 1, (c + 2) % 10) + v[n][1][0];
    if (c + 2 >= 10) n21 += max(v[n][2][0], v[n][1][0]);
  }
  if (v[n][3].size() >= 1) {
    n3 = v[n][3][0] + ks(v, n + 1, (c + 1) % 10);
    if (c + 1 >= 10) n3 += v[n][3][0];
  }
  long long no = ks(v, n + 1, c);
  memo[n][c] = max(n11, n12);
  memo[n][c] = max(memo[n][c], n13);
  memo[n][c] = max(memo[n][c], n2);
  memo[n][c] = max(memo[n][c], n21);
  memo[n][c] = max(memo[n][c], n3);
  memo[n][c] = max(memo[n][c], no);
  return memo[n][c];
}
signed main() {
  long long n;
  cin >> n;
  vector<vector<vector<long long>>> v(n, vector<vector<long long>>(4));
  for (long long i = 0; i < n; i++) {
    long long k;
    cin >> k;
    for (long long j = 0; j < k; j++) {
      long long a, b;
      cin >> a >> b;
      v[i][a].push_back(b);
    }
  }
  cout << ks(v, 0, 0);
}
