#include <bits/stdc++.h>
using namespace std;
template <typename TH>
void _dbg(const char* sdbg, TH h) {
  cerr << sdbg << "=" << h << "\n";
}
template <typename TH, typename... TA>
void _dbg(const char* sdbg, TH h, TA... t) {
  while (*sdbg != ',') cerr << *sdbg++;
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
const long long N = 2e5 + 5;
struct Euler {
  struct Edge {
    long long nei, nr, id;
  };
  vector<vector<Edge>> slo;
  vector<long long> ans, used, deg, beg;
  long long e_num, n;
  Euler() : e_num(0), n(0) {}
  void AddEdge(long long a, long long b, long long idd) {
    e_num++;
    if (a > n || b > n) {
      n = max(a, b);
      slo.resize(n + 2);
      deg.resize(n + 2);
      beg.resize(n + 2);
    }
    used.push_back(0);
    slo[a].push_back({b, e_num, idd});
  }
  vector<vector<long long>> FindEuler() {
    used.push_back(0);
    assert(((long long)(used).size()) > e_num);
    vector<vector<long long>> lol;
    for (long long i = (1); i <= (n); ++i) {
      if (beg[i] < ((long long)(slo[i]).size())) {
        Go(i);
        lol.push_back(ans);
        ans.clear();
      }
    }
    return lol;
  }

 private:
  void Go(long long v) {
    (v);
    while (beg[v] < ((long long)(slo[v]).size())) {
      Edge& e = slo[v][beg[v]];
      beg[v]++;
      long long nei = e.nei;
      if (used[e.nr]) {
        continue;
      }
      used[e.nr] = 1;
      Go(nei);
      ans.push_back(e.id);
    }
  }
};
long long a[N];
long long b[N];
int32_t main() {
  ios_base::sync_with_stdio(0);
  cout << fixed << setprecision(10);
  if (0) cout << fixed << setprecision(10);
  cin.tie(0);
  long long n, s;
  cin >> n >> s;
  map<long long, long long> scal;
  for (long long i = (1); i <= (n); ++i) {
    cin >> a[i];
    scal[a[i]] = 1;
  }
  long long nxt = 1;
  for (auto& p : scal) {
    p.second = nxt;
    nxt++;
  }
  for (long long i = (1); i <= (n); ++i) {
    a[i] = scal[a[i]];
    b[i] = a[i];
  }
  sort(b + 1, b + 1 + n);
  vector<vector<long long>> where(n + 2);
  Euler euler;
  long long moves = 0;
  for (long long i = (1); i <= (n); ++i) {
    if (a[i] == b[i]) {
      continue;
    }
    moves++;
    where[a[i]].push_back(i);
    euler.AddEdge(a[i], b[i], i);
  }
  if (moves > s) {
    cout << "-1\n";
    return 0;
  }
  vector<vector<long long>> cycs = euler.FindEuler();
  long long to_join = min(((long long)(cycs).size()), s - moves);
  if (to_join <= 2) {
    to_join = 0;
  }
  (cycs);
  mini(to_join, ((long long)(cycs).size()));
  vector<long long> bigger;
  vector<long long> begs;
  for (long long i = 0; i < (to_join); ++i) {
    bigger.insert(bigger.end(), (cycs.back()).begin(), (cycs.back()).end());
    begs.push_back(cycs.back().back());
    cycs.pop_back();
  }
  if (to_join) {
    reverse((begs).begin(), (begs).end());
    cycs.push_back(begs);
    cycs.push_back(bigger);
  }
  cout << ((long long)(cycs).size()) << endl;
  for (auto v : cycs) {
    cout << ((long long)(v).size()) << "\n";
    for (auto x : v) {
      cout << x << " ";
    }
    long long cp = a[v.back()];
    for (long long i = (((long long)(v).size()) - 1); i >= (1); --i) {
      a[v[i]] = a[v[i - 1]];
    }
    a[v[0]] = cp;
    cout << "\n";
  }
  for (long long i = (1); i <= (n); ++i) {
    if (0) cout << a[i] << " ";
  }
  if (0) cout << endl;
  for (long long i = (1); i <= (n); ++i) {
    assert(a[i] == b[i]);
  }
  return 0;
}
