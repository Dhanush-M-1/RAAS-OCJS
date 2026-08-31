#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
using pr = pair<int, int>;
template <typename T>
void _read(T *arr, int n) {
  for (int i = 0; i < n; i++) cin >> arr[i];
}
template <typename T>
void _write(T *arr, int n) {
  for (int i = 0; i < n; i++) cout << arr[i] << " ";
  cout << endl;
}
const int MAXN = 100033;
ll n;
ll l, r;
int start;
void __Main__() {
  cin >> n >> l >> r;
  ll sum = 0;
  ll now = 2 * n - 2;
  if (l == r && l == n * (n - 1) + 1) {
    cout << 1 << endl;
    return;
  }
  ll st = 0;
  for (int i = 1; i < n; i++) {
    if (sum + now >= l) {
      st = sum;
      start = i;
      break;
    }
    sum += now;
    now -= 2;
  }
  ll res = now;
  ll i;
  for (i = sum + 1;; i++) {
    res--;
    ll output;
    if ((i - st) & 1) {
      output = start;
    } else {
      output = start + (i - st) / 2;
    }
    if (res == 0) {
      now -= 2;
      res = now;
      start++;
      st = i;
    }
    if (i < l) {
      continue;
    }
    if (i > r) break;
    cout << output << " ";
    if (i >= n * (n - 1)) break;
  }
  if (i < r) cout << 1;
  cout << endl;
}
signed main() {
  ios ::sync_with_stdio(false);
  cin.tie(nullptr);
  {
    int _Test_cases;
    cin >> _Test_cases;
    for (int case_num = 1; case_num <= _Test_cases; case_num++) {
      __Main__();
    }
  }
  return 0;
}
