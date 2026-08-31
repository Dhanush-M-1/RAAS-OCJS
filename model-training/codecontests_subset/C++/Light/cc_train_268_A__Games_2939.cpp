#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, count = 0;
  cin >> n;
  pair<int, int> teams[n];
  for (int i = 0; i < n; i++) {
    cin >> teams[i].first >> teams[i].second;
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (i != j) {
        if (teams[i].first == teams[j].second) {
          count++;
        }
      }
    }
  }
  cout << count << endl;
  return 0;
}
