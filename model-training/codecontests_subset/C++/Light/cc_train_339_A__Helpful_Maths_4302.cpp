#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int n = (s.length() / 2) + 1;
  int arr[n];
  int cnt = 0;
  for (int i = 0; i < s.length(); i += 2) {
    arr[cnt] = s[i] - '0';
    cnt++;
  }
  sort(arr, arr + n);
  cout << arr[0];
  for (int i = 1; i < n; ++i) {
    cout << "+" << arr[i];
  }
  return 0;
}
