#include <bits/stdc++.h>
using namespace std;
int main() {
  int T;
  cin >> T;
  while (T--) {
    int N;
    cin >> N;
    int a[N][N];
    for (int i = 0; i < N; i++) {
      string s;
      cin >> s;
      for (int j = 0; j < s.size(); j++) a[i][j] = s[j] - '0';
    }
    vector<pair<int, int>> targets;
    targets.push_back({0, 1});
    targets.push_back({1, 0});
    targets.push_back({N - 1, N - 2});
    targets.push_back({N - 2, N - 1});
    a[N - 1][N - 2] ^= 1;
    a[N - 2][N - 1] ^= 1;
    int one = 0, zero = 0;
    for (int inv = 0; inv <= 2; inv++) {
      vector<pair<int, int>> inverts;
      for (auto Ti : targets) {
        if (a[Ti.first][Ti.second] != inv) inverts.push_back(Ti);
      }
      if (inverts.size() <= 2) {
        cout << inverts.size() << '\n';
        for (auto& i : inverts)
          cout << i.first + 1 << ' ' << i.second + 1 << '\n';
        break;
      }
    }
  }
  return 0;
}
