#include <bits/stdc++.h>
using namespace std;
map<int, int> mp;
set<int> st;
set<int>::iterator it;
pair<int, int> arr[200005];
pair<long long, long long> tree[4 * 200005];
void update(int node, int b, int e, int i, long long v) {
  if (b > i || e < i) return;
  if (b == e && b == i) {
    tree[node].first += v;
    tree[node].second++;
    return;
  }
  int left = 2 * node, right = left + 1, mid = (b + e) / 2;
  update(left, b, mid, i, v);
  update(right, mid + 1, e, i, v);
  tree[node].first = tree[left].first + tree[right].first;
  tree[node].second = tree[left].second + tree[right].second;
}
pair<long long, long long> query(int node, int b, int e, int l, int r) {
  if (b > r || e < l) return make_pair(0ll, 0ll);
  if (b >= l && e <= r) return tree[node];
  int left = 2 * node, right = left + 1, mid = (b + e) / 2;
  pair<long long, long long> ret;
  pair<long long, long long> p = query(left, b, mid, l, r);
  pair<long long, long long> q = query(right, mid + 1, e, l, r);
  ret.first = p.first + q.first;
  ret.second = p.second + q.second;
  return ret;
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &arr[i].first);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &arr[i].second);
    st.insert(arr[i].second);
  }
  int N = 1;
  for (it = st.begin(); it != st.end(); it++) {
    mp[*it] = ++N;
  }
  for (int i = 1; i <= n; i++) arr[i].second = mp[arr[i].second];
  sort(arr + 1, arr + n + 1);
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    pair<long long, long long> z = query(1, 1, N, 1, arr[i].second);
    long long p = ((long long)arr[i].first) * z.second;
    p -= z.first;
    ans += p;
    update(1, 1, N, arr[i].second, arr[i].first);
  }
  cout << ans << endl;
}
