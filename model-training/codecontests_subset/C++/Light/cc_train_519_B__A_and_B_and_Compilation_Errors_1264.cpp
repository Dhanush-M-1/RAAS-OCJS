#include <bits/stdc++.h>
using namespace std;
int main() {
  int N;
  cin >> N;
  int k;
  unordered_map<int, int> map_1, map_2, map_3;
  for (int i = 0; i < N; i++) {
    cin >> k;
    map_1[k]++;
  }
  for (int i = 0; i < N - 1; i++) {
    cin >> k;
    map_2[k]++;
  }
  for (int i = 0; i < N - 2; i++) {
    cin >> k;
    map_3[k]++;
  }
  for (auto pr : map_1) {
    int key = pr.first;
    if (map_1[key] > map_2[key]) cout << key << endl;
  }
  for (auto pr : map_2) {
    int key = pr.first;
    if (map_2[key] > map_3[key]) cout << key << endl;
  }
  return 0;
}
