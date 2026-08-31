#include <bits/stdc++.h>
using namespace std;
int rem[101];
int vol[101];
int n;
int limit = 10005;
pair<int, int> mem[105][20010];
pair<int, int> go(int ind, int sum) {
  if (ind == n) {
    if (sum > limit) return {1e9, 1e9};
    return {0, 0};
  }
  pair<int, int> &ret = mem[ind][sum];
  if (ret.first != -1) return ret;
  int empty = vol[ind] - rem[ind];
  pair<int, int> ch1 = go(ind + 1, sum + rem[ind]);
  pair<int, int> ch2 = go(ind + 1, sum - empty);
  ch1.second += rem[ind];
  ch2.first++;
  return ret = min(ch1, ch2);
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < 105; i++)
    for (int j = 0; j < 20010; j++) mem[i][j] = {-1, -1};
  for (int i = 0; i < n; i++) scanf("%d", rem + i);
  for (int i = 0; i < n; i++) scanf("%d", vol + i);
  pair<int, int> res = go(0, limit);
  cout << res.first << " " << res.second << endl;
  return 0;
}
