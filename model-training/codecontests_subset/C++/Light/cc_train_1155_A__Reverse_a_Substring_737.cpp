#include <bits/stdc++.h>
using namespace std;
const int maxn = 3e5 + 12;
string s;
int a[26];
int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  int n;
  cin >> n;
  cin >> s;
  int ind = -1;
  for (int i = 1; i < n; i++) {
    if (s[i - 1] > s[i]) {
      ind = i;
    }
  }
  if (ind == -1) {
    cout << "NO";
    return 0;
  }
  cout << "YES\n";
  cout << ind << " " << ind + 1;
}
