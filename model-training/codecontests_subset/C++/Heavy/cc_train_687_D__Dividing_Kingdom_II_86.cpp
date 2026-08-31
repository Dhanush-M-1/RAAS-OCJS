#include <bits/stdc++.h>
using namespace std;
int n, m, q;
vector<pair<pair<int, int>, pair<int, int> > > edgeTotal;
int p[1111], len[1111], ran[1111];
bool cmp(const pair<pair<int, int>, pair<int, int> > &a,
         const pair<pair<int, int>, pair<int, int> > &b) {
  return a.first.first > b.first.first;
}
int find_set(int x) {
  if (x == p[x]) return x;
  int y = find_set(p[x]);
  len[x] ^= len[p[x]];
  return p[x] = y;
}
void merge_set(int x, int y) {
  int px = find_set(x);
  int py = find_set(y);
  if (ran[px] > ran[py]) swap(px, py);
  p[px] = py;
  len[px] ^= len[x] ^ len[y] ^ 1;
  if (ran[px] == ran[py]) ran[py]++;
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> m >> q;
  for (int i = 1; i <= m; i++) {
    int a, b, w;
    cin >> a >> b >> w;
    edgeTotal.push_back(make_pair(make_pair(w, i), make_pair(a, b)));
  }
  sort(edgeTotal.begin(), edgeTotal.end(), cmp);
  for (int i = 0; i < q; i++) {
    int l, r;
    cin >> l >> r;
    for (int j = 1; j <= n; j++) {
      p[j] = j;
      len[j] = 0;
      ran[j] = 0;
    }
    int ans = -1;
    for (int j = 0; j < edgeTotal.size(); j++) {
      if (edgeTotal[j].first.second > r || edgeTotal[j].first.second < l)
        continue;
      int w = edgeTotal[j].first.first, a = edgeTotal[j].second.first,
          b = edgeTotal[j].second.second;
      if (find_set(a) != find_set(b)) {
        merge_set(a, b);
      } else {
        if (abs(len[a] - len[b]) % 2 == 0) {
          ans = w;
          break;
        }
      }
    }
    cout << ans << endl;
  }
  return 0;
}
