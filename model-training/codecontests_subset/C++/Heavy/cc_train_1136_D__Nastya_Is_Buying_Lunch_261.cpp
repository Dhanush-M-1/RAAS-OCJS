#include <bits/stdc++.h>
using namespace std;
int n, m, x, y, counter;
unordered_map<int, bool> mp[300005];
vector<int> elem;
vector<int> where;
int pos[300005];
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    elem.push_back(x);
    pos[x] = i - 1;
  }
  int me = elem.back();
  for (int i = 1; i <= m; i++) {
    cin >> x >> y;
    mp[y][x] = true;
    if (y == me) where.push_back(pos[x]);
  }
  sort(where.begin(), where.end());
  for (int i = where.size() - 1; i >= 0; i--) {
    int now = where[i];
    while (true) {
      if (mp[elem[now + 1]][elem[now]])
        swap(elem[now + 1], elem[now]);
      else
        break;
      if (elem[now] == me) {
        counter++;
        break;
      }
      now++;
    }
  }
  cout << counter;
  return 0;
}
