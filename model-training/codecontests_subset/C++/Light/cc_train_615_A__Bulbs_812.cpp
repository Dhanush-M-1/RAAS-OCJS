#include <bits/stdc++.h>
using namespace std;
set<int> st;
int main() {
  int a, b, k, g;
  cin >> a >> g;
  for (int i = 0; i < a; i++) {
    cin >> k;
    for (int j = 0; j < k; j++) {
      cin >> b;
      st.insert(b);
    }
  }
  if (st.size() == g) {
    cout << "YES";
  } else
    cout << "NO";
}
