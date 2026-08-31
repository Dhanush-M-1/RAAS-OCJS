#include <bits/stdc++.h>
using namespace std;
int n, m;
int flag[5555] = {0};
int res[5555] = {0};
int pro[5555][4] = {0};
int sum = 0, qusiba[5555] = {0};
vector<int> v[5555];
int main() {
  cin >> n >> m;
  int go = 0;
  for (int i = 0; i < m; i++) {
    cin >> pro[i][0] >> pro[i][1] >> pro[i][2] >> pro[i][3];
    if (pro[i][0] == 2) go = i, sum++;
  }
  int k = sum;
  while (go >= 0) {
    if (pro[go][0] == 2) {
      for (int i = pro[go][1]; i <= pro[go][2]; i++) {
        if (v[i].size() > 0) {
          if (res[i] > pro[go][3]) {
            for (int w = 0; w < v[i].size(); w++) qusiba[v[i][w]]--;
            v[i].clear();
            v[i].push_back(k);
            qusiba[k]++;
            res[i] = pro[go][3];
          } else if (res[i] == pro[go][3])
            v[i].push_back(k), qusiba[k]++;
        } else
          v[i].push_back(k), res[i] = pro[go][3], qusiba[k]++;
      }
      k--;
    } else {
      for (int i = pro[go][1]; i <= pro[go][2]; i++) {
        if (v[i].size() > 0) res[i] -= pro[go][3];
      }
    }
    go--;
  }
  int f = 0;
  for (int i = 1; i <= sum; i++)
    if (qusiba[i] == 0) {
      f = 1;
      break;
    }
  if (f) {
    cout << "NO" << endl;
    return 0;
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i++) cout << res[i] << " ";
  cout << endl;
  return 0;
}
