#include <bits/stdc++.h>
using namespace std;
vector<vector<int> > AdjList;
vector<int> dfs_num, ts;
const int UNVISITED = -1;
const int VISITED = 1;
int main() {
  int q;
  cin >> q;
  while (q--) {
    int l, r, d;
    cin >> l >> r >> d;
    if (d < l) {
      cout << d << endl;
    } else
      cout << d * (r / d + 1) << endl;
  }
  return 0;
}
