#include <bits/stdc++.h>
using namespace std;
struct hash_pair {
  template <class T1, class T2>
  size_t operator()(const pair<T1, T2>& p) const {
    auto hash1 = hash<T1>{}(p.first);
    auto hash2 = hash<T2>{}(p.second);
    return hash1 ^ hash2;
  }
};
bool prime[10000001];
long long P = 1000000007 - 2;
long long factorial[10000001] = {0};
long long powerFunction(long long x, long long y) {
  long long res = 1;
  long long p = 1000000007;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
void sieveFunction(long long maxLimit) {
  memset(prime, true, sizeof(prime));
  prime[0] = prime[1] = false;
  for (long long i = 2; maxLimit >= i; i++) {
    if (prime[i]) {
      for (long long j = 2 * i; maxLimit >= j; j += i) prime[j] = false;
    }
  }
}
void factorialFunction(long long maxLimit) {
  factorial[0] = 1;
  for (long long i = 1; i <= maxLimit; i++)
    factorial[i] = (factorial[i - 1] * i) % 1000000007;
  return;
}
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
vector<pair<long long, long long>> tree[800001];
vector<long long> treesum[800001];
vector<pair<long long, long long>> v;
void build(long long node, long long start, long long end) {
  if (start == end) {
    vector<pair<long long, long long>> temp;
    temp.push_back({v[start].second, v[start].first});
    tree[node] = temp;
    vector<long long> sum;
    long long s = 0;
    for (long long i = 0; tree[node].size() > i; i++) {
      s += tree[node][i].second;
      treesum[node].push_back(s);
    }
    return;
  }
  long long mid = (start + end) / 2;
  build(2 * node, start, mid);
  build(2 * node + 1, mid + 1, end);
  long long i = 0, j = 0;
  while (i < tree[2 * node].size() && j < tree[2 * node + 1].size()) {
    if (tree[2 * node][i] <= tree[2 * node + 1][j]) {
      tree[node].push_back(tree[2 * node][i]);
      i++;
    } else {
      tree[node].push_back(tree[2 * node + 1][j]);
      j++;
    }
  }
  for (long long k = i; k < tree[2 * node].size(); k++)
    tree[node].push_back(tree[2 * node][k]);
  for (long long k = j; k < tree[2 * node + 1].size(); k++)
    tree[node].push_back(tree[2 * node + 1][k]);
  long long s = 0;
  for (long long k = 0; tree[node].size() > k; k++) {
    s += tree[node][k].second;
    treesum[node].push_back(s);
  }
}
long long n;
long long SEC;
long long query(long long node, long long start, long long end, long long x) {
  if (start > x && end <= n) {
    pair<long long, long long> tem = {v[x].second, INT64_MIN};
    long long id = lower_bound(tree[node].begin(), tree[node].end(), tem) -
                   tree[node].begin();
    if (id) {
      SEC += (long long)tree[node].size() - id;
      return treesum[node].back() - treesum[node][id - 1];
    }
    SEC += tree[node].size();
    return treesum[node].back();
  }
  if (end <= x || start > n) {
    return 0;
  }
  long long mid = (start + end) / 2;
  return query(2 * node, start, mid, x) + query(2 * node + 1, mid + 1, end, x);
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n;
  long long x[n + 1], s[n + 1];
  for (long long i = 1; n >= i; i++) {
    cin >> x[i];
  }
  for (long long i = 1; n >= i; i++) {
    cin >> s[i];
  }
  v.push_back({INT64_MIN, INT64_MIN});
  for (long long i = 1; n >= i; i++) {
    v.push_back({x[i], s[i]});
  }
  sort(v.begin(), v.end());
  build(1, 1, n);
  long long ans = 0;
  for (long long i = 1; n >= i; i++) {
    SEC = 0;
    long long xx = v[i].first;
    long long temp = query(1, 1, n, i);
    temp -= xx * SEC;
    ans += temp;
  }
  cout << ans << "\n";
}
