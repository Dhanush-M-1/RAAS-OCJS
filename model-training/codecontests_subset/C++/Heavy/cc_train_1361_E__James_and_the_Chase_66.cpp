#include <bits/stdc++.h>
using namespace std;
template <typename TH>
void _dbg(const char* sdbg, TH h) {
  cerr << sdbg << "=" << h << "\n";
}
template <typename TH, typename... TA>
void _dbg(const char* sdbg, TH h, TA... t) {
  while (*sdbg != ',') {
    cerr << *sdbg++;
  }
  cerr << "=" << h << ",";
  _dbg(sdbg + 1, t...);
}
template <class C>
void mini(C& a4, C b4) {
  a4 = min(a4, b4);
}
template <class C>
void maxi(C& a4, C b4) {
  a4 = max(a4, b4);
}
template <class T1, class T2>
ostream& operator<<(ostream& out, pair<T1, T2> pair) {
  return out << "(" << pair.first << ", " << pair.second << ")";
}
template <class A, class B, class C>
struct Triple {
  A first;
  B second;
  C third;
  bool operator<(const Triple& t) const {
    if (first != t.first) return first < t.first;
    if (second != t.second) return second < t.second;
    return third < t.third;
  }
};
template <class T>
void ResizeVec(T&, vector<long long>) {}
template <class T>
void ResizeVec(vector<T>& vec, vector<long long> sz) {
  vec.resize(sz[0]);
  sz.erase(sz.begin());
  if (sz.empty()) {
    return;
  }
  for (T& v : vec) {
    ResizeVec(v, sz);
  }
}
template <class A, class B, class C>
ostream& operator<<(ostream& out, Triple<A, B, C> t) {
  return out << "(" << t.first << ", " << t.second << ", " << t.third << ")";
}
template <class T>
ostream& operator<<(ostream& out, vector<T> vec) {
  out << "(";
  for (auto& v : vec) out << v << ", ";
  return out << ")";
}
template <class T>
ostream& operator<<(ostream& out, set<T> vec) {
  out << "(";
  for (auto& v : vec) out << v << ", ";
  return out << ")";
}
template <class L, class R>
ostream& operator<<(ostream& out, map<L, R> vec) {
  out << "(";
  for (auto& v : vec) out << v << ", ";
  return out << ")";
}
struct Sol {
  void Test() {
    long long n, m;
    cin >> n >> m;
    vector<vector<long long>> slo(n + 2);
    vector<pair<long long, long long>> es;
    for (long long i = (1); i <= (m); ++i) {
      long long a, b;
      cin >> a >> b;
      slo[a].push_back(b);
      es.push_back({b, a});
    }
    vector<long long> pre(n + 2), par(n + 2), sz(n + 2);
    long long ziom = -1;
    vector<long long> ord;
    for (long long tr = 0; tr < (40); ++tr) {
      long long root = 1 + rand() % n;
      for (long long i = (1); i <= (n); ++i) {
        pre[i] = 0;
        par[i] = 0;
        sz[i] = 0;
      }
      ord.clear();
      long long d = 0;
      function<void(long long)> Dfs = [&](long long v) {
        d++;
        ord.push_back(v);
        sz[v] = 1;
        pre[v] = d;
        for (auto nei : slo[v]) {
          if (pre[nei]) {
            continue;
          }
          par[nei] = v;
          Dfs(nei);
          sz[v] += sz[nei];
        }
      };
      Dfs(root);
      function<bool(long long, long long)> IsAncOf = [&](long long a,
                                                         long long b) {
        return pre[a] <= pre[b] && pre[b] + sz[b] <= pre[a] + sz[a];
      };
      long long fail = 0;
      for (long long i = (1); i <= (n); ++i) {
        for (auto nei : slo[i]) {
          if (!IsAncOf(nei, i) && par[nei] != i) {
            fail = 1;
            goto A;
          }
        }
      }
    A:;
      if (!fail) {
        ziom = root;
        break;
      }
    }
    (ziom);
    if (ziom == -1) {
      cout << "-1\n";
      return;
    }
    long long M = 1;
    while (M <= n) {
      M = 2 * M;
    }
    sort((es).begin(), (es).end(),
         [&](pair<long long, long long> L, pair<long long, long long> R) {
           return pre[L.first] < pre[R.first];
         });
    vector<vector<long long>> drz(2 * M + 5);
    for (long long i = 0; i < (((long long)(es).size())); ++i) {
      long long ind = pre[es[i].second] + M - 1;
      while (ind) {
        drz[ind].push_back(i);
        ind /= 2;
      }
    }
    vector<long long> is_interesting(n + 2);
    function<void(vector<long long>&, vector<long long>&)> Merge =
        [&](vector<long long>& v, vector<long long>& from) {
          for (long long i = 0; i < (min(2ll, ((long long)(from).size())));
               ++i) {
            v.push_back(from[i]);
          }
          sort((v).begin(), (v).end());
          v.resize(min(2ll, ((long long)(v).size())));
        };
    for (auto v : ord) {
      if (v == ziom) {
        is_interesting[v] = 1;
        continue;
      }
      long long L = pre[v] + M - 1;
      long long R = pre[v] + sz[v] + M - 2;
      vector<long long> here;
      Merge(here, drz[L]);
      if (L != R) {
        Merge(here, drz[R]);
      }
      while (L / 2 != R / 2) {
        if (L % 2 == 0) {
          Merge(here, drz[L + 1]);
        }
        if (R % 2 == 1) {
          Merge(here, drz[R - 1]);
        }
        L /= 2;
        R /= 2;
      }
      if (here.empty()) {
        continue;
      }
      long long h1 = es[here[0]].first;
      if (((long long)(here).size()) == 2 && pre[es[here[1]].first] < pre[v]) {
        continue;
      }
      if (pre[h1] < pre[v]) {
        is_interesting[v] = is_interesting[h1];
      }
    }
    long long cnt = 0;
    for (long long i = (1); i <= (n); ++i) {
      cnt += is_interesting[i];
    }
    (cnt);
    if (5 * cnt < n) {
      cout << "-1\n";
      return;
    }
    for (long long i = (1); i <= (n); ++i) {
      if (is_interesting[i]) {
        cout << i << " ";
      }
    }
    cout << endl;
  }
};
int32_t main() {
  ios_base::sync_with_stdio(0);
  cout << fixed << setprecision(10);
  if (0) cout << fixed << setprecision(10);
  cin.tie(0);
  long long t;
  cin >> t;
  for (long long i = (1); i <= (t); ++i) {
    Sol sol;
    sol.Test();
  }
  return 0;
}
