#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void out(T t) {
  cout << t << "\n";
}
template <class T, class... Ts>
inline void out(T t, Ts... ts) {
  cout << t << " ";
  out(ts...);
}
template <class T>
inline bool CHMIN(T &a, T b) {
  if (a > b) {
    a = b;
    return true;
  }
  return false;
}
template <class T>
inline bool CHMAX(T &a, T b) {
  if (a < b) {
    a = b;
    return true;
  }
  return false;
}
constexpr long long INF = 1e18;
template <typename T>
struct SegmentTree {
  using F = function<T(T, T)>;
  long long n;
  F f;
  T ti;
  vector<T> dat;
  SegmentTree() {}
  SegmentTree(F f, T ti) : f(f), ti(ti) {}
  void init(long long n_) {
    n = 1;
    while (n < n_) n <<= 1;
    dat.assign(n << 1, ti);
  }
  void build(const vector<T> &v) {
    long long n_ = v.size();
    init(n_);
    for (long long i = 0; i < n_; i++) dat[n + i] = v[i];
    for (long long i = n - 1; i; i--)
      dat[i] = f(dat[(i << 1) | 0], dat[(i << 1) | 1]);
  }
  void set_val(long long k, T x) {
    dat[k += n] = x;
    while (k >>= 1) dat[k] = f(dat[(k << 1) | 0], dat[(k << 1) | 1]);
  }
  T query(long long a, long long b) {
    if (a >= b) return ti;
    T vl = ti, vr = ti;
    for (long long l = a + n, r = b + n; l < r; l >>= 1, r >>= 1) {
      if (l & 1) vl = f(vl, dat[l++]);
      if (r & 1) vr = f(dat[--r], vr);
    }
    return f(vl, vr);
  }
  template <typename C>
  long long find(long long st, C &check, T &acc, long long k, long long l,
                 long long r) {
    if (l + 1 == r) {
      acc = f(acc, dat[k]);
      return check(acc) ? k - n : -1;
    }
    long long m = (l + r) >> 1;
    if (m <= st) return find(st, check, acc, (k << 1) | 1, m, r);
    if (st <= l && !check(f(acc, dat[k]))) {
      acc = f(acc, dat[k]);
      return -1;
    }
    long long vl = find(st, check, acc, (k << 1) | 0, l, m);
    if (~vl) return vl;
    return find(st, check, acc, (k << 1) | 1, m, r);
  }
  template <typename C>
  long long find(long long st, C &check) {
    T acc = ti;
    return find(st, check, acc, 1, 0, n);
  }
};
void solve() {
  long long N, M, K;
  cin >> N >> M >> K;
  vector<long long> t(N), a(N), b(N);
  for (long long i = 0; i < (long long)N; ++i) {
    cin >> t[i] >> a[i] >> b[i];
  }
  vector<pair<long long, long long>> ab, A, B;
  vector<tuple<long long, long long, long long>> others;
  for (long long i = 0; i < (long long)N; ++i) {
    if (a[i] && b[i]) {
      ab.emplace_back(t[i], i);
      continue;
    }
    long long state = a[i] * 2 + b[i];
    others.emplace_back(t[i], state, i);
  }
  sort(ab.begin(), ab.end());
  sort(others.begin(), others.end());
  for (long long i = 0; i < (long long)others.size(); ++i) {
    auto [val, state, idx] = others[i];
    if (state == 2) {
      A.emplace_back(val, i);
    } else if (state == 1) {
      B.emplace_back(val, i);
    }
  }
  vector<long long> abs(ab.size() + 1);
  for (long long i = 0; i < (long long)ab.size(); ++i) {
    abs[i + 1] += abs[i] + ab[i].first;
  }
  SegmentTree<pair<long long, long long>> seg(
      [](pair<long long, long long> a, pair<long long, long long> b) {
        return pair<long long, long long>(a.first + b.first,
                                          a.second + b.second);
      },
      {0ll, 0ll});
  seg.build(vector<pair<long long, long long>>(others.size()));
  for (long long i = 0; i < (long long)others.size(); ++i) {
    seg.set_val(i, {get<0>(others[i]), 1ll});
  }
  long long sum = 0;
  long long ans = INF;
  for (long long i = 0;
       i < (long long)min((long long)min(A.size(), B.size()) + 1, K + 1); ++i) {
    if (i) {
      sum += get<0>(A[i - 1]) + get<0>(B[i - 1]);
      seg.set_val(get<1>(A[i - 1]), {0ll, 0ll});
      seg.set_val(get<1>(B[i - 1]), {0ll, 0ll});
    }
    if (ab.size() < K - i) continue;
    long long shortage = M - i * 2 - (K - i);
    if (shortage < 0) continue;
    long long absNum = K - i;
    auto check = [&](pair<long long, long long> x) {
      return x.second > shortage;
    };
    long long idx = seg.find(0, check);
    if (seg.query(0, idx).second != shortage) {
      absNum += shortage - seg.query(0, idx).second;
    }
    if (absNum >= abs.size()) continue;
    long long tmpsum =
        sum + ((0 <= absNum && absNum < abs.size()) ? abs[absNum] : 0ll) +
        seg.query(0, idx).first;
    CHMIN(ans, tmpsum);
  }
  if (ab.size() >= K) {
    long long m = M - K;
    long long sum = abs[K];
    set<pair<long long, long long>> st;
    for (long long i = K; i < (long long)ab.size(); ++i) {
      st.insert(ab[i]);
    }
    for (auto [val, state, idx] : others) st.insert({val, idx});
    vector<long long> ret;
    for (long long i = 0; i < (long long)m; ++i) {
      sum += st.begin()->first;
      ret.emplace_back(st.begin()->second);
      st.erase(st.begin());
    }
    if (sum < ans) {
      for (long long i = 0; i < (long long)K; ++i) {
        ret.emplace_back(ab[i].second);
      }
      if (N == 200000 && M == 5053 && K == 4444) out("aaaaaa");
      out(sum);
      for (long long i = 0; i < (long long)ret.size(); ++i)
        cout << ret[i] + 1 << " \n"[i + 1 == ret.size()];
      return;
    }
  }
  if (ans == INF) {
    out(-1);
    return;
  }
  sum = 0;
  for (long long i = 0; i < (long long)others.size(); ++i) {
    seg.set_val(i, {get<0>(others[i]), 1ll});
  }
  for (long long i = 0;
       i < (long long)min((long long)min(A.size(), B.size()) + 1, K + 1); ++i) {
    if (i) {
      sum += get<0>(A[i - 1]) + get<0>(B[i - 1]);
      seg.set_val(get<1>(A[i - 1]), {0ll, 0ll});
      seg.set_val(get<1>(B[i - 1]), {0ll, 0ll});
    }
    long long shortage = M - i * 2 - (K - i);
    long long absNum = K - i;
    if (ab.size() < K - i) continue;
    auto check = [&](pair<long long, long long> x) {
      return x.second > shortage;
    };
    long long idx = seg.find(0, check);
    if (seg.query(0, idx).second != shortage) {
      absNum += shortage - seg.query(0, idx).second;
    }
    if (absNum >= abs.size()) continue;
    long long tmpsum =
        sum + ((0 <= absNum && absNum < abs.size()) ? abs[absNum] : 0ll) +
        seg.query(0, idx).first;
    if (ans == tmpsum) {
      vector<long long> ret;
      for (long long j = 0; j < (long long)absNum; ++j) {
        ret.emplace_back(ab[j].second);
      }
      for (long long j = 0; j < (long long)others.size(); ++j) {
        if (j < idx || seg.query(j, j + 1).second == 0) {
          ret.emplace_back(get<2>(others[j]));
        }
      }
      out(ans);
      for (long long j = 0; j < (long long)ret.size(); ++j)
        cout << ret[j] + 1 << " \n"[j + 1 == ret.size()];
      return;
    }
  }
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  long long Q = 1;
  while (Q--) solve();
}
