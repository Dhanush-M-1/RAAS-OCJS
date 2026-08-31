#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  unordered_map<int, int> map;
  map.clear();
  for (int i = 0; i < n; i++) {
    int temp;
    cin >> temp;
    map[temp]++;
  }
  unordered_map<int, int> map2;
  map2.clear();
  for (int i = 0; i < n - 1; i++) {
    int temp;
    cin >> temp;
    map2[temp]++;
    map[temp]--;
  }
  for (auto i = map.begin(); i != map.end(); i++) {
    if ((*i).second == 1) {
      cout << (*i).first << endl;
      break;
    }
  }
  for (int i = 0; i < n - 2; i++) {
    int temp;
    cin >> temp;
    map2[temp]--;
  }
  for (auto i = map2.begin(); i != map2.end(); i++) {
    if ((*i).second == 1) {
      cout << (*i).first << endl;
      break;
    }
  }
  return 0;
}
