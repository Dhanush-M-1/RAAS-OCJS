#include <bits/stdc++.h>
using namespace std;
long long int tree[800005], sree[800005];
struct sc {
  long long int a, b;
};
bool comp(sc x, sc y) {
  if (x.a < y.a) return 1;
  return 0;
}
void update(long long int node, long long int s, long long int e,
            long long int ind, long long int val) {
  if (s == e) {
    tree[node] += val;
    sree[node] += 1;
  } else {
    long long int m = (s + e) / 2;
    if (s <= ind && ind <= m)
      update(2 * node, s, m, ind, val);
    else
      update(2 * node + 1, m + 1, e, ind, val);
    tree[node] = tree[2 * node] + tree[2 * node + 1];
    sree[node] = sree[2 * node] + sree[2 * node + 1];
  }
}
long long int q_sum(long long int node, long long int s, long long int e,
                    long long int l, long long int r) {
  if (r < s || e < l) return 0;
  if (l <= s && e <= r) return tree[node];
  long long int m = (s + e) / 2;
  long long int ans1 = q_sum(2 * node, s, m, l, r);
  long long int ans2 = q_sum(2 * node + 1, m + 1, e, l, r);
  long long int ans = ans1 + ans2;
  return ans;
}
long long int q_cnt(long long int node, long long int s, long long int e,
                    long long int l, long long int r) {
  if (r < s || e < l) return 0;
  if (l <= s && e <= r) return sree[node];
  long long int m = (s + e) / 2;
  long long int ans1 = q_cnt(2 * node, s, m, l, r);
  long long int ans2 = q_cnt(2 * node + 1, m + 1, e, l, r);
  long long int ans = ans1 + ans2;
  return ans;
}
int main() {
  long long int n, i, j, ans = 0;
  cin >> n;
  sc e[n + 1];
  long long int c[n + 1];
  for (i = 1; i <= n; ++i) {
    cin >> e[i].a;
  }
  for (i = 1; i <= n; ++i) {
    cin >> e[i].b;
    c[i] = e[i].b;
  }
  sort(e + 1, e + n + 1, comp);
  sort(c + 1, c + n + 1);
  long long int l = 1;
  map<long long int, long long int> mp;
  for (i = 1; i <= n; ++i)
    if (mp.find(c[i]) == mp.end()) mp[c[i]] = l++;
  for (i = n; i >= 1; --i) {
    update(1, 1, n, mp[e[i].b], e[i].a);
    ans = ans + (q_sum(1, 1, n, mp[e[i].b], l) -
                 (q_cnt(1, 1, n, mp[e[i].b], l) * e[i].a));
  }
  cout << ans << "\n";
  return 0;
}
