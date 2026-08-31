#include <bits/stdc++.h>
using namespace std;
long long n, m, q, x, cnt;
set<long long> st;
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> q;
    for (int j = 0; j < q; j++) {
      cin >> x;
      st.insert(x);
    }
  }
  if (st.size() == m)
    cout << "YES";
  else
    cout << "NO";
}
