#include <bits/stdc++.h>
using namespace std;
void dbg_out() { cerr << "\b\b]\n"; }
template <typename Head, typename... Tail>
void dbg_out(Head H, Tail... T) {
  cerr << H << ", ";
  dbg_out(T...);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int n;
  cin >> n;
  string s;
  cin >> s;
  int eigts = 0;
  for (char i : s)
    if (i == '8') eigts++;
  cout << min(eigts, n / 11);
  return 0;
}
