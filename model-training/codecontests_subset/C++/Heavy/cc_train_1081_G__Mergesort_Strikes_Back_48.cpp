#include <bits/stdc++.h>
using namespace std;
template <class T>
int chkmax(T& a, T b) {
  if (b > a) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
int chkmin(T& a, T b) {
  if (b < a) {
    a = b;
    return 1;
  }
  return 0;
}
template <class iterator>
void output(iterator begin, iterator end, ostream& out = cerr) {
  while (begin != end) {
    out << (*begin) << " ";
    begin++;
  }
  out << '\n';
}
template <class T>
void output(T x, ostream& out = cerr) {
  output(x.begin(), x.end(), out);
}
void fast_io() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
int n, k;
long long MOD;
long long power(long long a, long long deg) {
  long long res = 1;
  while (deg) {
    if ((deg & 1LL) == 0) {
      a = (a * a) % MOD;
      deg >>= 1;
    } else {
      res = (res * a) % MOD;
      deg -= 1;
    }
  }
  return res;
}
long long inv(long long a) { return power(a, MOD - 2); }
long long calc(int len1, int len2) {
  long long res = 0;
  for (int i = 2; i <= len1 + len2; ++i) {
    long long cnt = (long long)(min(len1, i - 1) - max(1, i - len2) + 1);
    res = (res + cnt * inv(i)) % MOD;
  }
  long long p_len = ((long long)len1 * (long long)len2) % MOD;
  res = ((p_len * inv(2) - res) % MOD + MOD) % MOD;
  return res;
}
long long calc(int _len) {
  long long len = (long long)(_len);
  long long x = (len * (len - 1)) % MOD;
  x = (x * inv(4)) % MOD;
  return x;
}
const int LG = 20;
signed main() {
  cin >> n >> k >> MOD;
  map<int, int> mp;
  mp[n] = 1;
  for (int i = 0; i < min(k - 1, LG); ++i) {
    map<int, int> new_mp;
    for (auto pp : mp) {
      int key = pp.first, val = pp.second;
      if (key == 1) {
        new_mp[key] += val;
      } else {
        new_mp[key / 2] += val;
        new_mp[key - key / 2] += val;
      }
    }
    mp = new_mp;
  }
  long long ans = 0;
  vector<pair<int, int> > v;
  for (auto pp : mp) {
    v.push_back(pp);
  }
  for (int i = 0; i < v.size(); ++i) {
    ans = (ans + calc(v[i].first) * v[i].second) % MOD;
  }
  for (int i = 0; i < v.size(); ++i) {
    long long cnt = ((v[i].second) * (v[i].second - 1)) % MOD;
    cnt = (cnt * inv(2)) % MOD;
    ans = (ans + calc(v[i].first, v[i].first) * cnt) % MOD;
  }
  if (v.size() >= 2) {
    long long cnt = (v[0].second * v[1].second) % MOD;
    ans = (ans + calc(v[0].first, v[1].first) * cnt) % MOD;
  }
  cout << ans << '\n';
}
