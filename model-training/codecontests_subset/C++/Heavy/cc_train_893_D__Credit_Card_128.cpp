#include <bits/stdc++.h>
using namespace std;
mt19937 rnd(chrono::high_resolution_clock::now().time_since_epoch().count());
mt19937_64 rnd64(
    chrono::high_resolution_clock::now().time_since_epoch().count());
template <typename T = int>
inline T read() {
  T res = 0, sig = 1;
  char c = getchar();
  while ((c < '0' || c > '9') && c != '-') {
    c = getchar();
  }
  if (c == '-') {
    sig = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    res = res * 10 + c - '0';
    c = getchar();
  }
  return res * sig;
}
void setio(const char *in, const char *out) {
  freopen(in, "r", stdin);
  freopen(out, "w", stdout);
}
void setio(const string task) {
  freopen((task + ".in").c_str(), "r", stdin);
  freopen((task + ".out").c_str(), "w", stdout);
}
void fastio() {
  ios::sync_with_stdio(false);
  cin.tie(0);
}
int main() {
  fastio();
  int n;
  long long d;
  cin >> n >> d;
  vector<long long> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  vector<long long> pr(n);
  pr[0] = a[0];
  for (int i = 1; i < n; i++) {
    pr[i] = pr[i - 1] + a[i];
  }
  for (int i = 0; i < n; i++) {
    if (pr[i] > d) {
      cout << "-1\n";
      return 0;
    }
  }
  vector<long long> su(n);
  su[n - 1] = pr[n - 1];
  for (int i = n - 2; i > -1; i--) {
    su[i] = max(su[i + 1], pr[i]);
  }
  int ans = 0;
  long long cur = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] == 0 && pr[i] + cur < 0) {
      ans++;
      long long mx = d - (su[i] + cur);
      if (mx < -(pr[i] + cur)) {
        cout << "-1\n";
        return 0;
      }
      cur += mx;
    }
  }
  cout << ans;
  return 0;
}
