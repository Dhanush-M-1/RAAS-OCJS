#include <bits/stdc++.h>
using namespace std;
int main() {
  int a;
  cin >> a;
  int vmarr[1001][1001];
  for (int i = 0; i < a; i++) {
    int a1, b1;
    cin >> a1 >> b1;
    vmarr[i][0] = a1;
    vmarr[i][1] = b1;
  }
  int vmans = 0;
  for (int i = 0; i < a; i++) {
    int temp = vmarr[i][0];
    int temp2 = vmarr[i][1];
    for (int j = i + 1; j < a; j++) {
      if (vmarr[j][1] == temp) {
        vmans++;
      }
    }
    for (int j = i + 1; j < a; j++) {
      if (vmarr[j][0] == temp2) {
        vmans++;
      }
    }
  }
  cout << vmans;
  return 0;
}
