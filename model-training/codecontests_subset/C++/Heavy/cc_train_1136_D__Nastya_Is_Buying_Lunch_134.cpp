#include <bits/stdc++.h>
using namespace std;
template <typename T>
T pow(T a, T b, long long int m) {
  T ans = 1;
  while (b > 0) {
    if (b % 2 == 1) ans = (ans * a) % m;
    b /= 2;
    a = (a * a) % m;
  }
  return ans % m;
}
template <typename T>
void swap(T *a, T *b) {
  T temp = *a;
  *a = *b;
  *b = temp;
  return;
}
struct custom_hash {
  static uint64_t splitmix64(uint64_t x) {
    x += 0x9e3779b97f4a7c15;
    x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9;
    x = (x ^ (x >> 27)) * 0x94d049bb133111eb;
    return x ^ (x >> 31);
  }
  size_t operator()(uint64_t x) const {
    static const uint64_t FIXED_RANDOM =
        chrono::steady_clock::now().time_since_epoch().count();
    return splitmix64(x + FIXED_RANDOM);
  }
};
unordered_map<long long, long long int, custom_hash> safe_map;
const long long int N = 1e6;
std::vector<long long int> h[N];
void solve() {
  long long int n, m;
  cin >> n >> m;
  vector<long long int> stack;
  long long int p[n];
  for (__typeof(n) i = (0) - ((0) > (n)); i != (n) - ((0) > (n));
       i += 1 - 2 * ((0) > (n)))
    cin >> p[i];
  for (__typeof(m) i = (0) - ((0) > (m)); i != (m) - ((0) > (m));
       i += 1 - 2 * ((0) > (m))) {
    long long int u, v;
    cin >> u >> v;
    h[u].push_back(v);
  }
  reverse(p, p + n);
  stack.push_back(p[0]);
  for (__typeof(n) i = (1) - ((1) > (n)); i != (n) - ((1) > (n));
       i += 1 - 2 * ((1) > (n))) {
    long long int val = p[i];
    bool f = true;
    if (h[val].size() < stack.size()) {
      stack.push_back(val);
      continue;
    }
    long long int count = 0;
    for (auto i : h[val]) {
      if (find(stack.begin(), stack.end(), i) != stack.end()) {
        count++;
      }
    }
    if (count < stack.size()) {
      stack.push_back(val);
    }
  }
  cout << n - stack.size() << '\n';
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  solve();
  return 0;
}
