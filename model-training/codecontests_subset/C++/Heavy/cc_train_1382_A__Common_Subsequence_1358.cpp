#include <bits/stdc++.h>
using namespace std;
template <typename T1, typename T2>
istream& operator>>(istream& in, pair<T1, T2>& a) {
  in >> a.first >> a.second;
  return in;
}
template <typename T1, typename T2>
ostream& operator<<(ostream& out, pair<T1, T2> a) {
  out << a.first << " " << a.second;
  return out;
}
template <typename T, typename T1>
T amax(T& a, T1 b) {
  if (b > a) a = b;
  return a;
}
template <typename T, typename T1>
T amin(T& a, T1 b) {
  if (b < a) a = b;
  return a;
}
const long long INF = 1e18;
const int32_t M = 1e9 + 7;
const int32_t MM = 998244353;
const int N = 55;
void solve() {
  long long int m, n, count = 0;
  cin >> m >> n;
  long long int mini = min(m, n);
  long long int arr[m], arr2[n], arr3[mini];
  for (int i = 0; i < m; i++) {
    cin >> arr[i];
  }
  for (int i = 0; i < n; i++) {
    cin >> arr2[i];
  }
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      if (arr[i] == arr2[j]) {
        arr3[count] = arr[i];
        count++;
        break;
      }
    }
    if (count > 0) break;
  }
  if (count > 0) {
    cout << "YES" << endl;
    cout << count << " ";
    for (int i = 0; i < count; i++) cout << arr3[i] << " ";
    cout << endl;
  } else
    cout << "NO" << endl;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
