#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 6, M = 1e5 + 5;
int OO = 2e9 + 2;
int a, b, n, t, k, d, m, x, y, c, z, c2 = 1;
string s, s2;
long long A[100005];
vector<pair<int, int> > v;
vector<pair<int, int> > v2;
int mem[100005][6];
int solve(int c, int ch) {
  if (c >= n - 1) {
    return 0;
  }
  int &ret = mem[c][ch];
  if (ret != -1) return ret;
  ret = 0;
  if (v[c].first + v[c].second < v[c + 1].first &&
      (v[c].first + v[c].second < A[c + 1] || A[c + 1] == OO)) {
    A[c] = v[c].first + v[c].second;
    ret = max(ret, solve(c + 1, 1) + 1);
  }
  if (v[c].first - v[c].second > v[c - 1].first &&
      (v[c].first - v[c].second > A[c - 1] || A[c - 1] == OO)) {
    A[c] = v[c].first - v[c].second;
    ret = max(ret, solve(c + 1, 2) + 1);
  }
  ret = max(ret, solve(c + 1, 3));
  return ret;
}
int main() {
  cin >> n;
  memset(mem, -1, sizeof mem);
  fill(A, A + n + 2, OO);
  for (int i = 0; i < n; i++) {
    cin >> a >> b;
    v.push_back({a, b});
  }
  cout << solve(1, 4) + (n > 1 ? 2 : 1);
  return 0;
}
