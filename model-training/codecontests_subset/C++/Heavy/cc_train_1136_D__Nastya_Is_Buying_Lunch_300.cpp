#include <bits/stdc++.h>
using namespace std;
int n, m;
int A[300005];
int P[300005];
int T[300005];
vector<int> v[300005];
int fenwick[300005];
void updt(int idx) {
  while (idx <= n) {
    fenwick[idx]++;
    idx += (idx & (-idx));
  }
}
int sum(int idx) {
  int ret = 0;
  while (idx > 0) {
    ret += fenwick[idx];
    idx -= (idx & (-idx));
  }
  return ret;
}
vector<int> z[300005];
int L[300005];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> A[i], P[A[i]] = i;
  for (int i = 1; i <= n; i++) T[i] = n - i;
  for (int i = 1; i <= m; i++) {
    int a, b;
    cin >> a >> b;
    if (P[a] < P[b]) {
      T[P[a]]--;
      z[P[b]].push_back(P[a]);
    }
  }
  for (int i = 1; i < n; i++) {
    v[T[i]].push_back(i);
  }
  int ans = 0;
  for (int idx = n - 1; idx >= 1; idx--) {
    int cnt = sum(n) - sum(idx) - L[idx];
    if (cnt == T[idx]) {
      updt(idx);
      ans++;
      for (int k : z[idx]) {
        L[k]++;
      }
    }
  }
  cout << ans;
  return 0;
}
