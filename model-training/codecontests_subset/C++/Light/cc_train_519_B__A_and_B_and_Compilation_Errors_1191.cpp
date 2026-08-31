#include <bits/stdc++.h>
using namespace std;
int main() {
  int x;
  cin >> x;
  int arr[x], ar[x - 1], a[x - 2];
  for (int i = 0; i < x; i++) cin >> arr[i];
  for (int i = 0; i < x - 1; i++) cin >> ar[i];
  for (int i = 0; i < x - 2; i++) cin >> a[i];
  sort(arr, arr + x);
  sort(ar, ar + x - 1);
  sort(a, a + x - 2);
  for (int i = 0; i < x; i++) {
    if (binary_search(ar + i, ar + x - 1, arr[i]) == 0) {
      cout << arr[i] << endl;
      break;
    }
  }
  for (int i = 0; i < x - 1; i++) {
    if (binary_search(a + i, a + x - 2, ar[i]) == 0) {
      cout << ar[i] << endl;
      break;
    }
  }
  return 0;
}
