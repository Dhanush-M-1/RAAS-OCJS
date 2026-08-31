#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1000000007;
const long long INF = 1e9 + 5;
const double eps = 1e-7;
const double PI = acos(-1.0);
inline void debug_vi(vector<int> a) {
  for (long long i = (long long)(0); i < (long long)(a.size()); i++)
    cout << a[i] << " ";
}
inline void debug_vll(vector<long long> a) {
  for (long long i = (long long)(0); i < (long long)(a.size()); i++)
    cout << a[i] << " ";
}
inline void print_case(int tn) { cout << "Case #" << tn << ": "; }
template <typename T>
using minpq = priority_queue<T, vector<T>, greater<T>>;
template <typename T>
using maxpq = priority_queue<T>;
map<int, vector<pair<int, int>>> segs, s;
int dx[8] = {0, 1, 1, 1, 0, -1, -1, -1};
int dy[8] = {1, 1, 0, -1, -1, -1, 0, 1};
bool valid(int nu, int nv) {
  return (nu >= 1 && nu <= (1e9) && nv >= 1 && nv <= (1e9));
}
bool checkSegs(int nu, int nv) {
  vector<pair<int, int>> &sg = s[nu];
  int lo = 0, hi = sg.size() - 1;
  while (lo <= hi) {
    int mid = (lo + hi) >> 1;
    if (sg[mid].second >= nv) {
      if (sg[mid].first <= nv) return true;
      hi = mid - 1;
    } else
      lo = mid + 1;
  }
  return false;
}
int main() {
  std::ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  clock_t clk = clock();
  int x, y, a, b, n, r, p, q;
  cin >> x >> y >> a >> b >> n;
  for (long long i = (long long)(0); i < (long long)(n); i++) {
    cin >> r >> p >> q;
    segs[r].push_back({p, q});
  }
  for (auto &itr : segs) {
    sort((itr.second).begin(), (itr.second).end());
    vector<pair<int, int>> ints;
    for (int i = 0; i < (int)itr.second.size();) {
      int rr = i, hg = itr.second[i].second;
      while (rr < (int)itr.second.size()) {
        if (hg >= itr.second[rr].first) {
          hg = max(hg, itr.second[rr].second);
          rr++;
        } else
          break;
      }
      rr--;
      ints.push_back({itr.second[i].first, itr.second[rr].second});
      i = rr + 1;
    }
    s[itr.first] = ints;
  }
  set<pair<int, int>> visited;
  map<pair<int, int>, int> dist;
  queue<pair<int, int>> qu({{x, y}});
  dist[{x, y}] = 0;
  visited.insert({x, y});
  int u, v, res = -1;
  while (!qu.empty()) {
    if (res >= 0) break;
    tie(u, v) = qu.front();
    qu.pop();
    for (long long d = (long long)(0); d < (long long)(8); d++) {
      int nu = u + dx[d];
      int nv = v + dy[d];
      if (valid(nu, nv) && checkSegs(nu, nv) && visited.count({nu, nv}) == 0) {
        visited.insert({nu, nv});
        dist[{nu, nv}] = dist[{u, v}] + 1;
        qu.push({nu, nv});
        if (nu == a && nv == b) {
          res = dist[{nu, nv}];
          break;
        }
      }
    }
  }
  cout << res;
  cerr << "\n"
       << "Time (in ms): " << double(clock() - clk) * 1000.0 / CLOCKS_PER_SEC
       << "\n";
  return 0;
}
