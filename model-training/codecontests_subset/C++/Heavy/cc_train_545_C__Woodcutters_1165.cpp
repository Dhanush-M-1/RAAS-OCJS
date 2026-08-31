#include <bits/stdc++.h>
using namespace std;
int n, dp[100004][3], height[100003], pos[100004];
int morningWood(int index, int dir) {
  if (index >= n) return 0;
  int &d = dp[index][dir];
  if (d != -1) return d;
  int currOccupy = (dir <= 1) ? pos[index] : pos[index] + height[index];
  d = morningWood(index + 1, 0);
  if (currOccupy < pos[index + 1] - height[index + 1])
    d = max(d, 1 + morningWood(index + 1, 1));
  if (index + 2 < n && pos[index + 1] + height[index + 1] < pos[index + 2])
    d = max(d, 1 + morningWood(index + 1, 2));
  if (index + 2 >= n) d = max(d, 1 + morningWood(index + 1, 2));
  return d;
}
int main() {
  cin >> n;
  for (int i = (int)0; i < int(n); i++) cin >> pos[i] >> height[i];
  memset(dp, -1, sizeof(dp));
  ;
  cout << max(morningWood(0, 0), max(morningWood(0, 1), morningWood(0, 2)))
       << endl;
  return 0;
}
