#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
int n, i;
pair<int, int> dot[N];
long long mergeMoving(pair<int, int> arr[], pair<int, int> temp[], int left,
                      int right);
long long merge(pair<int, int> arr[], pair<int, int> temp[], int left, int mid,
                int right);
long long movingdot(pair<int, int> arr[], int array_size) {
  pair<int, int> temp[array_size];
  return mergeMoving(arr, temp, 0, array_size - 1);
}
long long mergeMoving(pair<int, int> arr[], pair<int, int> temp[], int left,
                      int right) {
  int mid;
  long long dis = 0LL;
  mid = right + left >> 1;
  if (left != mid) dis += mergeMoving(arr, temp, left, mid);
  if (right != mid + 1) dis += mergeMoving(arr, temp, mid + 1, right);
  dis += merge(arr, temp, left, mid + 1, right);
  return dis;
}
long long merge(pair<int, int> arr[], pair<int, int> temp[], int left, int mid,
                int right) {
  int i = left;
  int j = mid;
  int k = left;
  long long dis = 0;
  long long quick[right + 1];
  for (i = left; i <= right; i++) {
    dis += arr[i].first;
    quick[i] = dis;
  }
  dis = 0;
  i = left;
  while ((i < mid) && (j < right + 1)) {
    if (arr[i].second <= arr[j].second) {
      dis = dis + quick[right] - quick[j - 1] -
            1LL * (right - j + 1) * arr[i].first;
      temp[k++] = arr[i++];
    } else {
      temp[k++] = arr[j++];
    }
  }
  while (i <= mid - 1) temp[k++] = arr[i++];
  while (j <= right) temp[k++] = arr[j++];
  for (i = left; i <= right; i++) arr[i] = temp[i];
  return dis;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  for (i = 0; i < n; i++) cin >> dot[i].first;
  for (i = 0; i < n; i++) cin >> dot[i].second;
  sort(dot, dot + n);
  cout << movingdot(dot, n);
  return 0;
}
