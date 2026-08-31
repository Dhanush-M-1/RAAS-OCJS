#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<pair<int, int>> teams(n, make_pair(0, 0));
  int sum = 0;
  for (int i = 0; i < n; i++) cin >> teams[i].first >> teams[i].second;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (teams[i].first == teams[j].second && i != j) sum++;
    }
  }
  cout << sum << endl;
}
