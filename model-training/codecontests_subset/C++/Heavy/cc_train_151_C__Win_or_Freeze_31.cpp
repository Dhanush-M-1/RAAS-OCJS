#include <bits/stdc++.h>
#pragma GCC optimize("O2")
using namespace std;
const int INF = 1 << 29;
const int MOD = 1e9 + 7;
bool isPowerOfTwo(long long int x) { return x && (!(x & (x - 1))); }
void fastio() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
}
long long binpow(long long a, long long b) {
  long long res = 1;
  while (b > 0) {
    if (b & 1) res = res * a;
    a = a * a;
    b >>= 1;
  }
  return res;
}
const int dx[] = {1, 0, -1, 0, 1, 1, -1, -1};
const int dy[] = {0, -1, 0, 1, 1, -1, -1, 1};
map<long long int, long long int> mp;
int main() {
  fastio();
  int tc = 1;
  while (tc--) {
    long long int n;
    cin >> n;
    long long int uk = n;
    long long int cnt = 0;
    for (long long int i = 2; i * i <= n; i++) {
      while (uk % i == 0) {
        mp[i]++;
        uk /= i;
        cnt++;
      }
    }
    if (uk > 1) {
      mp[uk]++;
      cnt++;
    }
    if (cnt == 1 || n == 1) {
      cout << 1;
      cout << "\n";
      ;
      cout << 0;
    } else if (cnt == 2) {
      cout << 2;
    } else {
      set<long long int> s;
      for (auto i : mp) {
        s.insert(i.first);
      }
      cout << 1;
      cout << "\n";
      ;
      cout << *s.begin() * (*prev(s.end()));
    }
  done:;
  }
  return 0;
}
