#include <bits/stdc++.h>
using namespace std;
int main() {
  unsigned int num{}, games{};
  cin >> num;
  vector<pair<int, int>> team(num);
  for (unsigned int i = 0; i < num; ++i) {
    cin >> team[i].first >> team[i].second;
  }
  for (unsigned int i = 0; i < num; ++i) {
    for (unsigned int j = 0; j < num; ++j) {
      if (team[i].first == team[j].second) games++;
    }
  }
  cout << games;
  cout << endl;
  return 0;
}
