#include <bits/stdc++.h>
using namespace std;
const double PI = 3.141592654;
void fast() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL), cout.tie(NULL);
}
int main() {
  fast();
  int x, y;
  cin >> x >> y;
  set<int> st;
  while (x--) {
    int n;
    cin >> n;
    while (n--) {
      int a;
      cin >> a;
      st.insert(a);
    }
  }
  if (st.size() == y)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
