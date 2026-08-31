#include <bits/stdc++.h>
using namespace std;
long long len(vector<long long> v) { return (v.size()); }
long long len(string s) { return (s.length()); }
long long ask(...) {
  long long x;
  cin >> x;
  return x;
}
void solve() {}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  long long cccc = t;
  while (t--) {
    long long n;
    cin >> n;
    map<long long, long long> f1;
    map<long long, long long> f2;
    map<long long, long long> f3;
    map<long long, long long> f4;
    for (long long i = 0; i <= n - 1; i++) {
      long long x;
      cin >> x;
      f1[x]++;
    }
    f2 = f1;
    for (long long i = 0; i <= n - 2; i++) {
      long long x;
      cin >> x;
      f2[x]--;
      f3[x]++;
    }
    for (auto i : f2) {
      if (i.second != 0) {
        cout << i.first << "\n";
        break;
      }
    }
    f4 = f3;
    for (long long i = 0; i <= n - 3; i++) {
      long long x;
      cin >> x;
      f4[x]--;
    }
    for (auto i : f4) {
      if (i.second != 0) {
        cout << i.first << "\n";
        break;
      }
    }
  }
}
