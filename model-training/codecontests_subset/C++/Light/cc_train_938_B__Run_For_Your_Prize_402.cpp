#include <bits/stdc++.h>
using namespace std;
int main() {
  int time = 0;
  int n;
  cin >> n;
  int value;
  for (int i = 0; i < n; i++) {
    cin >> value;
    time = max(time, min(value - 1, 1000000 - value));
  }
  cout << time << endl;
  return 0;
}
