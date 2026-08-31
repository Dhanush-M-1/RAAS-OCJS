#include <bits/stdc++.h>
using namespace std;
int N = INT_MAX;
long long INF1 = 1e9 + 5;
long long INF2 = 1e18L + 5;
map<long long, long long> my;
int h[10005];
int main() {
  int n, k;
  cin >> n >> k;
  int chk1 = 0, chk2 = 0;
  int a, b, c;
  vector<int> v1, v2, v3;
  for (int i = 0; i < n; i++) {
    cin >> a >> b >> c;
    if (b == 1 && c == 1) {
      v1.push_back(a);
    } else if (b == 1 && c == 0) {
      v2.push_back(a);
    } else if (b == 0 && c == 1) {
      v3.push_back(a);
    }
    chk1 += b;
    chk2 += c;
  }
  if (chk1 < k || chk2 < k) {
    cout << -1;
    return 0;
  }
  int n1 = v1.size(), n2 = v2.size(), n3 = v3.size();
  int x = min(n2, n3);
  sort(v2.begin(), v2.end());
  sort(v3.begin(), v3.end());
  for (int i = 0; i < x; i++) {
    v1.push_back(v2[i] + v3[i]);
  }
  sort(v1.begin(), v1.end());
  long long ans = 0;
  for (int i = 0; i < k; i++) {
    ans += v1[i];
  }
  cout << ans;
  return 0;
}
