#include <bits/stdc++.h>
using namespace std;
int cnt[400000], cnt1[400000], a[400000], b[400000], number[800000];
map<int, int> mp;
vector<pair<int, int> > v;
int q(int ind) {
  int sum = 0;
  while (ind > 0) {
    sum += number[ind];
    ind -= ind & (-ind);
  }
  return sum;
}
void u(int ind, int n) {
  int sum = 0;
  while (ind <= n) {
    number[ind]++;
    ind += ind & (-ind);
  }
}
int main() {
  {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
  };
  int i, j, n, m, k, l = 0, h, t;
  long long ans = 0;
  cin >> n;
  for (i = 1; i <= n; i++) cin >> a[i];
  for (i = 1; i <= n; i++) {
    cin >> b[i];
    v.push_back({a[i], b[i]});
  }
  sort(b + 1, b + n + 1);
  j = 1;
  for (i = 1; i <= n; i++) {
    if (!mp[b[i]]) mp[b[i]] = j++;
    cnt[mp[b[i]]]++;
  }
  for (i = 1; i < j; i++) b[i] = b[i - 1] + cnt[i - 1];
  sort(v.begin(), v.end());
  for (i = 0; i < n; i++) {
    k = v[i].first;
    l = v[i].second;
    l = mp[l];
    u(l, j - 1);
    cnt1[l]++;
    m = q(l);
    h = n - i - 1 - (cnt[l] + b[l] - m) + cnt[l] - cnt1[l];
    ans += (long long)k * (m - 1 - h);
  }
  cout << ans << endl;
  return 0;
}
