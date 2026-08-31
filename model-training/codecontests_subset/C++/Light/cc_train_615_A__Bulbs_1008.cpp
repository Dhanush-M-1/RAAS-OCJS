#include <bits/stdc++.h>
using namespace std;
set<int> st;
int n, m, a, b;
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> a;
    for (int j = 1; j <= a; j++) {
      cin >> b;
      st.insert(b);
    }
  }
  if (st.size() == m)
    cout << "YES";
  else
    cout << "NO";
}
