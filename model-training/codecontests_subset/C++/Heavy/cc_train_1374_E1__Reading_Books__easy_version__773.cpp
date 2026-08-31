#include <bits/stdc++.h>
#pragma GCC target("avx")
#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using std::cin;
using std::cout;
using std::lower_bound;
using std::string;
using std::upper_bound;
using std::vector;
using vi = vector<long long>;
using vii = vector<vi>;
using pii = std::pair<long long, long long>;
constexpr long long MOD = 1e9 + 7;
constexpr long long MAX = 1e7;
constexpr long long INF = (1ll << 60);
template <class T>
class prique : public std::priority_queue<T, std::vector<T>, std::greater<T>> {
};
template <typename T>
struct Segment_tree {
  long long N;
  T mem;
  vector<T> node;
  Segment_tree(vector<T> &X, T m) : mem(m) {
    long long sz = X.size();
    N = 1;
    while (N < sz) N *= 2;
    node.resize(2 * N - 1, mem);
    for (long long i = (long long)(0); i < (long long)(sz); i++)
      node[N - 1 + i] = X[i];
    for (long long i = (long long)(N - 2); (long long)(0) <= i; i--) {
      node[i] = Compare(node[i * 2 + 1], node[i * 2 + 2]);
    }
  }
  T Compare(T &A, T &B) { return std::min(A, B); }
  void update(long long X, T val) {
    X += N - 1;
    node[X] = val;
    while (X > 0) {
      X = (X - 1) / 2;
      node[X] = Compare(node[X * 2 + 1], node[X * 2 + 2]);
    }
  }
  T Query(long long a, long long b, long long now, long long l, long long r) {
    if (r < 0) r = N;
    if (r <= a || b <= l) return mem;
    if (a <= l && r <= b) return node[now];
    auto vl = Query(a, b, now * 2 + 1, l, (l + r) / 2),
         vr = Query(a, b, now * 2 + 2, (l + r) / 2, r);
    return Compare(vl, vr);
  }
};
struct Binary_indexed_tree {
  int N;
  vi bit;
  Binary_indexed_tree(int n) : N(n) { bit.resize(N + 1, 0); }
  void add(int x, int a) {
    for (x; x <= N; x += (x & -x)) bit[x] += a;
  }
  long long sum(int x) {
    long long ret = 0;
    for (x; x > 0; x -= (x & -x)) ret += bit[x];
    return ret;
  }
  long long lower_bound(long long X) {
    if (sum(N) < X) return -1;
    long long ret = 0, memo = 1, sum = 0;
    while (memo * 2 <= N) memo *= 2;
    while (memo > 0) {
      if (memo + ret <= N && sum + bit[memo + ret] < X) {
        sum += bit[memo + ret];
        ret += memo;
      }
      memo /= 2;
    }
    return ret + 1;
  }
};
struct Union_Find {
  long long N;
  vi par;
  vi siz;
  Union_Find(int n) : N(n) {
    par.resize(N);
    siz.resize(N, 1);
    for (long long i = (long long)(0); i < (long long)(N); i++) par[i] = i;
  }
  long long root(long long X) {
    if (par[X] == X) return X;
    return par[X] = root(par[X]);
  }
  bool same(long long X, long long Y) { return root(X) == root(Y); }
  void unite(long long X, long long Y) {
    X = root(X);
    Y = root(Y);
    if (X == Y) return;
    par[X] = Y;
    siz[Y] += siz[X];
    siz[X] = 0;
  }
  long long size(long long X) { return siz[root(X)]; }
};
long long modpow(long long a, long long n, long long mod) {
  long long res = 1;
  while (n > 0) {
    if (n & 1) res = res * a % mod;
    a = a * a % mod;
    n >>= 1;
  }
  return res;
}
vi fac, finv, inv;
void COMinit() {
  fac.resize(MAX);
  finv.resize(MAX);
  inv.resize(MAX);
  fac[0] = fac[1] = 1;
  finv[0] = finv[1] = 1;
  inv[1] = 1;
  for (int i = 2; i < MAX; i++) {
    fac[i] = fac[i - 1] * i % MOD;
    inv[i] = MOD - inv[MOD % i] * (MOD / i) % MOD;
    finv[i] = finv[i - 1] * inv[i] % MOD;
  }
}
long long COM(long long n, long long r) {
  if (n < r || n < 0 || r < 0) return 0;
  return fac[n] * finv[r] % MOD * finv[n - r] % MOD;
}
long long modinv(long long a, long long m) {
  long long b = m, u = 1, v = 0;
  while (b) {
    long long t = a / b;
    a -= t * b;
    std::swap(a, b);
    u -= t * v;
    std::swap(u, v);
  }
  u %= m;
  if (u < 0) u += m;
  return u;
}
int main() {
  std::ios::sync_with_stdio(false);
  std::cin.tie(nullptr);
  long long N, K, M;
  cin >> N >> M >> K;
  vii memo(4);
  vector<std::set<pii>> p(4);
  for (long long i = (long long)(0); i < (long long)(N); i++) {
    long long T, A, B;
    cin >> T >> A >> B;
    long long sum = 0;
    if (A) sum += 1;
    if (B) sum += 2;
    memo[sum].emplace_back(T);
    p[sum].insert(std::make_pair(T, i));
  }
  for (long long i = (long long)(0); i < (long long)(4); i++)
    sort((memo[i]).begin(), (memo[i]).end());
  std::tuple<long long, long long, long long, long long> ans =
      std::make_tuple(INF, INF, INF, INF);
  vii sum(4, vi(1));
  for (long long i = (long long)(0); i < (long long)(4); i++) {
    for (long long j = (long long)(0); j < (long long)(memo[i].size()); j++)
      sum[i].emplace_back(sum[i][j] + memo[i][j]);
  }
  for (long long i = (long long)(0); i <= (long long)(memo[3].size()); i++) {
    if (K < i) break;
    vi max(4);
    if (K - i > (long long)memo[1].size() || K - i > (long long)memo[2].size())
      continue;
    max[3] = i;
    max[2] = max[1] = K - i;
    if (max[1] + max[2] + max[3] > M) continue;
    long long left = 0, right = INF;
    while (left + 1 < right) {
      long long mid = (left + right) / 2;
      long long cnt = 0;
      for (long long j = (long long)(0); j < (long long)(4); j++) {
        cnt += std::max(
            (long long)distance(memo[j].begin(),
                                upper_bound((memo[j]).begin(), (memo[j]).end(),
                                            (long long)(mid))),
            max[j]);
      }
      if (cnt >= M)
        right = mid;
      else
        left = mid;
    }
    long long Sum = 0, cnt = 0;
    for (long long j = (long long)(0); j < (long long)(4); j++) {
      long long X = std::max(
          (long long)distance(memo[j].begin(),
                              upper_bound((memo[j]).begin(), (memo[j]).end(),
                                          (long long)(right))),
          max[j]);
      cnt += X;
      Sum += sum[j][X];
    }
    Sum -= right * (cnt - M);
    ans = std::min(ans, std::make_tuple(Sum, i, right, cnt - M));
  }
  long long Ans, X, Y, differ;
  std::tie(Ans, X, Y, differ) = ans;
  if (Ans == INF) {
    cout << -1 << "\n";
    return 0;
  }
  cout << Ans << "\n";
  vi max(4);
  max[3] = X;
  max[2] = max[1] = K - X;
  std::set<long long> ind;
  for (long long i = (long long)(0); i < (long long)(4); i++) {
    long long Z = std::max(
        max[i],
        (long long)distance(
            memo[i].begin(),
            upper_bound((memo[i]).begin(), (memo[i]).end(), (long long)(Y))));
    auto it = p[i].begin();
    for (long long j = (long long)(0); j < (long long)(Z); j++) {
      ind.insert((*it).second);
      it++;
    }
  }
  while (differ > 0) {
    for (long long i = (long long)(0); i < (long long)(4); i++) {
      long long Z = std::max(
          max[i],
          (long long)distance(
              memo[i].begin(),
              upper_bound((memo[i]).begin(), (memo[i]).end(), (long long)(Y))));
      auto it = p[i].begin();
      for (long long j = (long long)(0); j < (long long)(Z); j++) {
        if (j >= max[i] && (*it).first == Y) {
          differ--;
          ind.erase((*it).second);
          if (differ == 0) goto XYZ;
        }
        it++;
      }
    }
  XYZ:;
  }
  for (auto p : ind) cout << p + 1 << " ";
  cout << "\n";
}
