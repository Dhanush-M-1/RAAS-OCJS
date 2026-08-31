#include <bits/stdc++.h>
#define int long long
#define double long double
#define INF 1e18
using namespace std;
int calc(int x) {
  string s = to_string(x);
  int ans = 0;
  for (int i = 1; i < s.length(); i++) {
    int a = stoi(s.substr(0, i));
    int b = stoi(s.substr(i));
    ans = max(ans, a*b);
  }
  return ans;
}

signed main() {
  int Q; cin >> Q;
  for (int i = 0; i < Q; i++) {
    int N; cin >> N;
    int ans = 0;
    while (N >= 10) {
      N = calc(N);

      ans++;
      if (ans > 100100) break;
    }
    if (N < 10) {
      cout << ans << endl;
    } else {
      cout << -1 << endl;
    }
  }
}

