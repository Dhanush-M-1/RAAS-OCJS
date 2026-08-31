#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e6 + 69, INF = 1e9 + 85, MOD = 1e9 + 7;
int n, k, a, b, q, arr[MAXN], seg[2][MAXN << 2];
void update(int indx, int val, int type, int l = 0, int r = n, int id = 1) {
  if (indx < l or indx >= r) return;
  if (r - l == 1) {
    seg[type][id] = val;
    return;
  }
  int mid = (l + r) >> 1;
  update(indx, val, type, l, mid, id << 1 | 0);
  update(indx, val, type, mid, r, id << 1 | 1);
  seg[type][id] = seg[type][id << 1 | 0] + seg[type][id << 1 | 1];
}
int get(int st, int en, int type, int l = 0, int r = n, int id = 1) {
  if (l >= en or r <= st) return 0;
  if (l >= st and r <= en) return seg[type][id];
  int mid = (l + r) >> 1;
  return get(st, en, type, l, mid, id << 1 | 0) +
         get(st, en, type, mid, r, id << 1 | 1);
}
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    int type, day, order;
    cin >> type;
    if (type == 1) {
      cin >> day >> order;
      arr[day] += order;
      update(day - 1, min(arr[day], a), 0);
      update(day - 1, min(arr[day], b), 1);
    } else {
      cin >> day;
      cout << get(0, day - 1, 1) + get(day + k - 1, n, 0) << "\n";
    }
  }
}
