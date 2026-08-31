#include <bits/stdc++.h>
using namespace std;
void err(istream_iterator<string> it) {}
template <typename T, typename... Args>
void err(istream_iterator<string> it, T a, Args... args) {
  cerr << *it << " = " << a << '\n';
  err(++it, args...);
}
long long powMod(long long x, long long y) {
  long long p = 1;
  while (y) {
    if (y % 2) {
      p = (p * x) % ((long long)1e9 + 7);
    }
    y /= 2;
    x = (x * x) % ((long long)1e9 + 7);
  }
  return p;
}
long long CpowMod(long long x, long long y, long long w) {
  long long p = 1;
  while (y) {
    if (y % 2) {
      p = (p * x) % w;
    }
    y /= 2;
    x = (x * x) % w;
  }
  return p;
}
long long invMod(long long x) { return powMod(x, ((long long)1e9 + 7) - 2); }
long long CinvMod(long long x, long long w) { return CpowMod(x, w - 2, w); }
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
void solve() {
  long long n, k;
  cin >> n >> k;
  multiset<long long> q1, q2, qq, q3, q4;
  for (int i = 0; i <= n - 1; i++) {
    long long x, y, t;
    cin >> t >> x >> y;
    if (x == 1 && y == 1) {
      qq.insert(t);
    } else if (x == 1) {
      q1.insert(t);
    } else if (y == 1) {
      q2.insert(t);
    }
  }
  if ((long long)qq.size() + (long long)q1.size() < k ||
      (long long)qq.size() + (long long)q2.size() < k) {
    cout << -1;
    return;
  }
  long long mb = min((long long)qq.size() - 1, k - 1);
  for (int i = 0; i <= mb; i++) {
    auto it = *qq.begin();
    q3.insert(it);
    qq.erase(qq.find(it));
  }
  long long ap = k - (long long)q3.size();
  {};
  for (int i = 0; i <= ap - 1; i++) {
    auto it1 = *q1.begin();
    auto it2 = *q2.begin();
    q4.insert(it1);
    q4.insert(it2);
    q1.erase(q1.find(it1));
    q2.erase(q2.find(it2));
  }
  while ((long long)q3.size() && (long long)q1.size() && (long long)q2.size()) {
    auto it1 = *q1.begin();
    auto it2 = *q2.begin();
    auto it3 = *q3.rbegin();
    if (it1 + it2 < it3) {
      q4.insert(it1);
      q4.insert(it2);
      q1.erase(q1.find(it1));
      q2.erase(q2.find(it2));
      q3.erase(q3.find(it3));
    } else {
      break;
    }
  }
  long long sum = 0;
  for (auto &it : q3) {
    sum += it;
  }
  for (auto &it : q4) {
    sum += it;
  }
  cout << sum;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cout.precision(20);
  solve();
  return 0;
}
