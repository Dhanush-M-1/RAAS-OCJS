#include <bits/stdc++.h>
using namespace std;
long long int binexp(long long int a, long long int b) {
  long long int ans = 1;
  while (b > 0) {
    if (b & 1) ans = ans * a;
    a = a * a;
  }
  return ans;
}
long long int modexp(long long int a, long long int b, long long int m) {
  long long int ans = 1;
  while (b > 0) {
    if (b & 1) {
      ans = ans * a % m;
    }
    a = a * a % m;
  }
  return ans % m;
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    unordered_map<int, int> make_pair;
    for (int i = 0; i < n; i++) {
      int x;
      cin >> x;
      make_pair[x]++;
    }
    int ans = -1;
    for (int i = 0; i < m; i++) {
      int x;
      cin >> x;
      if (make_pair[x] != 0) ans = x;
    }
    if (ans == -1)
      cout << "NO" << endl;
    else {
      cout << "YES" << endl;
      cout << 1 << " " << ans << endl;
    }
  }
}
