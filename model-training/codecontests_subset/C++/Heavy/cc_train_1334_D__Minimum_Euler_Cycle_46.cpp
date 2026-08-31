#include <bits/stdc++.h>
using namespace std;
template <typename S, typename T>
ostream& operator<<(ostream& out, pair<S, T> const& p) {
  out << '(' << p.first << ", " << p.second << ')';
  return out;
}
template <typename T>
ostream& operator<<(ostream& out, vector<T> const& v) {
  long long l = v.size();
  for (long long i = 0; i < l - 1; i++) out << v[i] << ' ';
  if (l > 0) out << v[l - 1];
  return out;
}
template <typename T>
void trace(const char* name, T&& arg1) {
  cout << name << " : " << arg1 << '\n';
}
template <typename T, typename... Args>
void trace(const char* names, T&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cout.write(names, comma - names) << " : " << arg1 << " | ";
  trace(comma + 1, args...);
}
const long long MOD = 1e9 + 7;
const long long INF = 1e18;
const double EPS = 1e-9;
const long long N = 500005;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
long long rand(long long l, long long r) {
  uniform_int_distribution<long long> uid(l, r);
  return uid(rng);
}
long long n, l, r;
void solve(long long x) {
  cin >> n >> l >> r;
  long long num = 0;
  long long toadd = n - 1;
  long long vert = 1;
  long long to = 2;
  vector<long long> ans;
  for (long long i = 0; i < n - 1; i++) {
    if (2 * (num + toadd) >= l) {
      long long left = 2 * num + 1;
      long long i = 0;
      to = vert + 1;
      while (left <= r and left <= n * (n - 1)) {
        if (i % 2 == 0) {
          if (left >= l) {
            ans.push_back(vert);
          }
        } else {
          if (left >= l) {
            ans.push_back(to);
          }
          to++;
          if (to > n) {
            vert++;
            to = vert + 1;
          }
        }
        left++;
        i++;
      }
      break;
    }
    num += toadd;
    toadd--;
    vert++;
  }
  long long last = (n * (n - 1)) + 1;
  if (r == last) {
    ans.push_back(1);
  }
  for (long long i = 0; i < ans.size(); i++) {
    cout << ans[i] << " ";
  }
  cout << '\n';
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cout.precision(12);
  long long t;
  cin >> t;
  long long i = 0;
  while (i < t) {
    solve(i + 1);
    i++;
  }
}
