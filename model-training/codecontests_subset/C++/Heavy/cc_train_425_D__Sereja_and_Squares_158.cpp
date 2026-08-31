#include <bits/stdc++.h>
using namespace std;
const int N = 100010;
const int mod = 3174511;
vector<int> v[N];
struct edge {
  int x, y, next, type;
} e[N];
int head[mod + 10], cnt;
void addedge(int x, int y, int type) {
  long long u = (1314517LL * x + y) % mod;
  e[cnt].x = x;
  e[cnt].y = y;
  e[cnt].type = type;
  e[cnt].next = head[u];
  head[u] = cnt++;
}
bool find(int x, int y, int &type) {
  if (!(x >= 0 && x < N && y >= 0 && y < N)) return false;
  long long u = (1314517LL * x + y) % mod;
  for (int i = head[u]; i != -1; i = e[i].next)
    if (e[i].x == x && e[i].y == y) {
      type = e[i].type;
      return true;
    }
  return false;
}
int main() {
  memset(head, -1, sizeof(head));
  int n, x, y;
  scanf("%d", &n);
  bool flag = false;
  for (int i = 1; i <= n; i++) {
    scanf("%d%d", &x, &y);
    v[x].push_back(y);
  }
  for (int i = 0; i < N; i++) v[i].push_back(10000000);
  for (int i = 0; i < N; i++) sort(v[i].begin(), v[i].end());
  for (int i = 0; i < N; i++)
    for (int j = 0; j < v[i].size() - 1; j++)
      if (v[i].size() >= 320)
        addedge(i, v[i][j], 2);
      else
        addedge(i, v[i][j], 1);
  int ans = 0;
  for (int i = 0; i <= 100000; i++)
    if (v[i].size() >= 320) {
      for (int j = i + 1; j <= 100000; j++) {
        if (v[j].size() < 320) continue;
        int len = j - i;
        int pt1 = 0, pt2 = 0, pt3 = 0;
        for (int k = 0; k < v[i].size() - 1; k++) {
          while (v[i][pt1] < v[i][k] + len) pt1++;
          if (v[i][k] + len != v[i][pt1]) continue;
          while (v[j][pt2] < v[i][k]) pt2++;
          while (v[j][pt3] < v[i][k] + len) pt3++;
          if (v[j][pt2] == v[i][k] && v[j][pt3] == v[i][k] + len) ans += 2;
        }
      }
    }
  for (int i = 0; i <= 100000; i++) {
    if (v[i].size() >= 320) continue;
    for (int j = 0; j < v[i].size() - 1; j++) {
      for (int k = j + 1; k < v[i].size() - 1; k++) {
        int len = v[i][k] - v[i][j];
        int type;
        if (find(i + len, v[i][j], type) && find(i + len, v[i][k], type))
          ans += type;
        if (find(i - len, v[i][j], type) && find(i - len, v[i][k], type))
          ans += type;
      }
    }
  }
  cout << (ans >> 1) << endl;
  return 0;
}
