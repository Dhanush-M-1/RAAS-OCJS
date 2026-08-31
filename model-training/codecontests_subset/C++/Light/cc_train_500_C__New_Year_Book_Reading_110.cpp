#include <bits/stdc++.h>
using namespace std;
int main() {
  ifstream ff("file.txt");
  int n, m;
  cin >> n >> m;
  map<int, int> Mymap;
  int u;
  for (int i = 0; i < n; i++) {
    cin >> u;
    Mymap.insert(pair<int, int>(i + 1, u));
  }
  unsigned long long sum = 0;
  vector<int> v2;
  int z;
  unsigned int sv;
  for (int i = 0; i < m; i++) {
    sv = v2.size();
    cin >> z;
    if (v2.empty()) {
      v2.push_back(z);
    } else {
      for (int j = sv - 1; j >= 0; j--) {
        if (v2[j] != z) {
          sum += Mymap[v2[j]];
        } else {
          v2.erase(v2.begin() + j);
          v2.push_back(z);
          break;
        }
        if (j == 0) {
          v2.push_back(z);
        }
      }
    }
  }
  cout << sum << endl;
  return 0;
}
