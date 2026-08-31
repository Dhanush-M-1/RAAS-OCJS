#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  vector<int> w, b;
  int cur;
  for (int i = 0; i < n; i++) {
    cin >> cur;
    w.push_back(cur);
  }
  for (int i = 0; i < m; i++) {
    cin >> cur;
    b.push_back(cur);
  }
  vector<int> used(n + 2, -1);
  vector<int> st;
  for (int i = 0; i < m; i++) {
    if (used[b[i]] == -1) {
      st.push_back(b[i]);
      used[b[i]] = st.size() - 1;
    }
  }
  int sum = 0;
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < used[b[i]]; j++) {
      sum += w[st[j] - 1];
      used[st[j]]++;
    }
    st.erase(st.begin() + used[b[i]]);
    st.insert(st.begin(), b[i]);
    used[b[i]] = 0;
  }
  cout << sum << endl;
  return 0;
}
