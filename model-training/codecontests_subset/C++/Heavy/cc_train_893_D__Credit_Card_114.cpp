#include <bits/stdc++.h>
using namespace std;
void read(bool out = 0) {}
long long a[500009];
long long mx[500009];
int main() {
  read();
  long long n, d;
  cin >> n >> d;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 1; i < n; i++) a[i] += a[i - 1];
  mx[n] = -1e15;
  bool done = 1;
  for (int i = n - 1; i >= 0; i--) {
    mx[i] = max(mx[i + 1], a[i]);
    if (mx[i] > d) done = 0;
  }
  if (!done) return cout << -1, 0;
  long long dif = 0;
  long long ans = 0;
  for (int i = 1; i < n; i++) {
    if (a[i] == a[i - 1]) {
      if (dif + a[i] < 0) {
        dif += max(d - (mx[i] + dif), 0ll);
        ans++;
        if (dif + a[i] < 0) done = 0;
      }
    }
  }
  if (done)
    cout << ans;
  else
    cout << -1;
}
