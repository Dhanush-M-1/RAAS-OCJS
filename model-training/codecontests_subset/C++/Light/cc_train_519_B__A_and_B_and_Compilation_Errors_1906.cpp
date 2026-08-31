#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, arr[100005], arrS[3] = {0};
  cin >> n;
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < n; j++) {
      cin >> arr[j];
      arrS[i] += arr[j];
    }
    n--;
  }
  int x1 = arrS[0] - arrS[1];
  int x2 = arrS[1] - arrS[2];
  cout << x1 << "\n" << x2 << endl;
  return 0;
}
