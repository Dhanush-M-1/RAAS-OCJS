#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma GCC optimize("Ofast,no-stack-protector")
using namespace std;
void err(istream_iterator<string> it) {}
template <typename T, typename... Args>
void err(istream_iterator<string> it, T a, Args... args) {
  cerr << *it << " = " << a << "\n";
  err(++it, args...);
}
function<void(void)> ____ = []() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
};
template <typename T>
vector<T> &operator<<(vector<T> &__container, T x) {
  __container.push_back(x);
  return __container;
}
template <typename T>
ostream &operator<<(ostream &out, vector<T> &__container) {
  for (T _ : __container) out << _ << ' ';
  return out;
}
void sci() {}
template <typename... Args>
void sci(int &x, Args &...args) {
  scanf("%d", &x);
  sci(args...);
}
void scl() {}
template <typename... Args>
void scl(long long int &x, Args &...args) {
  scanf("%lld", &x);
  scl(args...);
}
const int MAXN = 1e6 + 7;
void solve() {
  int n, m, k;
  sci(n, m, k);
  vector<bool> pos(n, false);
  for (int i = 1; i <= m; i++) {
    int x;
    sci(x);
    pos[x] = true;
  }
  vector<int> pre(n, 0);
  for (int i = 1; i < n; i++) pre[i] = pos[i] ? pre[i - 1] : i;
  vector<int> A(k);
  for (int &x : A) sci(x);
  if (pos[0]) {
    cout << -1 << "\n";
    return;
  }
  long long int ret = LLONG_MAX;
  for (int x = 0; x < k; x++) {
    int last = 0, __cnt = 0;
    while (last < n) {
      __cnt++;
      if (last - pre[last] - 1 >= x) {
        __cnt = -1;
        break;
      }
      last = pre[last] + x + 1;
    }
    if (__cnt != -1)
      ((ret) = (ret) < (1ll * __cnt * A[x]) ? (ret) : (1ll * __cnt * A[x]));
  }
  cout << (ret == LLONG_MAX ? -1 : ret) << "\n";
}
int main() {
  solve();
  return 0;
}
