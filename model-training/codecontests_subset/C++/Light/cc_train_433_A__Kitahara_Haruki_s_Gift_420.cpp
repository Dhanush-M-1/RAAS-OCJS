#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> v(n);
  int count1 = 0, count2 = 0;
  for (int i = 0; i < n; i++) {
    cin >> v[i];
    if (v[i] == 100)
      count1++;
    else
      count2++;
  }
  if (count2 % 2 == 0) {
    if (count1 % 2 == 0)
      cout << "YES";
    else
      cout << "NO";
  } else {
    if (count1 % 2 == 0 && count1 >= 2)
      cout << "YES";
    else
      cout << "NO";
  }
}
