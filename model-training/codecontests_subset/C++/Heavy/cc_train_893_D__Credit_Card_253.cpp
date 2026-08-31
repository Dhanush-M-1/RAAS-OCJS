#include <bits/stdc++.h>
using namespace std;
class A {
 public:
  void solve() {
    int n;
    cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    bool ok = true;
    int A = 1, B = 2, C = 3;
    for (int i = 0; i < n; i++) {
      if (a[i] == A)
        swap(B, C);
      else if (a[i] == B)
        swap(A, C);
      else {
        ok = false;
        break;
      }
    }
    if (ok)
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
};
class B {
 public:
  void solve() {
    long long n;
    cin >> n;
    vector<long long> div;
    div.push_back(1);
    if (n != 1) div.push_back(n);
    for (long long i = 2; i <= sqrt(n); i++) {
      if (n % i == 0) {
        div.push_back(i);
        if (i != n / i) div.push_back(n / i);
      }
    }
    long long res = 1;
    for (long long d : div) {
      for (int k = 1; k < 32 && ((1 << k) - 1 <= d); k++) {
        if (d == ((1 << k) - 1) * (1 << (k - 1))) {
          res = max(res, d);
        }
      }
    }
    cout << res << endl;
  }
};
class C {
 public:
  vector<int> fa;
  vector<long long> cost;
  int find(int x) {
    if (x != fa[x]) return fa[x] = find(fa[x]);
    return x;
  }
  void merge(int x, int y) {
    int fx = find(x);
    int fy = find(y);
    if (fx != fy) {
      fa[fx] = fy;
      cost[fy] = min(cost[fy], cost[fx]);
    }
  }
  void solve() {
    long long n, m;
    cin >> n >> m;
    vector<long long> c(n + 1);
    fa = vector<int>(n + 1);
    cost = vector<long long>(n + 1, 0);
    for (int i = 1; i <= n; i++) {
      cin >> c[i];
      fa[i] = i;
      cost[i] = c[i];
    }
    for (int i = 0; i < m; i++) {
      int u, v;
      cin >> u >> v;
      merge(u, v);
    }
    unordered_set<long long> st;
    for (int i = 1; i <= n; i++) {
      st.insert(find(i));
    }
    long long res = 0;
    for (auto i : st) res += cost[i];
    cout << res << endl;
  }
};
class D {
 public:
  void solve() {
    long long n, d;
    cin >> n >> d;
    vector<long long> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    vector<long long> csb(n, 0);
    vector<long long> sum(n, 0);
    for (int i = 0; i < n; i++) {
      sum[i] = (i > 0 ? sum[i - 1] : 0) + a[i];
      if (sum[i] > d) {
        cout << -1 << endl;
        return;
      }
    }
    csb[n - 1] = d - sum[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      csb[i] = min(d - sum[i], csb[i + 1]);
    }
    long long cnt = 0, res = 0;
    for (int i = 0; i < n; i++) {
      long long cur = sum[i] + cnt;
      if (a[i] == 0 && cur < 0) {
        if (csb[i] - cnt < abs(cur)) {
          cout << -1 << endl;
          return;
        }
        cnt += csb[i] - cnt;
        res++;
      }
    }
    cout << res << endl;
  }
};
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  D ans;
  ans.solve();
  return 0;
}
