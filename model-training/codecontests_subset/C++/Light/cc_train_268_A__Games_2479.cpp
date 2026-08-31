#include <bits/stdc++.h>
using namespace std;
inline void boost() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
}
template <typename T>
void print(T x, char space = ' ', char end = '\n') {
  for (auto& i : x) cout << i << space;
  cout << end;
}
int main() {
  boost();
  int n;
  cin >> n;
  vector<int> a(n), b(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i] >> b[i];
  }
  int s = 0;
  for (int i = 0; i < n; i++) {
    s += count(b.begin(), b.end(), a[i]);
  }
  cout << s;
  return 0;
}
