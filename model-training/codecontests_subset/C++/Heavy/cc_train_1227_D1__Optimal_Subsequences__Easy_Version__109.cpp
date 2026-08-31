#include <bits/stdc++.h>
using namespace std;
template <typename T1, typename T2, typename T3>
struct pair3 {
  T1 first;
  T2 second;
  T3 third;
};
template <typename T1, typename T2, typename T3, typename T4>
struct pair4 {
  T1 first;
  T2 second;
  T3 third;
  T4 fourth;
};
const long long MOD = 1000000007;
const long double PI = acos(-1.0);
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n, m;
  cin >> n;
  vector<long long> ar(n);
  for (long long i = 0; i < n; ++i) {
    cin >> ar[i];
  }
  vector<vector<long long>> ans(n + 1);
  for (long long len = 1; len <= n; ++len) {
    vector<long long> temp;
    long long mx = -1, mn = INT_MAX;
    multiset<long long> st;
    auto del = [&](long long val) {
      auto it = temp.end();
      --it;
      while (1) {
        if (*it == val) {
          temp.erase(it);
          break;
        }
        it -= 1;
      }
    };
    for (long long start = 0; start < n; ++start) {
      if (temp.size() < len) {
        temp.push_back(ar[start]);
        st.insert(ar[start]);
      } else {
        if (ar[start] > *st.begin()) {
          del(*st.begin());
          st.erase(st.begin());
          st.insert(ar[start]);
          temp.push_back(ar[start]);
        }
      }
      ans[len] = temp;
    }
  }
  cin >> m;
  long long l, idx;
  while (m--) {
    cin >> l >> idx;
    cout << ans[l][idx - 1] << endl;
  }
  return 0;
}
