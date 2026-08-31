#include <bits/stdc++.h>
using namespace std;
pair<int, int> pos[10] = {make_pair(1, 2), make_pair(2, 1), make_pair(-1, 0),
                          make_pair(0, -1)};
int main() {
  cin.tie(0);
  ios::sync_with_stdio(0);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    char c;
    int up = 0, down = 0;
    vector<int> v;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        cin >> c;
        if ((i == 1 && j == 2) || (i == 2 && j == 1)) {
          up += (c - '0');
          v.push_back(c - '0');
        }
        if ((i == n - 1 && j == n) || (i == n && j == n - 1)) {
          down += (c - '0');
          v.push_back(c - '0');
        }
      }
    }
    vector<int> afis;
    int myPosition = 0;
    if (v[1] != v[0] && (v[0] != v[2] || v[0] != v[3])) {
      afis.push_back(1);
      myPosition = 0;
    } else if (v[1] != v[0] && (v[1] != v[2] || v[1] != v[3])) {
      afis.push_back(0);
      myPosition = 1;
    }
    for (int i = 2; i < 4; i++)
      if (v[i] == v[myPosition]) afis.push_back(i);
    cout << afis.size() << "\n";
    for (int i = 0; i < afis.size(); i++) {
      if (afis[i] < 2)
        cout << pos[afis[i]].first << " " << pos[afis[i]].second << "\n";
      else
        cout << n + pos[afis[i]].first << " " << n + pos[afis[i]].second
             << "\n";
    }
  }
  return 0;
}
