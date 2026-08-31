#include <bits/stdc++.h>
using namespace std;
int INF = 1000000007;
string s;
int n, k, c, v, ans;
int fat[1000100], siz[1000100];
vector<int> edge[1000100];
struct node {
  int l, r, xo;
  node(int _l = 0, int _r = 0, int _xo = 0) : l(_l), r(_r), xo(_xo) {}
  int get() { return min(l, r); }
  void operator+=(node th) {
    l += th.l;
    r += th.r;
    if (l > INF) l = INF;
    if (r > INF) r = INF;
  }
} val[1000100];
pair<int, int> uu, vv;
pair<int, int> trace(int x) {
  if (fat[x] < 0) return make_pair(x, 0);
  pair<int, int> pp = trace(fat[x]);
  fat[x] = pp.first;
  val[x].xo ^= pp.second;
  return make_pair(fat[x], val[x].xo);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n >> k >> s;
  s = "?" + s;
  for (int i = 1; i <= k; i++) {
    fat[i] = -1;
    siz[i] = 1;
    val[i] = node(1, 0, 0);
    cin >> c;
    for (int j = 1; j <= c; j++) {
      cin >> v;
      edge[v].push_back(i);
    }
  }
  int ans = 0;
  int id;
  for (int i = 1; i <= n; i++) {
    int tp = (s[i] - '0') ^ 1;
    if (edge[i].size() == 1) {
      id = edge[i][0];
      uu = trace(id);
      ans -= val[uu.first].get();
      val[uu.first] += node((tp == uu.second) * INF, (tp != uu.second) * INF);
      ans += val[uu.first].get();
    } else if (edge[i].size() == 2) {
      id = edge[i][0];
      uu = trace(id);
      id = edge[i][1];
      vv = trace(id);
      if (uu.first != vv.first) {
        ans -= (val[uu.first].get() + val[vv.first].get());
        if (siz[uu.first] > siz[vv.first]) swap(uu, vv);
        if (uu.second ^ vv.second ^ tp) {
          swap(val[vv.first].l, val[vv.first].r);
          val[vv.first].xo = 1;
        }
        siz[uu.first] += siz[vv.first];
        fat[vv.first] = uu.first;
        val[uu.first] += val[vv.first];
        ans += val[uu.first].get();
      }
    }
    cout << ans << endl;
  }
  return 0;
}
