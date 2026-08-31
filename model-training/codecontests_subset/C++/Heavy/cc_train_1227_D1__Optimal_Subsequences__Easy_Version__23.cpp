#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base ::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n;
  cin >> n;
  vector<int> a(n + 1);
  for (int i = 1; i <= n; i++) cin >> a[i];
  vector<int> aS = a;
  sort(aS.rbegin(), aS.rend());
  int m;
  cin >> m;
  while (m--) {
    int k, pos;
    cin >> k >> pos;
    multiset<int> st;
    for (int j = 0; j < k; j++) st.insert(aS[j]);
    int cnt = 1, ptr = 1;
    while (cnt <= pos) {
      multiset<int>::iterator it = st.find(a[ptr]);
      if (it != st.end()) {
        st.erase(it);
        cnt++;
      }
      ptr++;
    }
    cout << a[ptr - 1] << '\n';
  }
}
