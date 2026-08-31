#include <bits/stdc++.h>
using namespace std;
template <typename T>
void trace(const char* name, T&& arg1) {
  cout << name << " : " << arg1 << endl;
}
template <typename T, typename... Args>
void trace(const char* names, T&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cout.write(names, comma - names) << " : " << arg1 << " | ";
  trace(comma + 1, args...);
}
const long long MOD = 1000 * 1000 * 1000 + 7;
const long long NMAX = 10000 * 1000 + 111111;
long long arr[NMAX];
long long n, m, p, q, k;
vector<long long> ans;
string str;
char ch;
vector<long long> v;
void solve() {
  v.clear();
  cin >> n;
  cin >> p >> q;
  long long left = 0;
  long long st;
  for (long long i = (n - 1); i >= 1; i--) {
    if (left + 2 * i < p) {
      left = left + 2 * i;
      continue;
    } else {
      st = (n - i);
      break;
    }
  }
  p = p - left;
  q = q - left;
  for (long long i = st; i < n; i++) {
    long long idx = i + 1;
    for (long long j = idx; j <= n; j++) {
      v.push_back(i);
      v.push_back(j);
      if (v.size() >= q) break;
    }
  }
  if (v.size() != q) v.push_back(1);
  for (long long i = p; i <= q; i++) {
    cout << v[i - 1] << " ";
  }
  cout << "\n";
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
}
