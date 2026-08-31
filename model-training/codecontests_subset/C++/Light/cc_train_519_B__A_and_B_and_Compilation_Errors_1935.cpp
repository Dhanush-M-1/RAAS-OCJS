#include <bits/stdc++.h>
using namespace std;
int main() {
  int s[3] = {0};
  int n, in;
  cin >> n;
  for (int i = 0; i < 3; i++) {
    for (int j = i; j < n; j++) {
      cin >> in;
      s[i] += in;
    }
  }
  cout << s[0] - s[1] << endl;
  cout << s[1] - s[2] << endl;
  return 0;
}
