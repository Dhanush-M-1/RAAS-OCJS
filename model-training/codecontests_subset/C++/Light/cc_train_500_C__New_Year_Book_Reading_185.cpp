#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1002;
int n, k, ar[MAXN], br[MAXN], vis[MAXN];
int main() {
  while (cin >> n >> k) {
    for (int i = 0; i < n; ++i) {
      cin >> ar[i];
    }
    memset(vis, 0, sizeof(vis));
    vector<int> V;
    long long ret = 0;
    for (int i = 0; i < k; ++i) {
      cin >> br[i];
      br[i]--;
      if (vis[br[i]]) {
        continue;
      }
      vis[br[i]] = 1;
      V.push_back(br[i]);
    }
    for (int i = 0; i < k; ++i) {
      vector<int> temp;
      int pos = -1;
      for (int j = 0; j < V.size(); ++j) {
        if (V[j] == br[i]) {
          break;
        }
        ret += ar[V[j]];
        pos = j;
      }
      temp.push_back(V[pos + 1]);
      for (int j = 0; j <= pos; ++j) {
        temp.push_back(V[j]);
      }
      for (int j = pos + 2; j < V.size(); ++j) {
        temp.push_back(V[j]);
      }
      V = temp;
    }
    cout << ret << endl;
  }
  return 0;
}
