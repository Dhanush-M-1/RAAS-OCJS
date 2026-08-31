#include <bits/stdc++.h>
using namespace std;
string vowels = "aeouiy";
const int N = 100100, R = 1000000;
int arr[N], dis1[N], dis2[N];
int main() {
  int n, p1 = 1, p2 = R;
  scanf("%d", &n);
  long long ans1 = 0, ans2 = 0;
  for (int i = 0; i < n; i++) scanf("%d", &arr[i]);
  sort(arr, arr + n);
  for (int i = 0; i < n; i++) {
    if (arr[i] <= R / 2) ans1 += abs(p1 - arr[i]), p1 = arr[i];
  }
  for (int i = n - 1; i >= 0; i--) {
    if (arr[i] > R / 2) ans2 += abs(p2 - arr[i]), p2 = arr[i];
  }
  printf("%lld", max(ans1, ans2));
}
