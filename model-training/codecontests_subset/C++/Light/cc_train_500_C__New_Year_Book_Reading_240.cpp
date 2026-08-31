#include <bits/stdc++.h>
using namespace std;
int arr[1005], Stack[1005];
bool vis[1005];
map<int, int> Map;
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) {
    int e;
    cin >> e;
    Map.insert(make_pair(i, e));
  }
  int pos = 1;
  for (int i = 1; i <= m; ++i) {
    cin >> arr[i];
    if (!vis[arr[i]] && pos <= n) {
      Stack[pos] = arr[i];
      vis[arr[i]] = true;
      pos++;
    }
  }
  long long sum = 0;
  for (int i = 2; i <= m; ++i) {
    for (int j = 1; j <= n; ++j) {
      if (Stack[j] == arr[i]) {
        for (int k = j; k > 1; --k) {
          sum += Map[Stack[k - 1]];
          swap(Stack[k], Stack[k - 1]);
        }
      }
    }
  }
  cout << sum << endl;
  return 0;
}
