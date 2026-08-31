#include <bits/stdc++.h>
using namespace std;
const int N = 100010;
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  string x, y;
  cin >> x >> y;
  cout << x << " " << y << "\n";
  set<string> st;
  st.insert(x);
  st.insert(y);
  int n;
  cin >> n;
  while (n--) {
    string a, b;
    cin >> a >> b;
    st.erase(a);
    st.insert(b);
    cout << *st.begin() << " " << *++st.begin() << "\n";
  }
  return 0;
}
