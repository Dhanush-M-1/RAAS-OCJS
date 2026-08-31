#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
const int inf = 0x3f3f3f3f;
const int MAXN = 0x7fffffff;
const long long INF = 0x3f3f3f3f3f3f3f3fLL;
void file() {}
const int N = 3e5 + 5;
int fat[N * 2], Size[N * 2], n, k;
vector<int> vec[N];
int find(int x) { return fat[x] == x ? x : fat[x] = find(fat[x]); }
int calc(int x) {
  int y = (x <= k ? x + k : x - k);
  x = find(x);
  y = find(y);
  if (x == 0 || y == 0) return Size[x + y];
  return min(Size[x], Size[y]);
}
void merge(int x, int y) {
  x = find(x);
  y = find(y);
  if (y == 0) swap(x, y);
  fat[y] = x;
  if (x != 0) Size[x] += Size[y];
}
signed main() {
  ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  ;
  string str;
  cin >> n >> k >> str;
  for (int i = 1; i <= k; i++) fat[i] = i, fat[i + k] = i + k, Size[i] = 1;
  for (int i = 1; i <= k; i++) {
    int tn;
    cin >> tn;
    for (int j = 0; j < tn; j++) {
      int pos;
      cin >> pos;
      vec[pos].push_back(i);
    }
  }
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    if (vec[i].size() == 1) {
      int x = vec[i][0];
      ans -= calc(x);
      if (str[i - 1] == '1')
        fat[find(x)] = 0;
      else
        fat[find(x + k)] = 0;
      ans += calc(x);
    } else if (vec[i].size() == 2) {
      int x = vec[i][0], y = vec[i][1];
      if (str[i - 1] == '1') {
        if (find(x) != find(y)) {
          ans -= calc(x);
          ans -= calc(y);
          merge(x, y);
          merge(x + k, y + k);
          ans += calc(x);
        }
      } else {
        if (find(x) != find(y + k)) {
          ans -= calc(x);
          ans -= calc(y);
          merge(x, y + k);
          merge(x + k, y);
          ans += calc(x);
        }
      }
    }
    cout << ans << "\n";
  }
  return 0;
}
