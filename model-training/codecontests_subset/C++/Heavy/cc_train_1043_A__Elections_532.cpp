#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000000007;
const int MAX = 1000005;
int SetBit(int n, int x) { return n | (1 << x); }
int ClearBit(int n, int x) { return n & ~(1 << x); }
int ToggleBit(int n, int x) { return n ^ (1 << x); }
bool CheckBit(int n, int x) { return (bool)(n & (1 << x)); }
int arr[105];
int main(void) {
  int n, i, j, sum = 0, maxi = 0, add;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d", &arr[i]);
    sum += arr[i];
    if (arr[i] > maxi) maxi = arr[i];
  }
  for (i = maxi;; i++) {
    add = 0;
    for (j = 0; j < n; j++) add += (i - arr[j]);
    if (add > sum) {
      printf("%d\n", i);
      break;
    }
  }
  return 0;
}
