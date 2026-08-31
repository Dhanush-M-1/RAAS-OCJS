#include <bits/stdc++.h>
using namespace std;
template <typename T>
using minpq = priority_queue<T, vector<T>, greater<T>>;
const int K = 450;
struct stupidqueue {
  vector<int> a, inv;
  int val = 0;
  stupidqueue(int n) {
    a.assign(n + 1, 0);
    inv.assign(n + 1, 0);
    val = 0;
  }
  void push(int x) {
    inv[a[x]]--;
    a[x]++;
    inv[a[x]]++;
    if (a[x] > val) val = a[x];
  }
  void pop(int x) {
    inv[a[x]]--;
    a[x]--;
    inv[a[x]]++;
    if (inv[val] == 0) val--;
  }
  bool ugh() { return inv[val] >= 2; }
  int mode() { return val; }
};
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  vector<int> a(n + 1, 0);
  vector<int> freq(n + 1, 0);
  for (int i = (1); i < (n + 1); i++) {
    cin >> a[i];
    freq[a[i]]++;
  }
  int F = max_element((freq).begin(), (freq).end()) - freq.begin();
  for (int i = (1); i < (n + 1); i++) {
    if (i != F && freq[i] == freq[F]) {
      cout << n << '\n';
      return 0;
    }
  }
  if (freq[F] == n) {
    cout << 0 << '\n';
    return 0;
  }
  int ans = 0;
  for (int bruh = (1); bruh < (K); bruh++) {
    stupidqueue Q(n);
    int l = 1;
    for (int r = (1); r < (n + 1); r++) {
      Q.push(a[r]);
      while (Q.mode() > bruh) {
        Q.pop(a[l]);
        l++;
      }
      if (Q.ugh()) {
        ans = max(ans, r - l + 1);
      }
    }
  }
  for (int x = (1); x < (n + 1); x++) {
    if (x == F || freq[x] < K) continue;
    vector<int> ve(2 * n + 5, -1);
    ve[n] = 0;
    int s = 0;
    for (int i = (1); i < (n + 1); i++) {
      if (a[i] == F) {
        s++;
      } else if (a[i] == x) {
        s--;
      }
      if (ve[n + s] == -1) {
        ve[n + s] = i;
      }
      ans = max(ans, i - ve[n + s]);
    }
  }
  cout << ans << '\n';
}
