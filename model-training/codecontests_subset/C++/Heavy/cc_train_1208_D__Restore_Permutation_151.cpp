#include <bits/stdc++.h>
using namespace std;
int n, a[200005];
long long s[200005];
pair<long long, int> sg[800005];
long long lz[800005];
void Build(int nod, int l, int r) {
  sg[nod] = {0, r};
  if (l == r) return;
  int mid = (l + r) / 2;
  Build(2 * nod, l, mid);
  Build(2 * nod + 1, mid + 1, r);
}
void Sift(int nod, int l, int r) {
  sg[nod].first += lz[nod];
  if (l != r) {
    lz[2 * nod] += lz[nod];
    lz[2 * nod + 1] += lz[nod];
  }
  lz[nod] = 0;
}
void Upd(int nod, int l, int r, int lt, int rt, long long v) {
  Sift(nod, l, r);
  if (l > rt || r < lt) return;
  if (l >= lt && r <= rt) {
    lz[nod] += v;
    Sift(nod, l, r);
    return;
  }
  int mid = (l + r) / 2;
  Upd(2 * nod, l, mid, lt, rt, v);
  Upd(2 * nod + 1, mid + 1, r, lt, rt, v);
  if (sg[2 * nod + 1].first > sg[2 * nod].first)
    sg[nod] = sg[2 * nod];
  else
    sg[nod] = sg[2 * nod + 1];
}
int32_t main() {
  ios_base ::sync_with_stdio(0);
  cin.tie();
  cout.tie();
  cin >> n;
  Build(1, 1, n);
  for (int i = 1; i <= n; i++) {
    cin >> s[i];
    Upd(1, 1, n, i, i, s[i]);
  }
  for (int i = 1; i <= n; i++) {
    int p = sg[1].second;
    a[p] = i;
    Upd(1, 1, n, p, n, -i);
    Upd(1, 1, n, p, p, 1000000000000000005);
  }
  for (int i = 1; i <= n; i++) cout << a[i] << ' ';
}
