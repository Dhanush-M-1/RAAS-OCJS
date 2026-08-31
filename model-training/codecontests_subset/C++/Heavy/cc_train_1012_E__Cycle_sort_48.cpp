#include <bits/stdc++.h>
using namespace std;
int N, S;
int A[200020], B[200020];
vector<int> vx;
int pp[200020];
int Find(int x) { return pp[x] == x ? x : pp[x] = Find(pp[x]); }
vector<int> vs[2][200020];
int nxt[200020];
int main() {
  scanf("%d%d", &N, &S);
  for (int i = 1; i <= N; i++) scanf("%d", A + i);
  for (int i = 1; i <= N; i++) vx.push_back(A[i]);
  sort(vx.begin(), vx.end());
  vx.resize(unique(vx.begin(), vx.end()) - vx.begin());
  for (int i = 1; i <= N; i++)
    A[i] = (int)(lower_bound(vx.begin(), vx.end(), A[i]) - vx.begin() + 1);
  for (int i = 1; i <= N; i++) B[i] = A[i];
  sort(B + 1, B + 1 + N);
  int cnt = 0;
  for (int i = 1; i <= N; i++)
    if (B[i] != A[i]) ++cnt;
  if (cnt > S) {
    puts("-1");
    return 0;
  }
  for (int i = 1; i <= N; i++) pp[i] = i;
  for (int i = 1; i <= N; i++)
    if (A[i] != B[i]) {
      vs[0][A[i]].push_back(i);
      vs[1][B[i]].push_back(i);
    }
  int L = (int)vx.size();
  for (int i = 1; i <= L; i++) {
    int n = (int)vs[0][i].size();
    for (int j = 0; j < n; j++) {
      int x = vs[0][i][j], y = vs[1][i][j];
      nxt[x] = y;
      int px = Find(x), py = Find(y);
      if (px != py) pp[px] = py;
    }
  }
  for (int i = 1; i <= L; i++) {
    int n = (int)vs[0][i].size();
    for (int j = 1; j < n; j++) {
      int x = vs[0][i][0];
      int y = vs[0][i][j];
      int px = Find(x), py = Find(y);
      if (px != py) {
        swap(nxt[x], nxt[y]);
        pp[px] = py;
      }
    }
  }
  int c[200020] = {};
  for (int i = 1; i <= N; i++) c[Find(i)]++;
  vector<pair<int, int> > v;
  for (int i = 1; i <= N; i++)
    if (pp[i] == i && A[i] != B[i]) v.push_back(pair<int, int>(c[i], i));
  sort(v.begin(), v.end());
  reverse(v.begin(), v.end());
  S -= cnt;
  vector<vector<int> > ans;
  if (S > 2 && (int)v.size() > 2) {
    int r = min(S, (int)v.size());
    int save = nxt[v[0].second];
    for (int i = 0; i < r - 1; i++) nxt[v[i].second] = nxt[v[i + 1].second];
    nxt[v[r - 1].second] = save;
    vector<int> nv;
    for (int i = 0; i < r; i++) nv.push_back(v[i].second);
    reverse(nv.begin(), nv.end());
    ans.push_back(nv);
    for (int i = 1; i < r; i++) pp[Find(v[i].second)] = Find(v[0].second);
  }
  for (int i = 1; i <= N; i++)
    if (A[i] != B[i] && pp[i] == i) {
      vector<int> v;
      v.push_back(i);
      for (int t = nxt[i]; t != i; t = nxt[t]) {
        v.push_back(t);
      }
      ans.push_back(v);
    }
  printf("%d\n", (int)ans.size());
  for (auto e : ans) {
    printf("%d\n", (int)e.size());
    for (int f : e) printf("%d ", f);
    puts("");
  }
  return 0;
}
