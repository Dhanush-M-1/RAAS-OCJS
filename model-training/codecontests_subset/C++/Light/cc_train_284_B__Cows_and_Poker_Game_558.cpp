#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, count1 = 0, count2 = 0;
  cin >> n;
  char a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] == 'I') {
      count1++;
    }
    if (a[i] == 'A') {
      count2++;
    }
  }
  if (count1 == 0) {
    cout << count2 << "\n";
  } else if (count1 == 1)
    cout << "1"
         << "\n";
  else
    cout << "0\n";
  return 0;
}
