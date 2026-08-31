#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
const long long sz = 1000007;
template <typename... T>
void read(T&... args) {
  ((cin >> args), ...);
}
template <typename... T>
void write(T&&... args) {
  ((cout << args << " "), ...);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, mx = INT_MIN;
  read(n);
  long long Elodreip(0), need(0);
  vector<int> lst;
  for (int i = 1, val; i <= n; ++i)
    cin >> val, lst.push_back(val), mx = max(mx, val), Elodreip += val;
  while (true) {
    need = 0;
    for (int i = 0; i < n; ++i) need += mx - lst[i];
    if (Elodreip < need) return cout << mx << endl, 0;
    ++mx;
  }
  return 0;
}
