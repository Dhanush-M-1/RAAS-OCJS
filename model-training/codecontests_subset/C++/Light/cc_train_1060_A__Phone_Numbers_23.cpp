#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int n;
  cin >> n;
  int arr[10] = {};
  for (int i = 0; i < n; i++) {
    char c;
    cin >> c;
    arr[c - '0']++;
  }
  cout << min(n / 11, arr[8]);
  return 0;
}
