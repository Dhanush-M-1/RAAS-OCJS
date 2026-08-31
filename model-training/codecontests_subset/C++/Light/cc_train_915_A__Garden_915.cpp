#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, n, r, temp;
  int j;
  j = 0;
  cin >> n >> r;
  int ara[n], m;
  int ara2[100];
  for (i = 0; i < n; i++) {
    cin >> ara[i];
  }
  for (i = 0; i < n; i++) {
    if (r % ara[i] == 0) {
      ara2[j] = r / ara[i];
      j++;
    }
  }
  temp = ara2[0];
  for (i = 0; i < j; i++) {
    if (temp > ara2[i]) {
      temp = ara2[i];
    }
  }
  cout << temp << endl;
  return 0;
}
