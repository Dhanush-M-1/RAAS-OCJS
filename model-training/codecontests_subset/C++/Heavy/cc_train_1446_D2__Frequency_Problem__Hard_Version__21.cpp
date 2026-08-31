#include <bits/stdc++.h>
using namespace std;
int n;
int A[200005];
int block = 450;
vector<int> L[200005];
int vs[400005];
vector<pair<int, int> > Len;
vector<int> Exit[200005];
vector<int> T;
int dp[200005];
int lo;
int force(int D, int V) {
  T.clear();
  int bal = 0;
  vs[bal + n] = 0;
  T.push_back(bal);
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    if (A[i] == D)
      bal++;
    else if (A[i] == V)
      bal--;
    if (vs[bal + n] >= 0) {
      ans = max(ans, i - vs[bal + n]);
    }
    if (vs[bal + n] == -1) {
      T.push_back(bal);
      vs[bal + n] = i;
    }
  }
  for (int v : T) {
    vs[v + n] = -1;
  }
  return ans;
}
void smallForce(int D, int V, int len) {
  int N = L[V].size();
  for (int i = 0; i + len - 1 < N; i++) {
    int l = i, r = i + len - 1;
    Len.push_back(make_pair(L[V][i], L[V][r]));
  }
}
int solve(int D, int len) {
  int ans = 0;
  int bal = 0;
  for (int i = 0; i <= L[D].size(); i++) dp[i] = -1;
  lo = 0;
  for (auto it : Len) {
    int a = it.first, b = it.second;
    Exit[b].push_back(a);
  }
  dp[0] = 0;
  for (int i = 1; i <= n; i++) {
    if (A[i] == D) bal++;
    for (int a : Exit[i]) {
      lo = max(lo, a);
    }
    if (bal >= len) {
      int ll = dp[bal - len] + 1;
      if (lo >= ll) {
        ans = max(ans, i - ll + 1);
      }
    }
    if (dp[bal] == -1) dp[bal] = i;
  }
  for (auto it : Len) {
    Exit[it.second].clear();
  }
  return ans;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &A[i]);
    L[A[i]].push_back(i);
  }
  int D = 1;
  for (int i = 1; i <= n; i++) {
    if (L[i].size() > L[D].size()) D = i;
  }
  memset(vs, -1, sizeof(vs));
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    if (D == i) continue;
    if (L[i].size() >= block) {
      ans = max(ans, force(D, i));
    }
  }
  for (int len = 1; len < block; len++) {
    Len.clear();
    for (int j = 1; j <= n; j++) {
      if (j == D) continue;
      if (L[j].size() >= len) {
        smallForce(D, j, len);
      }
    }
    ans = max(ans, solve(D, len));
  }
  printf("%d\n", ans);
  return 0;
}
