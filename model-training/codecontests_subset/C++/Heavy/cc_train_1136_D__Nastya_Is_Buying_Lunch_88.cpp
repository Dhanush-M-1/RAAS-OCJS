#include <bits/stdc++.h>
using namespace std;
void func() {
  int n, m;
  cin >> n >> m;
  int arr[n + 1];
  for (int i = 1; i <= (n); i++) cin >> arr[i];
  unordered_map<int, unordered_set<int>> mm, vis;
  int a, b;
  for (int i = 1; i <= (m); i++) {
    cin >> a >> b;
    mm[a].insert(b);
  }
  int pos = n;
  while (1) {
    for (int i = pos; i >= 1;) {
      if (mm[arr[i - 1]].count(arr[i])) {
        if (vis[arr[i]].count(arr[i - 1])) {
          i--;
          continue;
        }
        vis[arr[i - 1]].insert(arr[i]);
        swap(arr[i - 1], arr[i]);
        i++;
        if (i > pos) {
          pos--;
          break;
        }
        continue;
      }
      i--;
      if (i == 0) {
        cout << n - pos;
        return;
      }
    }
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  func();
  return 0;
}
