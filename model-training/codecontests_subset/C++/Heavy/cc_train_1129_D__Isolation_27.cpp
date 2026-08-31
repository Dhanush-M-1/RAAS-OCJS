#include <bits/stdc++.h>
using namespace std;
const int mod = 998244353;
const int N = 100005;
const int B = 620;
int n, k, a[N];
int dp[N];
int cnt[N];
vector<int> occ[N];
int delta[B];
vector<int> vet[B];
vector<int> psum[B];
void add(int &aa, int b) { aa = aa + b >= mod ? aa + b - mod : aa + b; }
void rebuild(int id) {
  sort(vet[id].begin(), vet[id].end(),
       [=](int q, int w) { return cnt[q] < cnt[w]; });
  for (int i = 0; i < (int)vet[id].size(); i++) {
    if (!i)
      psum[id][i] = 0;
    else
      psum[id][i] = psum[id][i - 1];
    add(psum[id][i], dp[vet[id][i] - 1]);
  }
}
void add(int L, int R, int val) {
  int ida = L / B, idb = R / B;
  if (ida == idb) {
    for (int i = L; i <= R; i++) cnt[i] += val;
    rebuild(ida);
    return;
  }
  for (int i = L; ida == i / B; i++) cnt[i] += val;
  for (int i = idb * B; i <= R; i++) cnt[i] += val;
  rebuild(ida);
  rebuild(idb);
  for (int i = ida + 1; i < idb; i++) delta[i] += val;
}
int get(int id) {
  vector<int> &v = vet[id];
  int L = 0, R = (int)v.size() - 1, ans = (int)v.size();
  while (L <= R) {
    int mid = (L + R) / 2;
    if (cnt[v[mid]] + delta[id] > k) {
      ans = mid;
      R = mid - 1;
    } else
      L = mid + 1;
  }
  if (!ans) return 0;
  return psum[id][ans - 1];
}
int query(int lim) {
  int ans = 0;
  for (int id = 0; id <= lim / B; id++) {
    add(ans, get(id));
  }
  return ans;
}
int main() {
  scanf("%d %d", &n, &k);
  for (int i = 1; i <= n; i++) scanf("%d", a + i);
  for (int i = 1; i <= n; i++) {
    occ[i].push_back(0);
    occ[i].push_back(0);
    vet[i / B].push_back(i);
    psum[i / B].push_back(0);
  }
  dp[0] = 1;
  for (int i = 1; i <= n; i++) {
    vector<int> &v = occ[a[i]];
    add(v[v.size() - 2] + 1, v.back(), -1);
    add(v.back() + 1, i, +1);
    occ[a[i]].push_back(i);
    dp[i] = query(i);
  }
  cout << dp[n] << endl;
}
