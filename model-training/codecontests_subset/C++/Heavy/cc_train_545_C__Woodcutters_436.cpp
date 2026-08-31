#include <bits/stdc++.h>
using namespace std;
int OO = (int)1e12;
const int MAX = (int)1e6;
long long n;
int height[MAX + 1];
int xDistance[MAX + 1];
int mem[MAX + 1][4];
int maxCut(int i, int which_fell, int previous_distance, int previous_height) {
  if (i == n) return 0;
  int &ret = mem[i][which_fell];
  if (ret != -1) return ret;
  ret = 0;
  if (which_fell == 0 || (i == 0)) {
    int distanceLeft = xDistance[i] - height[i];
    int distanceRight = xDistance[i] + height[i];
    if (distanceLeft > previous_distance) {
      ret = max(ret, 1 + maxCut(i + 1, 1, xDistance[i], height[i]));
    }
    if (distanceRight < xDistance[i + 1] || (i == 0)) {
      ret = max(ret, 1 + maxCut(i + 1, 2, xDistance[i], height[i]));
    }
    ret = max(ret, maxCut(i + 1, 0, xDistance[i], height[i]));
  }
  if (which_fell == 1 || i == n - 1) {
    int distanceLeft = xDistance[i] - height[i];
    int distanceRight = xDistance[i] + height[i];
    if (distanceLeft > previous_distance || i == 0) {
      ret = max(ret, 1 + maxCut(i + 1, 1, xDistance[i], height[i]));
    }
    if (distanceRight < xDistance[i + 1] || i == n - 1) {
      ret = max(ret, 1 + maxCut(i + 1, 2, xDistance[i], height[i]));
    }
    ret = max(ret, maxCut(i + 1, 0, xDistance[i], height[i]));
  }
  if (which_fell == 2) {
    int distanceLeft = xDistance[i] - height[i];
    int distanceRight = xDistance[i] + height[i];
    int previous_distance_new = previous_distance + previous_height;
    if (distanceLeft > previous_distance_new) {
      ret = max(ret, 1 + maxCut(i + 1, 1, xDistance[i], height[i]));
    }
    if (distanceRight < xDistance[i + 1]) {
      ret = max(ret, 1 + maxCut(i + 1, 2, xDistance[i], height[i]));
    }
    ret = max(ret, maxCut(i + 1, 0, xDistance[i], height[i]));
  }
  return ret;
}
int main() {
  cin >> n;
  height[n] = 0;
  xDistance[n] = OO;
  for (int i = 0; i < n; i++) {
    cin >> xDistance[i] >> height[i];
  }
  memset(mem, -1, sizeof(mem[0][0]) * (MAX + 1) * 4);
  cout << maxCut(0, 3, -OO, 0) << endl;
  return 0;
}
