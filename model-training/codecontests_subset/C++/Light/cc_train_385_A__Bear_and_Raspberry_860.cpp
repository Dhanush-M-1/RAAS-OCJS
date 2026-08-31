#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  int arr[n];
  int max = 0;
  int min = INT_MAX;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  for (int i = 1; i < n; i++) {
    if (arr[i - 1] - arr[i] - c > max) {
      max = arr[i - 1] - arr[i] - c;
    }
  }
  cout << max << endl;
}
