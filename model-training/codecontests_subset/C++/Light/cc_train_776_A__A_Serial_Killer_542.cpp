#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n;
  string v1, v2, s1, s2;
  cin >> v1 >> v2 >> n;
  cout << v1 << " " << v2 << "\n";
  while (n--) {
    cin >> s1 >> s2;
    if (s1 == v1)
      v1 = s2;
    else
      v2 = s2;
    cout << v1 << " " << v2 << "\n";
  }
  return 0;
}
