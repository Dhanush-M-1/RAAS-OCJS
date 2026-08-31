#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[]) {
  int n;
  int k;
  cin >> n >> k;
  int arr[n];
  cin >> arr[0];
  int tp[n - 1];
  int max = 0;
  for (int i = 1; i < n; i++) {
    cin >> arr[i];
    int temp = arr[i - 1] - arr[i];
    if (temp > max) {
      max = temp;
    }
  }
  if (max - k >= 0) {
    cout << max - k;
  } else
    cout << "0";
  return 0;
}
