#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10, mod = 1e9 + 7;
const long long inf = 1e18;
int a[maxn], b[maxn], nxt[maxn];
pair<int, int> srt[maxn];
map<int, vector<int> > mp;
vector<vector<int> > ans;
int par[maxn], who[maxn];
int fnd(int u) { return par[u] < 0 ? u : par[u] = fnd(par[u]); }
void mrg(int a, int b) {
  if ((a = fnd(a)) == (b = fnd(b))) return;
  if (par[a] > par[b]) swap(a, b);
  par[a] += par[b];
  par[b] = a;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  memset(par, -1, sizeof par);
  int n, s;
  cin >> n >> s;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    srt[i] = {a[i], i};
  }
  sort(srt, srt + n);
  int N = 0;
  for (int i = 0; i < n; i++) {
    if (srt[i].first != a[i]) {
      who[N] = i;
      b[N++] = a[i];
    }
  }
  memcpy(a, b, sizeof a), n = N;
  for (int i = 0; i < n; i++) {
    srt[i] = {a[i], i};
  }
  sort(srt, srt + n);
  for (int i = 0; i < n; i++) {
    nxt[i] = i;
  }
  for (int i = 0; i < n; i++) {
    if (srt[i].first != a[i]) {
      nxt[srt[i].second] = i;
      mp[srt[i].first].push_back(srt[i].second);
    }
  }
  for (int i = 0; i < n; i++) {
    int tmp = nxt[i];
    s -= fnd(i) != fnd(tmp);
    while (fnd(tmp) != fnd(i)) {
      mrg(tmp, i);
      tmp = nxt[tmp];
      s--;
    }
  }
  for (auto &IT : mp) {
    for (int i = 0; i < int((IT.second).size()) - 1; i++) {
      int A = IT.second[i], B = IT.second[i + 1];
      if (fnd(A) != fnd(B)) swap(nxt[A], nxt[B]), mrg(A, B);
    }
  }
  if (s < 0) return cout << -1 << endl, 0;
  set<int> st;
  vector<int> vv;
  for (int i = 0; i < n; i++) {
    if (st.count(fnd(i))) continue;
    if (s == 0) continue;
    st.insert(fnd(i));
    vv.push_back(i);
    s--;
  }
  if (int((vv).size()) > 2) {
    for (int i = 1; i < int((vv).size()); i++) {
      swap(nxt[vv[0]], nxt[vv[i]]);
    }
    ans.push_back(vv);
  }
  st.clear();
  for (int i = 0; i < n; i++) {
    if (nxt[i] == i) continue;
    if (st.count(i)) continue;
    vv.clear();
    int tmp = i;
    while (st.count(tmp) == 0) {
      st.insert(tmp);
      vv.push_back(tmp);
      tmp = nxt[tmp];
    }
    ans.push_back(vv);
  }
  cout << int((ans).size()) << "\n";
  for (int i = 0; i < int((ans).size()); i++) {
    cout << int((ans[i]).size()) << "\n";
    for (int x : ans[i]) cout << who[x] + 1 << " ";
    cout << "\n";
  }
  return 0;
}
