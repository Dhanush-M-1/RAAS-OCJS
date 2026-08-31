#include <bits/stdc++.h>
using namespace std;
typedef vector<int> vi;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cout.precision(10);
  cout << fixed;
  long long t;
  cin >> t;
  while (t--) {
    long long n, m;
    cin >> n >> m;
    vector<long long> a(n), b(m);
    long long i, j;
    long long ans = 0;
    long long flag = 0;
    unordered_map<long long, long long> ump;
    for (int i = 0; i < (int)(n); ++i) {
      cin >> a[i];
      ump[a[i]]++;
    }
    for (int i = 0; i < (int)(m); ++i) {
      cin >> b[i];
      if (ump.find(b[i]) != ump.end()) {
        ans = b[i];
        flag = 1;
      }
    }
    if (flag) {
      cout << "YES\n";
      cout << 1 << " " << ans << "\n";
    } else {
      cout << "NO\n";
    }
  }
  return 0;
}
