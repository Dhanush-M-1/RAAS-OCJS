#include <bits/stdc++.h>
using namespace std;
int m, n;
int main() {
  int n;
  string vic1, vic2, tmp1, tmp2;
  cin >> vic1 >> vic2;
  cin >> n;
  cout << vic1 << " " << vic2 << endl;
  for (int i = 0; i < n; ++i) {
    cin >> tmp1 >> tmp2;
    if (vic1 == tmp1)
      vic1 = tmp2;
    else
      vic2 = tmp2;
    cout << vic1 << " " << vic2 << endl;
  }
  return 0;
}
