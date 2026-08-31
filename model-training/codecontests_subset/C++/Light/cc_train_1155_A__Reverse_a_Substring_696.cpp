#include <bits/stdc++.h>
using namespace std;
const int siz = 1e5;
long long a[siz];
void fast() {
  std::ios_base::sync_with_stdio(NULL);
  cin.tie(NULL);
  cout.tie(NULL);
}
int main() {
  fast();
  int n;
  cin >> n;
  string s;
  cin >> s;
  int z = 0, x, y;
  for (int i = 1; i < n; i++) {
    if (s[i] < s[i - 1]) {
      z = 1;
      cout << "YES\n";
      cout << i << " " << i + 1;
      break;
    }
  }
  if (z == 0) cout << "NO";
}
