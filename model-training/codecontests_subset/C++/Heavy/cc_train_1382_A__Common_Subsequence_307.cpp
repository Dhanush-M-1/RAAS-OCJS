#include <bits/stdc++.h>
using namespace std;
unsigned long long int INF = 10000;
class Compare {
 public:
  bool operator()(const pair<long long int, long long int> p1,
                  const pair<long long int, long long int> p2) {
    if (p1.first > p2.first)
      return true;
    else if (p1.first == p2.first) {
      if (p1.second < p2.second) return true;
    }
    return false;
  }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int t;
  cin >> t;
  while (t--) {
    map<long long int, long long int> m1;
    map<long long int, long long int> m2;
    long long int n, m, flag = 0, ans;
    cin >> n >> m;
    long long int a[n], b[m];
    for (long long int i = 0; i < n; i++) {
      cin >> a[i];
      m1[a[i]]++;
    }
    for (long long int i = 0; i < m; i++) {
      cin >> b[i];
      m2[b[i]]++;
      if (m1[b[i]] > 0) {
        ans = b[i];
        flag = 1;
      }
    }
    if (flag) {
      cout << "YES" << endl << "1 " << ans << endl;
    } else
      cout << "NO" << endl;
  }
  return 0;
}
