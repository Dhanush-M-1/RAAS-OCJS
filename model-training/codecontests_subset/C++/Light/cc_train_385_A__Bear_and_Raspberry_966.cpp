#include <bits/stdc++.h>
using namespace std;
int main() {
  int d, n;
  cin >> d >> n;
  int arr[101] = {0}, arr2[101] = {0};
  for (int i = 0; i < d; i++) cin >> arr[i];
  for (int i = 1; i < d; i++) {
    arr2[i] = arr[i - 1] - arr[i];
  }
  sort(arr2, arr2 + d);
  int var = (arr2[d - 1] - n);
  if (var <= 0) {
    cout << "0" << endl;
    return 0;
  } else
    cout << var << endl;
  return 0;
}
