#include <bits/stdc++.h>
using namespace std;
int main() {
  int n = 5;
  int arr[5], sum = 0;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    sum += arr[i];
  }
  if (sum == 0)
    cout << -1 << endl;
  else if (sum % 5 != 0)
    cout << -1 << endl;
  else {
    int s = sum / 5;
    int a = 0, b = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] > s)
        a += s - arr[i];
      else
        b += arr[i] - s;
    }
    if (a == b)
      cout << s << endl;
    else
      cout << -1 << endl;
  }
}
