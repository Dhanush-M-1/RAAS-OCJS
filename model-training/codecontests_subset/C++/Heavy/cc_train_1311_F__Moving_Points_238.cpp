#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = double;
const ll MODBASE = 1000000007LL;
const int MAXN = 200010;
const int MAXM = 1000;
const int MAXK = 16;
const int MAXQ = 200010;
struct Car {
  int x, v;
  Car(int x = 0, int v = 0) : x(x), v(v) {}
};
bool operator<(Car a, Car b) { return a.x < b.x; }
int n;
pair<ll, ll> t[MAXN];
Car a[MAXN];
set<int> s;
vector<int> b;
pair<ll, ll> get(int u) {
  pair<ll, ll> res = pair<ll, ll>(0, 0);
  while (u) {
    res.first += t[u].first;
    res.second += t[u].second;
    u = u - (u & (-u));
  }
  return res;
}
void update(int u, int gt, int num) {
  while (u <= 200000) {
    t[u].first += gt;
    t[u].second += num;
    u = u + (u & (-u));
  }
}
int getPos(int u) {
  int dau = 0, cuoi = int((b).size()) - 1;
  while (dau <= cuoi) {
    int mid = (dau + cuoi) >> 1;
    if (b[mid] >= u)
      cuoi = mid - 1;
    else
      dau = mid + 1;
  }
  return dau + 1;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(nullptr);
  cin >> n;
  for (int i = (1); i <= (n); i++) cin >> a[i].x;
  for (int i = (1); i <= (n); i++) cin >> a[i].v;
  sort(a + 1, a + n + 1);
  for (int i = (1); i <= (n); i++) s.insert(a[i].v);
  for (__typeof((s).begin()) it = (s).begin(); it != (s).end(); it++)
    b.push_back(*it);
  for (int i = (1); i <= (n); i++) a[i].v = getPos(a[i].v);
  ll res = 0;
  for (int i = (1); i <= (n); i++) {
    pair<ll, ll> r = get(a[i].v);
    res += (ll)a[i].x * r.second - r.first;
    update(a[i].v, a[i].x, 1);
  }
  cout << res;
  return 0;
}
