#include <bits/stdc++.h>
using namespace std;
long long int n, in, all, folded;
char a[200001];
void quickSort(int arr[], int left, int right) {
  int i = left, j = right;
  int tmp;
  int pivot = arr[(left + right) / 2];
  while (i <= j) {
    while (arr[i] < pivot) i++;
    while (arr[j] > pivot) j--;
    if (i <= j) {
      tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
      i++;
      j--;
    }
  };
  if (left < j) quickSort(arr, left, j);
  if (i < right) quickSort(arr, i, right);
}
int main() {
  cin >> n >> a;
  in = all = folded = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] == 'A')
      all++;
    else if (a[i] == 'F')
      folded++;
    else
      in++;
  }
  if (in == 0) {
    cout << all << endl;
  } else if (in == 1) {
    cout << in << endl;
  } else {
    cout << 0 << endl;
  }
  return 0;
}
