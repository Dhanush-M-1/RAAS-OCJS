#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
const int MAXN = 200000;
int n, lim;
int a[MAXN];
int b[MAXN];
bool isfixed[MAXN];
pair<int, int> o[MAXN];
int no;
int dst[MAXN];
int cyc[MAXN], ncyc;
int par[MAXN], sz[MAXN];
int find(int a) {
  if (par[a] == a) return a;
  return par[a] = find(par[a]);
}
bool unite(int a, int b) {
  a = find(a), b = find(b);
  if (a == b) return false;
  if (sz[a] < sz[b]) swap(a, b);
  par[b] = a, sz[a] += sz[b];
  return true;
}
bool done[MAXN];
vector<vector<int>> ans;
bool solve() {
  for (int i = (0); i < (n); ++i) b[i] = a[i];
  sort(b, b + n);
  int nfixed = 0;
  for (int i = (0); i < (n); ++i) {
    isfixed[i] = a[i] == b[i];
    if (isfixed[i]) ++nfixed;
  }
  if (n - nfixed > lim) return false;
  no = 0;
  for (int i = (0); i < (n); ++i)
    if (!isfixed[i]) o[no++] = make_pair(a[i], i);
  sort(o, o + no);
  for (int i = (0); i < (n); ++i) dst[i] = isfixed[i] ? i : -1;
  {
    int at = 0;
    for (int i = (0); i < (no); ++i) {
      while (at < n && isfixed[at]) ++at;
      dst[o[i].second] = at++;
    }
  }
  for (int i = (0); i < (n); ++i) cyc[i] = -1;
  ncyc = 0;
  for (int i = (0); i < (n); ++i)
    if (cyc[i] == -1 && dst[i] != i) {
      int at = i;
      while (cyc[at] == -1) {
        cyc[at] = ncyc;
        at = dst[at];
      }
      ++ncyc;
    }
  int expect = ncyc;
  for (int i = (0); i < (ncyc); ++i) par[i] = i, sz[i] = 1;
  for (int l = 0, r = l; l < no; l = r) {
    while (r < no && o[l].first == o[r].first) ++r;
    int cur = o[l].second;
    for (int i = (l + 1); i < (r); ++i) {
      int oth = o[i].second;
      if (unite(cyc[cur], cyc[oth])) {
        swap(dst[cur], dst[oth]);
        --expect;
      }
    }
  }
  for (int i = (0); i < (n); ++i) done[i] = false;
  ans.clear();
  for (int i = (0); i < (n); ++i)
    if (!done[i] && dst[i] != i) {
      ans.push_back(vector<int>());
      int at = i;
      while (!done[at]) {
        done[at] = true;
        ans.back().push_back(at);
        at = dst[at];
      }
    }
  assert(((int)(ans).size()) == expect);
  int rem = lim - (n - nfixed);
  if (((int)(ans).size()) >= 3 && rem >= 3) {
    int cnt = min(rem, ((int)(ans).size()));
    vector<int> fst(cnt);
    for (int i = (0); i < (cnt); ++i) fst[i] = ans[i][0];
    reverse(fst.begin(), fst.end());
    vector<int> snd;
    for (int i = (0); i < (cnt); ++i) {
      snd.push_back(ans[i][0]);
      int j = (i + 1) % cnt;
      for (int k = (1); k < (((int)(ans[j]).size())); ++k)
        snd.push_back(ans[j][k]);
    }
    vector<vector<int>> nans;
    nans.push_back(fst);
    nans.push_back(snd);
    for (int i = (cnt); i < (((int)(ans).size())); ++i) nans.push_back(ans[i]);
    ans = nans;
  }
  return true;
}
bool verify(vector<vector<int>> ans) {
  vector<int> cur(n);
  for (int i = (0); i < (n); ++i) cur[i] = a[i];
  for (int i = (0); i < (((int)(ans).size())); ++i) {
    int val = cur[ans[i][0]];
    for (int j = (1); j < (((int)(ans[i]).size())); ++j)
      swap(val, cur[ans[i][j]]);
    cur[ans[i][0]] = val;
  }
  for (int i = (1); i < (((int)(cur).size())); ++i)
    if (cur[i] < cur[i - 1]) return false;
  return true;
}
void run() {
  scanf("%d%d", &n, &lim);
  for (int i = (0); i < (n); ++i) scanf("%d", &a[i]);
  if (!solve()) {
    printf("-1\n");
    return;
  }
  printf("%d\n", ((int)(ans).size()));
  for (int i = (0); i < (((int)(ans).size())); ++i) {
    printf("%d\n", ((int)(ans[i]).size()));
    for (int j = (0); j < (((int)(ans[i]).size())); ++j) {
      if (j != 0) printf(" ");
      printf("%d", ans[i][j] + 1);
    }
    puts("");
  }
  assert(verify(ans));
}
int main() {
  run();
  return 0;
}
