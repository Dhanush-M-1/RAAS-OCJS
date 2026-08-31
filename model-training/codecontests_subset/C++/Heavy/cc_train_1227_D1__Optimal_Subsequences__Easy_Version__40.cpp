#include <bits/stdc++.h>
using namespace std;
void itval(istream_iterator<string> it) {}
template <typename T, typename... Args>
void itval(istream_iterator<string> it, T a, Args... args) {
  cerr << *it << " = " << a << endl;
  itval(++it, args...);
}
template <typename T>
inline void print(T x) {
  cout << x << "\n";
}
template <typename T>
inline void printvec(T x) {
  for (auto a : x) cout << a << ' ';
  cout << '\n';
}
const long long int MOD = 1e9 + 7;
struct custom {
  bool operator()(const pair<int, int> &p1, const pair<int, int> &p2) const {
    if (p1.first == p2.first) {
      return p1.second < p2.second;
    }
    return p1.first > p2.first;
  }
};
long long int get_pow(long long int x, long long int k) {
  if (k == 0) return 1ll;
  long long int y = get_pow(x, k / 2);
  y = (y * y) % MOD;
  if (k % 2) y = (y * x) % MOD;
  return y;
}
const int N = 2e5 + 10;
void solve() {
  int n, m, k, x;
  cin >> n;
  vector<int> v(n);
  for (int i = (int)0; i < int(n); i++) cin >> v[i];
  vector<pair<int, int> > res;
  for (int i = (int)0; i < int(n); i++) {
    res.push_back({v[i], i});
  }
  sort(res.begin(), res.end(), custom());
  cin >> m;
  for (int i = (int)0; i < int(m); i++) {
    cin >> k >> x;
    x--;
    vector<int> dum;
    for (int i = (int)0; i < int(k); i++) dum.push_back(res[i].second);
    sort(dum.begin(), dum.end());
    for (int i = (int)0; i < int(k); i++) dum[i] = v[dum[i]];
    cout << dum[x] << "\n";
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int test = 1;
  clock_t z = clock();
  for (int tes = (int)0; tes < int(test); tes++) {
    solve();
  }
  fprintf(stderr, "Total Time:%.4f\n", (double)(clock() - z) / CLOCKS_PER_SEC),
      fflush(stderr);
  return 0;
}
