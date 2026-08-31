#include <bits/stdc++.h>
using namespace std;
string st;
vector<long> v;
long r;
int main() {
  ios_base::sync_with_stdio(0);
  cin >> st;
  st += '+';
  for (int i = 0; i < st.size(); i++) {
    if (st[i] == '+') {
      v.push_back(r);
      r = 0;
    } else
      r = r * 10 + st[i] - 48;
  }
  sort(v.begin(), v.end());
  for (int i = 0; i < v.size(); i++) {
    if (i) cout << "+";
    cout << v[i];
  }
  cout << endl;
  cin.get();
  cin.get();
  return 0;
}
