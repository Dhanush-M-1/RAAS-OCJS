#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 7;
int n;
long long ans = 0;
vector<long long> T1(N, 0), T2(N, 0);
pair<int, int> a[N];
vector<int> b;
void update(vector<long long>& T, int x, long long v) {
  for (; x <= (int)b.size(); x += (x & (-x))) T[x] += v;
}
long long get(const vector<long long>& T, int x) {
  long long res = 0;
  for (; x; x -= (x & (-x))) res += T[x];
  return res;
}
int main() {
  ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  cin >> n;
  for (int i = (0); i < (n); i++) cin >> a[i].first;
  for (int i = (0); i < (n); i++) {
    cin >> a[i].second;
    b.push_back(a[i].second);
  }
  sort(a, a + n);
  sort(b.begin(), b.end());
  b.resize(unique(b.begin(), b.end()) - b.begin());
  int vt = lower_bound(b.begin(), b.end(), a[0].second) - b.begin() + 1;
  update(T1, vt, 1ll * a[0].first);
  update(T2, vt, 1);
  for (int i = (1); i < (n); i++) {
    vt = lower_bound(b.begin(), b.end(), a[i].second) - b.begin() + 1;
    ans += get(T2, vt) * a[i].first - get(T1, vt);
    update(T1, vt, 1ll * a[i].first);
    update(T2, vt, 1);
  }
  cout << ans;
  return 0;
}
