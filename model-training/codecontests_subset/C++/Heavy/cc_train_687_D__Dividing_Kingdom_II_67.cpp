#include <bits/stdc++.h>
using namespace std;
struct st {
  bool bp;
  int l[1005], cl[1005];
  vector<tuple<int, int, int> > el;
  void rst() {
    bp = true;
    el.clear();
    for (int i = (0); i < (1000); i++) l[i] = i, cl[i] = 0;
  }
  int gl(int i) {
    if (i == l[i])
      return l[i];
    else {
      int nl = gl(l[i]);
      cl[i] ^= cl[l[i]];
      l[i] = nl;
      return nl;
    }
  }
  int gc(int i) {
    gl(i);
    return cl[i];
  }
  void adde(int i, int j, int w) {
    if (!bp) return;
    gl(i);
    gl(j);
    if (l[i] == l[j]) {
      if (cl[i] ^ cl[j] ^ 1) {
        bp = false;
        el.emplace_back(w, i, j);
      }
    } else {
      cl[l[j]] = 1 ^ cl[j] ^ cl[i];
      l[l[j]] = l[i];
      el.emplace_back(w, i, j);
    }
  }
};
st rt[4010];
int n, m, q;
tuple<int, int, int> t[600000];
long long eo[600000];
int cp[600000];
vector<int> sp;
int l[1005], r[1005];
int rtn;
void added(int i, int x, int y, int w) {
  for (i += rtn; i > 0; i /= 2) {
    rt[i].adde(x, y, w);
  }
}
vector<tuple<int, int, int> > el;
st qus;
int qu(int i, int j) {
  el.clear();
  for (i += rtn, j += rtn; i < j; i /= 2, j /= 2) {
    if (i & 1) {
      el.insert(el.end(), rt[i].el.begin(), rt[i].el.end()), i++;
    }
    if (j & 1) {
      j--;
      el.insert(el.end(), rt[j].el.begin(), rt[j].el.end());
    }
  }
  sort(el.begin(), el.end());
  reverse(el.begin(), el.end());
  qus.rst();
  for (auto ed : el) {
    int w, x, y;
    tie(w, x, y) = ed;
    qus.adde(x, y, w);
    if (!qus.bp) return w;
  }
  return -1;
}
int main() {
  scanf("%d %d %d", &n, &m, &q);
  for (int i = (0); i < (m); i++) {
    int x, y, w;
    scanf("%d %d %d", &x, &y, &w);
    x--;
    y--;
    t[i] = make_tuple(x, y, w);
    eo[i] = (1000000005 - w) * 1ll * m + i;
  }
  sort(eo, eo + m);
  for (int i = (0); i < (m); i++) eo[i] %= m;
  sp.push_back(0);
  sp.push_back(m);
  for (int i = (0); i < (q); i++) {
    scanf("%d %d", l + i, r + i);
    l[i]--;
    sp.push_back(l[i]);
    sp.push_back(r[i]);
  }
  sort(sp.begin(), sp.end());
  sp.resize(unique(sp.begin(), sp.end()) - sp.begin());
  for (int i = (0); i < (int(sp.size()) - 1); i++)
    for (int j = sp[i]; j < sp[i + 1]; j++) cp[j] = i;
  cp[m] = int(sp.size()) - 1;
  rtn = int(sp.size());
  for (int i = (0); i < (2 * rtn); i++) rt[i].rst();
  for (int i = (0); i < (m); i++) {
    int j = eo[i];
    int x, y, w;
    tie(x, y, w) = t[j];
    added(cp[j], x, y, w);
  }
  for (int i = (0); i < (q); i++) {
    printf("%d\n", qu(cp[l[i]], cp[r[i]]));
  }
}
