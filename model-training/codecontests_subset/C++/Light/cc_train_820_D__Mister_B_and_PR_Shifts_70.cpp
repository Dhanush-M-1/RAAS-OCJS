#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1000000;
int countDiff[MAXN * 3];
int nums[MAXN];
int nNums;
int shifts;
long long minDiff;
long long diffs[MAXN];
int countNegative;
void handleShift(int n) {
  int ind = nNums - n;
  int former = nums[ind] - nNums;
  int latter = nums[ind];
  countDiff[nums[ind] + nNums - ind - 2]--;
  countDiff[nums[ind] + nNums - ind - 2 + nNums]++;
  long long currResult = diffs[n - 1];
  currResult += abs(latter) - abs(former);
  if (former < 0) {
    countNegative--;
  }
  countNegative += countDiff[nNums - 2 + n];
  currResult += countNegative;
  currResult -= (nNums - countNegative);
  diffs[n] = currResult;
  if (diffs[n] < minDiff) {
    minDiff = diffs[n];
    shifts = n;
  }
}
int main() {
  scanf("%d", &nNums);
  for (int i = 0; i < nNums; i++) {
    scanf("%d", nums + i);
    int diff = nums[i] - (i + 1);
    minDiff += abs(diff);
    countDiff[diff + (nNums - 1)]++;
    if (diff < 0) {
      countNegative++;
    }
  }
  diffs[0] = minDiff;
  for (int i = 1; i < nNums; i++) {
    handleShift(i);
  }
  cout << minDiff << ' ' << shifts << endl;
  return 0;
}
