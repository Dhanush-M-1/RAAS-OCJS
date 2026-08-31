#include <bits/stdc++.h>
using namespace std;
int main() {
  int N;
  cin >> N;
  int x1, x2, y;
  int ats[N];
  for (int i = 0; i < N; i++) {
    cin >> x1 >> x2 >> y;
    if (y < x1) {
      ats[i] = y;
    } else {
      ats[i] = y * ((x2 / y) + 1);
    }
  }
  for (int i = 0; i < N; i++) {
    cout << ats[i] << endl;
  }
  return 0;
}
