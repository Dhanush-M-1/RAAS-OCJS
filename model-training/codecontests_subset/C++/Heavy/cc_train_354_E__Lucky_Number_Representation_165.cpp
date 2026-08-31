#include <bits/stdc++.h>
using namespace std;
set<long long> failed;
vector<int> prec[10][5];
void go(long long x, vector<long long> &res) {
  if (x < 0 || failed.find(x) != failed.end()) return;
  if (x == 0) {
    res = vector<long long>(6, 0);
    return;
  }
  int last = x % 10;
  for (int i = 0; i < 5; i++)
    if (!prec[last][i].empty()) {
      go((x - last) / 10 - i, res);
      if (!res.empty()) {
        for (int j = 0; j < 6; j++) res[j] = 10 * res[j] + prec[last][i][j];
        return;
      }
    }
  failed.insert(x);
}
int main() {
  for (int i = 0; i < 3 * 3 * 3 * 3 * 3 * 3; i++) {
    vector<int> v;
    int sum = 0;
    int t = i;
    for (int j = 0; j < 6; j++) {
      int x = t % 3;
      t /= 3;
      if (x == 1)
        x = 4;
      else if (x == 2)
        x = 7;
      v.push_back(x);
      sum += x;
    }
    prec[sum % 10][sum / 10] = v;
  }
  int tst;
  scanf("%d", &tst);
  while (tst-- > 0) {
    failed.clear();
    long long x;
    scanf("%lld", &x);
    vector<long long> res;
    go(x, res);
    if (res.empty()) {
      printf("-1\n");
      continue;
    }
    for (int i = 0; i < 6; i++)
      printf(
          "%lld"
          "%c",
          res[i], " \n"[i == 5]);
  }
  return 0;
}
