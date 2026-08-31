#include <bits/stdc++.h>
using namespace std;
const int MAXN = 3e5 + 5;
int arr[MAXN];
vector<int> depends[MAXN];
map<int, int> to2cnt;
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &arr[i]);
  }
  for (int i = 1; i <= m; ++i) {
    int pre, tail;
    scanf("%d%d", &pre, &tail);
    depends[tail].push_back(pre);
  }
  int mov = 0;
  for (int i = 0; i < (int)(depends[arr[n]].size()); ++i) {
    ++to2cnt[depends[arr[n]][i]];
  }
  for (int k = n - 1; k >= 1; --k) {
    if (n - k - mov == to2cnt[arr[k]]) {
      ++mov;
    } else {
      for (int i = 0; i < (int)(depends[arr[k]].size()); ++i) {
        ++to2cnt[depends[arr[k]][i]];
      }
    }
  }
  printf("%d\n", mov);
}
