#include <bits/stdc++.h>
using namespace std;
long long n, ans, tree[800002], tree1[800002];
map<long long, long long> mp, mp1;
pair<long long, long long> a[300005];
vector<long long> v;
void inc1(int idx, int val) {
  for (int i = idx; i <= n; i += i & (-i)) {
    tree[i] += val;
  }
}
void inc2(int idx, int val) {
  for (int i = idx; i <= n; i += (i & (-i))) {
    tree1[i] += val;
  }
}
long long sum1(int idx) {
  long long pas = 0;
  for (int i = idx; i > 0; i -= i & (-i)) {
    pas += tree[i];
  }
  return pas;
}
long long sum2(int idx) {
  long long pas = 0;
  for (int i = idx; i > 0; i -= i & (-i)) {
    pas += tree1[i];
  }
  return pas;
}
int main() {
  std::ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i].first;
  }
  for (int i = 1; i <= n; i++) {
    cin >> a[i].second;
    if (!mp[a[i].second]) {
      v.push_back(a[i].second);
    }
    mp[a[i].second] = 1;
  }
  sort(v.begin(), v.end());
  for (int i = 0; i < v.size(); i++) {
    mp1[v[i]] = i + 1;
  }
  sort(a + 1, a + n + 1);
  for (int i = 1; i <= n; i++) {
    ans += sum1(mp1[a[i].second]) * a[i].first - sum2(mp1[a[i].second]);
    inc1(mp1[a[i].second], 1);
    inc2(mp1[a[i].second], a[i].first);
  }
  cout << ans << endl;
}
