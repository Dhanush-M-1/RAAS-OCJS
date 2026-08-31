#include <bits/stdc++.h>
using namespace std;
void dout() { cerr << '\n'; }
template <typename Head, typename... Tail>
void dout(Head H, Tail... T) {
  cerr << " " << H;
  dout(T...);
}
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
const int N = 2e5 + 7;
int n, m, cnt[N];
long long sum[N];
pair<int, int> p[N];
void upd(int x, int y) {
  for (; x <= m; x |= (x + 1)) {
    cnt[x]++;
    sum[x] += y;
  }
}
int getnum(int x) {
  int res = 0;
  for (; x >= 0; x = (x & (x + 1)) - 1) {
    res += cnt[x];
  }
  return res;
}
long long getsum(int x) {
  long long res = 0;
  for (; x >= 0; x = (x & (x + 1)) - 1) {
    res += sum[x];
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL);
  cin >> n;
  vector<int> vec, v;
  for (int i = 1; i <= n; i++) {
    cin >> p[i].first;
  }
  for (int i = 1; i <= n; i++) {
    cin >> p[i].second;
    vec.push_back(p[i].second);
  }
  sort((vec).begin(), (vec).end());
  m = unique((vec).begin(), (vec).end()) - vec.begin();
  for (int i = 1; i <= n; i++) {
    p[i].second = lower_bound(vec.begin(), vec.begin() + m, p[i].second) -
                  vec.begin() + 1;
  }
  sort(p + 1, p + n + 1);
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    ans += (long long)getnum(p[i].second) * p[i].first - getsum(p[i].second);
    upd(p[i].second, p[i].first);
  }
  cout << ans;
}
