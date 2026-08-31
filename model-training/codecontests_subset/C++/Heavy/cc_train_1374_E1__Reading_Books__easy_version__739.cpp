#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cout << name << " : " << arg1 << "\n";
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cout.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
inline long long sbt(long long x) { return __builtin_popcountll(x); }
inline long long iceil(long double a) { return (long long)(ceil(a)); }
inline long long abceil(long long a, long long b) { return (a + b - 1) / b; }
inline long long mul(long long a, long long b,
                     long long m = (long long)(1e9 + 7)) {
  return ((a % m) * (b % m)) % m;
}
inline long long add(long long a, long long b,
                     long long m = (long long)(1e9 + 7)) {
  return (a + b) % m;
}
inline long long sub(long long a, long long b,
                     long long m = (long long)(1e9 + 7)) {
  return (a - b + m) % m;
}
long long fastpow(long long a, long long b,
                  long long m = (long long)(1e9 + 7)) {
  long long res = 1;
  while (b > 0) {
    if (b & 1) res = mul(res, a, m);
    a = mul(a, a, m);
    b >>= 1;
  }
  return res;
}
long long modinv(long long a, long long m = (long long)(1e9 + 7)) {
  return fastpow(a, m - 2, m);
}
void get_ac() {
  long long a, b, c, n, m, k;
  cin >> n >> m >> k;
  vector<pair<long long, long long> > alice, bob, both, none;
  for (auto i = 1; i <= n; i++) {
    cin >> a >> b >> c;
    if (b & c)
      both.push_back({a, i});
    else if (b)
      alice.push_back({a, i});
    else if (c)
      bob.push_back({a, i});
    else
      none.push_back({a, i});
  }
  long long ans = 0;
  set<long long> indices;
  sort(bob.begin(), bob.end());
  sort(alice.begin(), alice.end());
  sort(both.begin(), both.end());
  sort(none.begin(), none.end());
  for (long i = 0; i < min(k, (long long)(both.size())); i++) {
    ans += both[i].first;
    indices.insert(both[i].second);
  }
  for (long i = 0; i < min({(long long)(alice.size()), (long long)(bob.size()),
                            max(k - (long long)(both.size()), 0LL)});
       i++) {
    ans += alice[i].first + bob[i].first;
    indices.insert(alice[i].second);
    indices.insert(bob[i].second);
  }
  long long inone = 0,
            ibob = min({(long long)(alice.size()), (long long)(bob.size()),
                        max(k - (long long)(both.size()), 0LL)}),
            ialice = min({(long long)(alice.size()), (long long)(bob.size()),
                          max(k - (long long)(both.size()), 0LL)}),
            iboth = min(k, (long long)(both.size()));
  long long nboth = (long long)(both.size()),
            nalice = (long long)(alice.size()), nbob = (long long)(bob.size()),
            nnone = (long long)(none.size());
  if ((iboth + ialice) < k || (long long)(indices.size()) > m) {
    cout << -1;
    return;
  }
  while ((long long)(indices.size()) < m) {
    vector<pair<long long, long long> > candidate;
    if (inone < nnone) candidate.push_back({none[inone].first, 0});
    if (ialice < nalice) candidate.push_back({alice[ialice].first, 2});
    if (ibob < nbob) candidate.push_back({bob[ibob].first, 1});
    if (iboth < nboth) candidate.push_back({both[iboth].first, 3});
    if (iboth > 0 && ialice < nalice && ibob < nbob)
      candidate.push_back(
          {alice[ialice].first + bob[ibob].first - both[iboth - 1].first, 4});
    sort(candidate.begin(), candidate.end());
    if ((long long)(candidate.size()) == 0) break;
    long long f = candidate[0].second;
    if (f == 0) {
      ans += none[inone].first;
      indices.insert(none[inone].second);
      inone++;
    } else if (f == 1) {
      ans += bob[ibob].first;
      indices.insert(bob[ibob].second);
      ibob++;
    } else if (f == 2) {
      ans += alice[ialice].first;
      indices.insert(alice[ialice].second);
      ialice++;
    } else if (f == 3) {
      ans += both[iboth].first;
      indices.insert(both[iboth].second);
      iboth++;
    } else {
      ans += alice[ialice].first + bob[ibob].first - both[iboth - 1].first;
      indices.erase(both[iboth - 1].second);
      indices.insert(alice[ialice].second);
      indices.insert(bob[ibob].second);
      ialice++;
      ibob++;
      iboth--;
    }
  }
  if ((long long)(indices.size()) < m) {
    cout << -1;
    return;
  }
  cout << ans;
  cout << "\n";
  for (auto i : indices) {
    cout << i << " ";
  }
}
int main() {
  cin.sync_with_stdio(false);
  cout.sync_with_stdio(false);
  cin.tie(NULL);
  {
    get_ac();
    cout << "\n";
  }
  return 0;
}
