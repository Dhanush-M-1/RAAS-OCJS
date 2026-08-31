#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
using pii = pair<int, int>;
const int N = 2e5 + 20;
int n, s[N], a[N], fen[N];
inline void add(int p, int val) {
  for (p++; p < N; p += p & -p) fen[p] += val;
}
inline int get(int p) {
  int sum = 0;
  for (; p; p -= p & -p) sum += fen[p];
  return sum;
}
int32_t main() {
  ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) cin >> s[i];
  for (int i = 0; i < n; i++) add(i + 1, i + 1);
  int p = n - 1;
  while (p >= 0) {
    int low = 0, high = n + 1;
    while (high - low > 1) {
      int mid = (low + high) >> 1;
      if (get(mid) <= s[p])
        low = mid;
      else
        high = mid;
    }
    a[p] = low;
    add(low, -low);
    p--;
  }
  for (int i = 0; i < n; i++) cout << a[i] << ' ';
  cout << '\n';
}
