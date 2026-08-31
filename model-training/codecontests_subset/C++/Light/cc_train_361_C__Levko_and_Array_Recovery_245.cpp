#include <bits/stdc++.h>
using namespace std;
const int MX = 5009;
const int MOD = 1e9 + 7;
int n, QN;
int cmd[MX], ll[MX], rr[MX], vv[MX], arr[MX], flag[MX], sol[MX];
bool done[MX];
int main() {
  cin >> n >> QN;
  for (int j = 1; j <= n; j++) arr[j] = 1e9;
  for (int j = 1; j <= QN; j++) {
    cin >> cmd[j] >> ll[j] >> rr[j] >> vv[j];
  }
  for (int xx = 1; xx <= QN; xx++) {
    int st = ll[xx], en = rr[xx], V = vv[xx];
    if (cmd[xx] == 2)
      for (int j = st; j <= en; j++) arr[j] = min(arr[j], V - flag[j]);
    else
      for (int j = st; j <= en; j++) flag[j] += V;
  }
  for (int j = 1; j <= n; j++) sol[j] = arr[j];
  for (int xx = 1; xx <= QN; xx++) {
    int st = ll[xx], en = rr[xx], V = vv[xx];
    if (cmd[xx] == 2) {
      int mx = -(1 << 30);
      for (int j = st; j <= en; j++) mx = max(mx, arr[j]);
      if (mx != V) {
        puts("NO");
        return 0;
      }
    } else
      for (int j = st; j <= en; j++) arr[j] += V;
  }
  cout << "YES" << endl;
  for (int j = 1; j <= n; j++) cout << sol[j] << ' ';
}
