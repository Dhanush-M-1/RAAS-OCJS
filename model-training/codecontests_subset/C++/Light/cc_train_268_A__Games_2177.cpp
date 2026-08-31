#include <bits/stdc++.h>
using namespace std;
int main() {
  int games;
  cin >> games;
  vector<pair<int, int>> vec;
  for (int i = 0; i < games; i++) {
    int h, a;
    cin >> h >> a;
    vec.push_back((make_pair(h, a)));
  }
  int l = vec.size();
  int count = 0;
  for (int i = 0; i < l - 1; i++) {
    for (int j = i + 1; j < l; j++) {
      if (vec[i].first == vec[j].second) count++;
      if (vec[i].second == vec[j].first) count++;
    }
  }
  cout << count << endl;
  return 0;
}
