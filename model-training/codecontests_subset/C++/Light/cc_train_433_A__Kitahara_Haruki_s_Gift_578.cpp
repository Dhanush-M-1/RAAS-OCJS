#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  if (n == 1) {
    cout << "NO" << endl;
    return 0;
  }
  int w[n];
  int count1 = 0, count2 = 0;
  for (int i = 0; i < n; i++) {
    cin >> w[i];
    if (w[i] == 100)
      count1++;
    else
      count2++;
  }
  if (count1 == 0 && count2 % 2 == 1) {
    cout << "NO";
  } else if ((count1 + 2 * count2) % 2 == 0)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
