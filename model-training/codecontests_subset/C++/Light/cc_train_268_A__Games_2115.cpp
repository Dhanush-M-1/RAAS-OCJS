#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, arr[30][2], count = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> arr[i][0] >> arr[i][1];
  }
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      if (i != j and arr[i][0] == arr[j][1]) count++;
  cout << count << endl;
  return 0;
}
