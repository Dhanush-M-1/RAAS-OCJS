#include <bits/stdc++.h>
template <class T>
bool ckmin(T& a, const T& b) {
  return b < a ? a = b, 1 : 0;
}
template <class T>
bool ckmax(T& a, const T& b) {
  return a < b ? a = b, 1 : 0;
}
using namespace std;
using namespace chrono;
void solve() {
  int64_t n;
  cin >> n;
  map<int64_t, int64_t> arr;
  for (int64_t i = 0; i < n; ++i) {
    int64_t a;
    cin >> a;
    arr[a]++;
  }
  map<int64_t, int64_t> temp = arr;
  arr.clear();
  for (int64_t i = 0; i < n - 1; ++i) {
    int64_t a;
    cin >> a;
    temp[a]--;
    arr[a]++;
  }
  for (auto i : temp) {
    if (i.second > 0) {
      cout << i.first << '\n';
      break;
    }
  }
  temp = arr;
  for (int64_t i = 0; i < n - 2; ++i) {
    int64_t a;
    cin >> a;
    temp[a]--;
  }
  for (auto x : temp) {
    if (x.second > 0) {
      cout << x.first << '\n';
      break;
    }
  }
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  auto start1 = high_resolution_clock::now();
  int64_t t = 1;
  while (t--) {
    solve();
  }
  auto stop1 = high_resolution_clock::now();
  auto duration = duration_cast<microseconds>(stop1 - start1);
  return 0;
}
