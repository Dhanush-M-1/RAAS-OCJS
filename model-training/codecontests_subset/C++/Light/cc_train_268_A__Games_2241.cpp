#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int arr[2 * n];
  for (int i = 0; i < 2 * n; i++) {
    cin >> arr[i];
  }
  int count = 0;
  for (int i = 0; i < 2 * n; i += 2) {
    for (int j = 1; j < 2 * n; j += 2) {
      if (arr[i] == arr[j] && j - i != 1) {
        count++;
      }
    }
  }
  cout << count;
}
