#include <bits/stdc++.h>
using namespace std;
void merge(int *arr, int low, int mid, int high) {
  int i, j, b[high - low + 1], k;
  i = low;
  j = mid + 1;
  k = 0;
  while (i <= mid && j <= high) {
    if (arr[i] < arr[j])
      b[k++] = arr[i++];
    else
      b[k++] = arr[j++];
  }
  if (i > mid) {
    while (j <= high) b[k++] = arr[j++];
  } else {
    while (i <= mid) b[k++] = arr[i++];
  }
  for (i = 0, j = low; i < k; i++, j++) arr[j] = b[i];
}
void merge_sort(int *arr, int low, int high) {
  int mid = (low + high) / 2;
  if (low < high) {
    merge_sort(arr, low, mid);
    merge_sort(arr, mid + 1, high);
    merge(arr, low, mid, high);
  }
}
int main() {
  int j, i, n, arr[100001], b[100001];
  cin >> n;
  for (i = 0; i < n; i++) cin >> arr[i];
  for (i = 0; i < n - 1; i++) cin >> b[i];
  merge_sort(arr, 0, n - 1);
  merge_sort(b, 0, n - 2);
  int cnt = 0;
  for (i = 0, j = 0; j < n - 1; i++, j++) {
    if (arr[i] != b[j]) {
      cout << arr[i] << " ";
      cnt++;
      j--;
    }
  }
  if (cnt == 0) cout << arr[n - 1] << " ";
  for (i = 0; i < n - 2; i++) cin >> arr[i];
  merge_sort(arr, 0, n - 3);
  cnt = 0;
  for (i = 0, j = 0; j < n - 2; i++, j++) {
    if (b[i] != arr[j]) {
      cout << b[i] << " ";
      cnt++;
      j--;
    }
  }
  if (cnt == 0) cout << b[n - 2] << " ";
  return 0;
}
