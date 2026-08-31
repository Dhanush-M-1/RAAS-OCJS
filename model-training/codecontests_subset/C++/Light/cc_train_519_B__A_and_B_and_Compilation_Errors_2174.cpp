#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a = 0, b = 0, c = 0;
  int count = 0;
  for (int j = 0; j <= 2; j++) {
    int arr[n];
    count++;
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
      if (count == 1)
        a = a + arr[i];
      else if (count == 2)
        b = b + arr[i];
      else
        c = c + arr[i];
    }
    n--;
  }
  cout << a - b << endl;
  cout << b - c << endl;
}
