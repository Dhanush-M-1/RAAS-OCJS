#include <bits/stdc++.h>
using namespace std;
clock_t time_p = clock();
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    char s[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        cin >> s[i][j];
      }
    }
    vector<pair<int, int>> ans;
    char a = s[2][1];
    char b = s[1][2];
    char c = s[n - 1][n];
    char d = s[n][n - 1];
    if (a == b && c == d && a == c) {
      cout << 2 << "\n";
      cout << 1 << " " << 2 << "\n";
      cout << 2 << " " << 1 << "\n";
      continue;
    }
    if (a == b) {
      if (c == d) {
        if (a != c) {
          cout << 0 << "\n";
          continue;
        }
      }
      cout << 1 << "\n";
      if (a == c) {
        cout << n - 1 << " " << n << "\n";
      } else {
        cout << n << " " << n - 1 << "\n";
      }
    } else if (c == d) {
      if (a == b) {
        if (a != c) {
          cout << 0 << "\n";
          continue;
        }
      }
      cout << 1 << "\n";
      if (c == a) {
        cout << 2 << " " << 1 << "\n";
      } else {
        cout << 1 << " " << 2 << "\n";
      }
    } else {
      cout << 2 << "\n";
      if (a == '0') {
        cout << 2 << " " << 1 << "\n";
      } else
        cout << 1 << " " << 2 << "\n";
      if (c == '1') {
        cout << n - 1 << " " << n << "\n";
      } else
        cout << n << " " << n - 1 << "\n";
    }
  }
  cerr << "\nTime Taken : " << (float)(clock() - time_p) / CLOCKS_PER_SEC
       << "\n";
}
