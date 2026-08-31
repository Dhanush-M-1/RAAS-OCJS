#include <bits/stdc++.h>
using namespace std;
int n, lo[(long long)(2e5 + 5) * 4], hi[(long long)(2e5 + 5) * 4],
    ans[(long long)(2e5 + 5)];
long long base[(long long)(2e5 + 5)], delta[(long long)(2e5 + 5) * 4];
pair<long long, int> mn[(long long)(2e5 + 5) * 4];
void update(int i);
void ini(int i, int a, int b) {
  lo[i] = a;
  hi[i] = b;
  if (a == b) {
    mn[i].first = base[a];
    mn[i].second = a;
    return;
  }
  int mid = (a + b) / 2;
  ini(2 * i, a, mid);
  ini(2 * i + 1, mid + 1, b);
  update(i);
}
void update(int i) {
  if (mn[i * 2].first + delta[i * 2] == mn[i * 2 + 1].first + delta[i * 2 + 1])
    mn[i] = mn[i * 2 + 1], mn[i].first += delta[i * 2 + 1];
  else if (mn[i * 2].first + delta[i * 2] <
           mn[i * 2 + 1].first + delta[i * 2 + 1])
    mn[i] = mn[i * 2], mn[i].first += delta[i * 2];
  else
    mn[i] = mn[i * 2 + 1], mn[i].first += delta[i * 2 + 1];
}
void prop(int i) {
  delta[i * 2] += delta[i];
  delta[i * 2 + 1] += delta[i];
  delta[i] = 0;
}
void inc(int i, int a, int b, long long val) {
  if (lo[i] >= a && hi[i] <= b) {
    delta[i] += val;
    return;
  }
  if (lo[i] > b || hi[i] < a) return;
  prop(i);
  inc(i * 2, a, b, val);
  inc(i * 2 + 1, a, b, val);
  update(i);
}
void change(int i, int loc) {
  if (lo[i] == loc && hi[i] == loc) {
    mn[i].first = 1e18, mn[i].second = -1;
    delta[i] = 1e18;
    return;
  }
  if (lo[i] > loc || hi[i] < loc) return;
  prop(i);
  change(i * 2, loc);
  change(i * 2 + 1, loc);
  update(i);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr), cout.tie(nullptr);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> base[i];
  ini(1, 1, n);
  for (int i = 1; i <= n; i++) {
    pair<long long, int> loc = mn[1];
    change(1, loc.second);
    inc(1, loc.second + 1, n, -1 * i);
    ans[loc.second] = i;
  }
  for (int i = 1; i <= n; i++) {
    cout << ans[i];
    if (i != n) cout << " ";
  }
  return 0;
}
