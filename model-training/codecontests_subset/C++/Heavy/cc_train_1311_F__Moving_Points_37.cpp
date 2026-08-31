#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using vi = vector<int>;
using vvi = vector<vi>;
using pii = pair<int, int>;
static int MAX_N = 200000, n;
vector<ll> bitx(MAX_N + 1), bit1(MAX_N + 1);
ll sum(int i, vector<ll> &bit) {
  ll res = 0;
  while (i > 0) {
    res += bit.at(i);
    i -= i & -i;
  }
  return res;
}
void add(int i, int x, vector<ll> &bit) {
  while (i <= n) {
    bit.at(i) += x;
    i += i & -i;
  }
}
int main() {
  cin >> n;
  vi x(n);
  for (int i = 0; i < (int)(n); i++) cin >> x.at(i);
  vi v(n);
  for (int i = 0; i < (int)(n); i++) cin >> v.at(i);
  vector<pii> p;
  for (int i = 0; i < (int)(n); i++) {
    pii pi(x.at(i), v.at(i));
    p.push_back(pi);
  }
  sort(p.begin(), p.end());
  map<int, int> x2i;
  for (int i = 0; i < (int)(n); i++) x2i[p.at(i).first] = i + 1;
  sort(p.begin(), p.end(), [](pii p1, pii p2) {
    if (p1.second == p2.second)
      return p1.first < p2.first;
    else
      return p1.second < p2.second;
  });
  ll ans = 0;
  for (int j = 0; j < (int)(n); j++) {
    int x = p.at(j).first;
    int i = x2i.at(x);
    ans += x * sum(i - 1, bit1) - sum(i - 1, bitx);
    add(i, x, bitx);
    add(i, 1, bit1);
  }
  cout << ans << endl;
}
