#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  int arr[n];
  int max = -1;
  int sum = 0;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    if (arr[i] > max) {
      max = arr[i];
    }
    sum += arr[i];
  }
  int comp_sum = 0;
  int tmp = max;
  while (comp_sum <= sum) {
    for (int i = 0; i < n; i++) {
      comp_sum += tmp - arr[i];
    }
    if (comp_sum <= sum) {
      comp_sum = 0;
      tmp++;
    }
  }
  printf("%d", tmp);
  return 0;
}
