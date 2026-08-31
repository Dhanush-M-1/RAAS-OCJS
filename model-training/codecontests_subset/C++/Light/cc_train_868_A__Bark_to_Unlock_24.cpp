#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 1e5 + 5;
const long long mod = 1e9 + 7;
long long pw(long long b, long long r, long long md = mod) {
  b = b % md;
  long long ans = 1;
  while (r) {
    if (r & 1) ans = (ans * b) % md;
    b = (b * b) % md;
    r >>= 1;
  }
  return ans;
}
const long long N = 5e5 + 5;
bool vis[N];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long T = 1;
  while (T--) {
    string s;
    cin >> s;
    map<string, long long> m;
    long long n;
    cin >> n;
    string arr[n];
    for (long long i = 0; i <= n - 1; ++i) {
      cin >> arr[i];
      m[arr[i]]++;
    }
    for (long long i = 0; i <= n - 1; ++i) {
      m[arr[i]]++;
      for (long long j = 0; j <= n - 1; ++j) {
        string ns = "";
        ns.push_back(arr[i][1]);
        ns.push_back(arr[j][0]);
        m[ns]++;
      }
    }
    if (m[s])
      cout << "YES" << '\n';
    else
      cout << "NO" << '\n';
  }
  return 0;
}
