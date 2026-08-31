#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
const int mod = 1000000007;
mt19937 rng((int)std::chrono::steady_clock::now().time_since_epoch().count());
class segment_tree {
 public:
  long long rmaxq[4 * 100000], rminq[4 * 100000], rsumq[4 * 100000];
  void init() {
    for (int i = 0; i < 4 * 100000; i++) {
      rmaxq[i] = 0;
      rminq[i] = 0;
      rsumq[i] = 0;
    }
  }
  void upd_rminq(int lb, int rb, int tar, int ok, long long val) {
    if (lb == rb) {
      rminq[ok] = val;
      return;
    }
    int mid = (lb + rb) / 2;
    if (tar <= mid) {
      upd_rminq(lb, mid, tar, 2 * ok + 1, val);
    } else {
      upd_rminq(mid + 1, rb, tar, 2 * ok + 2, val);
    }
    rminq[ok] = min(rminq[2 * ok + 1], rminq[2 * ok + 2]);
  }
  long long query_rminq(int lb, int rb, int ok, int lconst, int rconst) {
    if (rconst < lb || lconst > rb) {
      return LLONG_MAX;
    }
    if (lconst <= lb && rb <= rconst) {
      return rminq[ok];
    }
    int mid = (lb + rb) / 2;
    return min(query_rminq(lb, mid, ok * 2 + 1, lconst, rconst),
               query_rminq(mid + 1, rb, ok * 2 + 2, lconst, rconst));
  }
  void updall_rminq(long long arr[], int n) {
    for (int i = 0; i < n; i++) upd_rminq(0, 100000 - 1, i, 0, arr[i]);
  }
  void upd_rmaxq(int lb, int rb, int tar, int ok, long long val) {
    if (lb == rb) {
      rmaxq[ok] = val;
      return;
    }
    int mid = (lb + rb) / 2;
    if (tar <= mid) {
      upd_rmaxq(lb, mid, tar, 2 * ok + 1, val);
    } else {
      upd_rmaxq(mid + 1, rb, tar, 2 * ok + 2, val);
    }
    rmaxq[ok] = max(rmaxq[2 * ok + 1], rmaxq[2 * ok + 2]);
  }
  long long query_rmaxq(int lb, int rb, int ok, int lconst, int rconst) {
    if (rconst < lb || lconst > rb) {
      return LLONG_MIN;
    }
    if (lconst <= lb && rb <= rconst) {
      return rmaxq[ok];
    }
    int mid = (lb + rb) / 2;
    return max(query_rmaxq(lb, mid, ok * 2 + 1, lconst, rconst),
               query_rmaxq(mid + 1, rb, ok * 2 + 2, lconst, rconst));
  }
  void updall_rmaxq(long long arr[], int n) {
    for (int i = 0; i < n; i++) {
      upd_rmaxq(0, 100000 - 1, i, 0, arr[i]);
    }
  }
  void upd_rsumq(int lb, int rb, int tar, int ok, long long val) {
    if (lb == rb) {
      rsumq[ok] = val;
      return;
    }
    int mid = (lb + rb) / 2;
    if (tar <= mid) {
      upd_rsumq(lb, mid, tar, 2 * ok + 1, val);
    } else {
      upd_rsumq(mid + 1, rb, tar, 2 * ok + 2, val);
    }
    rsumq[ok] = rsumq[2 * ok + 1] + rsumq[2 * ok + 2];
  }
  long long query_rsumq(int lb, int rb, int ok, int lconst, int rconst) {
    if (rconst < lb || lconst > rb) {
      return 0;
    }
    if (lconst <= lb && rb <= rconst) {
      return rsumq[ok];
    }
    int mid = (lb + rb) / 2;
    return query_rsumq(lb, mid, ok * 2 + 1, lconst, rconst) +
           query_rsumq(mid + 1, rb, ok * 2 + 2, lconst, rconst);
  }
  void updall_rsumq(long long arr[], int n) {
    for (int i = 0; i < n; i++) upd_rsumq(0, 100000 - 1, i, 0, arr[i]);
  }
} st;
class set_union {
 public:
  int a[100000 + 1];
  void init() {
    for (int i = 0; i <= 100000; i++) a[i] = i;
  }
  int set_of(int u) {
    if (a[u] == u)
      return u;
    else
      return a[u] = set_of(a[u]);
  }
  void union_(int u, int v) { a[set_of(u)] = set_of(v); }
  struct SEGT {
    int index;
    char type;
  };
  SEGT make_SEGT(int a, char b) {
    SEGT esgewqt = {a, b};
    return esgewqt;
  }
  class SEGT_COMP {
   public:
    bool operator()(SEGT a, SEGT b) {
      if (a.index == b.index)
        return a.type < b.type;
      else
        return a.index > b.index;
    }
  };
  vector<pair<int, int> > segment_union(vector<pair<int, int> > V, int T) {
    for (int i = 0; i < V.size(); i++) {
      if (V[i].first > V[i].second) {
        swap(V[i].first, V[i].second);
      }
    }
    priority_queue<SEGT, vector<SEGT>, SEGT_COMP> segt_pq1;
    for (int i = 0; i < V.size(); i++) {
      segt_pq1.push(make_SEGT(V[i].first - T, 'S'));
      segt_pq1.push(make_SEGT(V[i].second, 'E'));
    }
    stack<SEGT> process;
    vector<pair<int, int> > UwU;
    while (segt_pq1.size()) {
      if (segt_pq1.top().type == 'E') {
        process.pop();
        if (process.size() == 0) {
          UwU[int(UwU.size()) - 1].second = segt_pq1.top().index;
        }
      } else {
        process.push(segt_pq1.top());
        if (process.size() == 1) {
          UwU.push_back({segt_pq1.top().index + T, 0});
        }
      }
      segt_pq1.pop();
    }
    return UwU;
  }
} su;
void include() {}
bool cmp(pair<int, int> a, pair<int, int> b) {
  if (a.first == b.first)
    return a.second < b.second;
  else
    return a.first < b.first;
}
void solve() {
  long long n, x, y;
  cin >> n >> x >> y;
  int g = n * y;
  string s = to_string(g);
  int S = s.size();
  bool yes = false;
  if (s.size() >= 2 && s.substr(S - 2, 2) == "00") {
    yes = true;
  }
  if (s.size() >= 2)
    s.erase(S - 2, 2);
  else
    s = "0";
  long long ppl = stoi(s) + (1 - yes);
  cout << max(ppl - x, 0ll);
}
int main() {
  srand(time(NULL));
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  include();
  int t = 1;
  while (t--) {
    solve();
  }
}
