#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int arr[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  int mn = 1000000;
  for (int i = 0; i < n; i++)
    if (!(k % arr[i])) {
      mn = min(mn, (k / arr[i]));
    }
  cout << mn;
}
