#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
struct nod {
  long long x, v;
} a[maxn];
bool cmp(nod p, nod q) { return p.x < q.x; }
int L = 0, R = 2e8, rt = 0, tot = 0;
class dsegtree {
 public:
  struct dsegnode {
    int l, r;
    long long sum1, sum2;
  } node[maxn * 50];
  void pushup(int now) {
    node[now].sum1 = node[node[now].l].sum1 + node[node[now].r].sum1;
    node[now].sum2 = node[node[now].l].sum2 + node[node[now].r].sum2;
  }
  void update(int pos, int &now, int x, int l = L, int r = R) {
    if (!now) now = ++tot;
    if (l == r) {
      node[now].sum1++;
      node[now].sum2 += x;
      return;
    }
    if (pos <= (l + r) / 2)
      update(pos, node[now].l, x, l, (l + r) / 2);
    else
      update(pos, node[now].r, x, (l + r) / 2 + 1, r);
    pushup(now);
  }
  pair<long long, long long> query(int s, int t, int now, int l = L,
                                   int r = R) {
    if (!now) return pair<long long, long long>(0, 0);
    if (s <= l && r <= t)
      return pair<long long, long long>(node[now].sum1, node[now].sum2);
    pair<long long, long long> temp;
    temp.first = temp.second = 0;
    if ((l + r) / 2 >= s) {
      pair<long long, long long> tmp = query(s, t, node[now].l, l, (l + r) / 2);
      temp.first += tmp.first;
      temp.second += tmp.second;
    }
    if ((l + r) / 2 + 1 <= t) {
      pair<long long, long long> tmp =
          query(s, t, node[now].r, (l + r) / 2 + 1, r);
      temp.first += tmp.first;
      temp.second += tmp.second;
    }
    return temp;
  }
} tree;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i].x;
  for (int i = 1; i <= n; i++) cin >> a[i].v;
  sort(a + 1, a + n + 1, cmp);
  long long res = 0, m = 1e8;
  for (int i = 1; i <= n; i++) {
    pair<long long, long long> temp = tree.query(L, a[i].v + m, rt);
    res += a[i].x * temp.first - temp.second;
    tree.update(a[i].v + m, rt, a[i].x);
  }
  cout << res << endl;
}
