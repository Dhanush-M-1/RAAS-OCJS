#include <bits/stdc++.h>
using namespace std;
const int p = 1000000001;
int main() {
  int n, m;
  cin >> n >> m;
  vector<int> data;
  vector<set<int>> chage(n + 1);
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    data.push_back(x);
  }
  for (int i = 0; i < m; i++) {
    int x, y;
    cin >> x >> y;
    chage[x].insert(y);
  }
  set<int> kans;
  kans.insert(data[data.size() - 1]);
  for (int i = data.size() - 2; i >= 0; i--) {
    if (kans == chage[data[i]]) {
      continue;
    }
    int temp = 0;
    for (const int &el : chage[data[i]]) {
      if (kans.find(el) != kans.end()) {
        temp++;
      }
    }
    if (temp != kans.size()) {
      kans.insert(data[i]);
    }
  }
  cout << n - kans.size() << endl;
  return 0;
}
