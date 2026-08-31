#include <bits/stdc++.h>
using namespace std;
namespace {
template <class T>
void read(T& container) {
  for (typename T::value_type& x : container) cin >> x;
}
template <class T>
void print(T& container, const char separator = ' ') {
  for (typename T::value_type& x : container) cout << x << separator;
}
void openFiles(const char* in, const char* out) {
  freopen(in, "r", stdin);
  freopen(out, "w", stdout);
}
int n, x;
vector<int> v;
const int maxn = 1100;
bool used[maxn];
bool in[maxn];
bool can[2 * maxn];
vector<int> sz;
void run() {
  cin >> n >> x;
  --x;
  v.resize(n);
  read(v);
  for (int x : v) {
    in[x - 1] = 1;
  }
  int add;
  for (int i = 0; i < n; ++i)
    if (!used[i] && !in[i]) {
      bool p = 0;
      int cc = 0;
      int tmp = 0, j;
      for (j = i; v[j] != 0; j = v[j] - 1) {
        if (j == x) {
          p = 1;
          cc = tmp;
        }
        ++tmp;
      }
      if (j == x) {
        p = 1;
        cc = tmp;
      }
      if (!p)
        sz.push_back(tmp + 1);
      else
        add = tmp - cc + 1;
    }
  can[0] = 1;
  for (int x : sz)
    for (int i = n - 1; i >= 0; --i)
      if (can[i]) can[i + x] = 1;
  for (int i = 0; i < n; ++i)
    if (can[i]) cout << i + add << endl;
}
}  // namespace
int main() {
  run();
  return 0;
}
