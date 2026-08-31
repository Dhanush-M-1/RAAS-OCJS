#include <bits/stdc++.h>
using namespace std;
int a[1111];
class DSU {
 private:
  int* rk;
  int* p;

 public:
  DSU(size_t n) {
    rk = new int[n];
    p = new int[n];
    for (size_t i = 0; i < n; ++i) p[i] = i, rk[i] = 1;
  }
  ~DSU() {
    delete[] rk;
    delete[] p;
  }
  inline int get(int v) {
    int cur = v;
    while (cur != p[cur]) cur = p[cur];
    int ret = cur;
    cur = v;
    while (cur != p[cur]) v = p[cur], p[cur] = ret, cur = v;
    return ret;
  }
  int getrk(int v) { return rk[get(v)]; }
  void unite(int a, int b) {
    a = get(a), b = get(b);
    if (a == b) return;
    if (rk[a] < rk[b]) swap(a, b);
    p[b] = a;
    rk[a] += rk[b];
  }
};
int sum[1001][1111];
vector<int> pos;
bool subsum(int i, int j) {
  if (j == 0) return true;
  if (j > 1000 || j < 0) return false;
  if (sum[i][j] == 2)
    return true;
  else if (sum[i][j] == 1)
    return false;
  if (i == 0) {
    sum[0][j] = (pos[0] == j) ? 2 : 1;
  } else {
    sum[i][j] =
        (subsum(i - 1, j) || (pos[i] == j) || subsum(i - 1, j - pos[i])) + 1;
  }
  return sum[i][j] == 2;
}
int main() {
  cin.sync_with_stdio(false);
  int i, n, x;
  cin >> n >> x;
  for (i = 0; i < (n); ++i) cin >> a[i + 1];
  DSU d(n + 1);
  for (i = 1; i <= n; ++i) {
    if (a[i] != 0) d.unite(i, a[i]);
  }
  set<int> dif;
  for (i = 1; i <= n; ++i) dif.insert(d.get(i));
  dif.erase(dif.find(d.get(x)));
  int posx = 0;
  while (x != 0) x = a[x], posx++;
  for (set<int>::iterator it = dif.begin(); it != dif.end(); ++it)
    pos.push_back(d.getrk(*it));
  if (pos.size() == 0) {
    cout << posx << endl;
    return 0;
  }
  for (i = 0; i <= n; ++i)
    if (subsum(pos.size() - 1, i)) cout << i + posx << endl;
  return 0;
}
