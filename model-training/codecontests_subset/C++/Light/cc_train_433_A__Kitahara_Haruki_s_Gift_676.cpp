#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a = 0, b = 0;
  cin >> n;
  int arr[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    if (arr[i] == 200)
      a++;
    else
      b++;
  }
  if (b % 2 || a % 2 && b == 0)
    cout << "NO";
  else
    cout << "YES";
}
