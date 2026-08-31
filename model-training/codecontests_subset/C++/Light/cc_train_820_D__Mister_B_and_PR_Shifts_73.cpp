#include <bits/stdc++.h>
using namespace std;
int nums[1000005], pos[1000005], idx;
long long int diff[1000005], deviation[1000005], initialDeviation, result;
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &nums[i]);
    initialDeviation += abs(nums[i] - i);
    pos[nums[i]] = i;
  }
  result = initialDeviation;
  idx = 0;
  for (int i = 1; i <= n; i++) {
    if (pos[i] <= i) {
      int shift = i - pos[i] + 1;
      diff[1]--;
      diff[shift] += 2;
      shift = n - pos[i] + 1;
      diff[shift]--;
      int change = 2 * i - n - 1;
      diff[shift] += change;
      diff[shift + 1] -= change;
      diff[shift + 1]--;
      diff[n]++;
    } else {
      int shift = n - pos[i] + 1;
      diff[1]++;
      diff[shift]--;
      int change = 2 * i - n - 1;
      diff[shift] += change;
      diff[shift + 1] -= change;
      diff[shift + 1]--;
      diff[shift + 1 + i - 1] += 2;
      diff[n]--;
    }
  }
  for (int i = 1; i <= n; i++) diff[i] = diff[i - 1] + diff[i];
  deviation[0] = initialDeviation;
  for (int i = 1; i < n; i++) deviation[i] = deviation[i - 1] + diff[i];
  for (int i = 1; i < n; i++) {
    if (deviation[i] < result) {
      result = deviation[i];
      idx = i;
    }
  }
  printf("%lld %d\n", result, idx);
  return 0;
}
