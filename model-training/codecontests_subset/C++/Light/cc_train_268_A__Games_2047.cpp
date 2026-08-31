#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, arr[30][2], game = 0;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> arr[i][0] >> arr[i][1];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (arr[i][0] == arr[j][1]) game++;
    }
  }
  cout << game;
  return 0;
}
