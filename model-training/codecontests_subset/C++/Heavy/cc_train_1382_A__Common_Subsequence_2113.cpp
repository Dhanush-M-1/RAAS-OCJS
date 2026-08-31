#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n;
  long long m;
  cin >> n >> m;
  set<long long> st1;
  set<long long> st2;
  for (long long i = 1; i <= n; i++) {
    long long k;
    cin >> k;
    st1.insert(k);
  }
  for (long long i = 1; i <= m; i++) {
    long long k;
    cin >> k;
    st2.insert(k);
  }
  long long flag = 0;
  long long ans;
  for (auto itr = st1.begin(); itr != st1.end(); itr++) {
    if (st2.find(*itr) != st2.end()) {
      flag = 1;
      ans = *itr;
      break;
    }
  }
  if (flag == 0)
    cout << "NO" << endl;
  else
    cout << "YES" << endl << "1 " << ans << endl;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  long long t;
  cin >> t;
  while (t--) solve();
}
