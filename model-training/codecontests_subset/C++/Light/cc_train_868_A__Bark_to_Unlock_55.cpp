#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
const int INF = 1e9 + 7;
const long double PI = 3.141592653589793;
inline void bye() { exit(0); }
int main(void) {
  cout << fixed << setprecision(16);
  srand(INF);
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  string password;
  cin >> password;
  int n;
  cin >> n;
  vector<string> can(n);
  for (int i = 0; i < n; i++) {
    cin >> can[i];
  }
  int canf = -1, cans = -1;
  for (int i = 0; i < n; i++) {
    if (can[i][1] == password[0]) {
      canf = i;
    }
    if (can[i][0] == password[1]) {
      cans = i;
    }
    if (can[i] == password) {
      cout << "YES\n";
      bye();
    }
  }
  if (-1 == canf || cans == -1) {
    cout << "NO\n";
  } else {
    cout << "YES\n";
  }
  bye();
}
