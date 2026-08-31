#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 5;
const int mod = 1e9 + 7;
string s;
int n;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> s;
  for (int i = 0; i < n - 1; ++i) {
    if (s[i] > s[i + 1]) {
      cout << "YES" << endl << i + 1 << " " << i + 2;
      return 0;
    }
  }
  cout << "NO";
}
