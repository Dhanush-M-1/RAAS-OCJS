#include <bits/stdc++.h>
using namespace std;
inline void prankami() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
}
int main() {
  prankami();
  string pass, x;
  int n;
  cin >> pass >> n;
  bool first = false, second = false;
  for (int i = 0; i < n; i++) {
    cin >> x;
    if (x[0] == pass[1]) second = true;
    if (x[1] == pass[0]) first = true;
    if (x == pass) first = true, second = true;
  }
  if (first && second)
    cout << "YES\n";
  else
    cout << "NO\n";
  return 0;
}
