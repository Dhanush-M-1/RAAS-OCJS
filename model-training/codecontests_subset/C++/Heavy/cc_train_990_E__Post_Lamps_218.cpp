#include <bits/stdc++.h>
using namespace std;
int mark[1000005], l[1000005];
long long cost[1000005];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, m, k;
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    int temp;
    cin >> temp;
    mark[temp] = 1;
  }
  for (int i = 1; i <= k; i++) cin >> cost[i];
  if (mark[0] == 1) {
    cout << "-1";
    return 0;
  }
  int last = 0, dis = 0;
  for (int i = 1; i <= n - 1; i++) {
    if (!mark[i]) {
      dis = max(dis, i - last);
      last = i;
    } else
      l[i] = last;
  }
  dis = max(dis, n - last);
  if (dis > k) {
    cout << "-1\n";
    return 0;
  }
  long long minn = 2000000000000000005;
  int ind = 1;
  for (int i = dis; i <= k; i++) {
    long long cnt = 1;
    for (int j = i; j < n;) {
      if (mark[j]) {
        j = l[j];
      } else {
        cnt++;
        j = j + i;
      }
    }
    minn = min(cost[i] * cnt, minn);
  }
  cout << minn << "\n";
  return 0;
}
