#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c = 0;
  cin >> n;
  int ar[n], arr[n];
  for (int i = 0; i < n; i++) {
    cin >> ar[i] >> arr[i];
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (ar[i] == arr[j]) c++;
    }
  }
  cout << c << endl;
}
