#include <bits/stdc++.h>
using namespace std;
long long powmod(long long a, long long b, long long mod) {
  if (b == 0 || a == 1) {
    if (mod == 1)
      return 0;
    else
      return 1;
  }
  if (b % 2 == 0) {
    long long k = powmod(a, b / 2, mod);
    return (k * k) % mod;
  } else {
    long long k = powmod(a, b / 2, mod);
    return ((k * k) % mod * a) % mod;
  }
}
long long gcd(long long a, long long b) {
  if (a == 0) return b;
  if (b == 0) return a;
  if (a > b)
    return gcd(a % b, b);
  else
    return gcd(b % a, a);
}
long long prime(long long p) {
  for (long long i = 2; i * i <= p; i++) {
    if (p % i == 0 && i < p) return i;
  }
  return 1;
}
long long inv(long long a, long long mod) { return powmod(a, mod - 2, mod); }
long long tree[1000000];
long long sum1(long long v, long long tl, long long tr, long long l,
               long long r) {
  if (l > r) return 0;
  if (l == tl && r == tr) return tree[v];
  long long tm = (tl + tr) / 2;
  return sum1(2 * v, tl, tm, l, min(r, tm)) +
         sum1(2 * v + 1, tm + 1, tr, max(l, tm + 1), r);
}
void update(long long v, long long tl, long long tr, long long pos,
            long long new_val) {
  if (tl == tr)
    tree[v] += new_val;
  else {
    long long tm = (tl + tr) / 2;
    if (pos <= tm)
      update(v * 2, tl, tm, pos, new_val);
    else
      update(v * 2 + 1, tm + 1, tr, pos, new_val);
    tree[v] = tree[v * 2] + tree[v * 2 + 1];
  }
}
long long tree2[1000000];
long long sum2(long long v, long long tl, long long tr, long long l,
               long long r) {
  if (l > r) return 0;
  if (l == tl && r == tr) return tree2[v];
  long long tm = (tl + tr) / 2;
  return sum2(2 * v, tl, tm, l, min(r, tm)) +
         sum2(2 * v + 1, tm + 1, tr, max(l, tm + 1), r);
}
void update2(long long v, long long tl, long long tr, long long pos,
             long long new_val) {
  if (tl == tr)
    tree2[v] += new_val;
  else {
    long long tm = (tl + tr) / 2;
    if (pos <= tm)
      update2(v * 2, tl, tm, pos, new_val);
    else
      update2(v * 2 + 1, tm + 1, tr, pos, new_val);
    tree2[v] = tree2[v * 2] + tree2[v * 2 + 1];
  }
}
void solve() {
  long long a;
  cin >> a;
  vector<pair<long long, long long>> m(a);
  for (long long i = 0; i < a; i++) cin >> m[i].first;
  for (long long i = 0; i < a; i++) cin >> m[i].second;
  sort(m.begin(), m.end());
  long long ans = 0;
  long long sum = 0;
  long long col = 0;
  vector<long long> copy(a);
  for (long long i = 0; i < a; i++) copy[i] = m[i].second;
  sort(copy.begin(), copy.end());
  map<long long, long long> zamena;
  for (long long i = 0; i < a; i++) zamena[copy[i]] = i;
  for (long long i = 0; i < a; i++) m[i].second = zamena[m[i].second];
  long long cur = 0;
  for (long long i = 0; i < a; i++)
    if (m[i].second > cur) {
      update2(1, 1, 200000, m[i].second, m[i].first);
      update(1, 1, 200000, m[i].second, 1);
    }
  for (long long i = 0; i < a; i++) {
    if (m[i].second > cur) {
      ans += m[i].first * col - sum;
      ans += sum2(1LL, 1LL, 200000LL, m[i].second, 200000LL) -
             sum1(1LL, 1LL, 200000LL, m[i].second, 200000LL) * m[i].first;
      update(1, 1, 200000, m[i].second, -1);
      update2(1, 1, 200000, m[i].second, -m[i].first);
    } else {
      col++;
      sum += m[i].first;
    }
  }
  cout << ans << " ";
  return;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long tututu;
  tututu = 1;
  for (long long qwerty = 0; qwerty < tututu; qwerty++) solve();
  return 0;
}
