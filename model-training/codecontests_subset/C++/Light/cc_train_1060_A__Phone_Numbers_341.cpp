#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c = 0, res;
  string st;
  cin >> n >> st;
  for (int i = 0; i < st.size(); i++) {
    if (st[i] == '8') c++;
  }
  res = n / 11;
  res = min(res, c);
  cout << res << "\n";
  return 0;
}
