#include <bits/stdc++.h>
using namespace std;
long int binarySearch(vector<long int> arr, long int l, long int r,
                      long int x) {
  if (r >= l) {
    long int mid = l + (r - l) / 2;
    if (arr[mid] == x) return mid;
    if ((l == r) && (arr[mid] != x)) return -1;
    if (arr[mid] > x) return binarySearch(arr, l, mid - 1, x);
    return binarySearch(arr, mid + 1, r, x);
  }
  return -1;
}
void merge(vector<long int> &arr, long int l, long int m, long int r) {
  long int i, j, k;
  long int n1 = m - l + 1;
  long int n2 = r - m;
  long int L[n1], R[n2];
  for (i = 0; i < n1; i++) {
    L[i] = arr[l + i];
  }
  for (j = 0; j < n2; j++) {
    R[j] = arr[m + 1 + j];
  }
  i = 0;
  j = 0;
  k = l;
  while (i < n1 && j < n2) {
    if (L[i] <= R[j]) {
      arr[k] = L[i];
      i++;
    } else {
      arr[k] = R[j];
      j++;
    }
    k++;
  }
  while (i < n1) {
    arr[k] = L[i];
    i++;
    k++;
  }
  while (j < n2) {
    arr[k] = R[j];
    j++;
    k++;
  }
}
void mergeSort(vector<long int> &arr, long int l, long int r) {
  if (l < r) {
    long int m = l + (r - l) / 2;
    mergeSort(arr, l, m);
    mergeSort(arr, m + 1, r);
    merge(arr, l, m, r);
  }
}
long int min(long int a, long int b) {
  if (a < b) return a;
  return b;
}
long int max(long int a, long int b) {
  if (a > b) return a;
  return b;
}
int main() {
  int t;
  cin >> t;
  long long int sum = 0;
  long long int sum1 = 0;
  for (long int j = 0; j < t; j++) {
    long int temp;
    cin >> temp;
    sum = sum + temp;
  }
  for (long int j = 0; j < t - 1; j++) {
    long int temp;
    cin >> temp;
    sum1 = sum1 + temp;
  }
  cout << sum - sum1 << endl;
  sum = 0;
  for (long int j = 0; j < t - 2; j++) {
    long int temp;
    cin >> temp;
    sum = sum + temp;
  }
  cout << sum1 - sum;
}
