#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  vector<int> v;
  int k;
  cin >> n;
  int k1 = 0;
  int k2 = 0;
  for (int i = 0; i < n; i++) {
    cin >> k;
    v.push_back(k);
    if (k == 100)
      k1++;
    else if (k == 200)
      k2++;
  }
  if ((k1 % 2 == 0) && (k2 % 2 == 0))
    cout << "YES";
  else if ((k1 == 0) && (k2 % 2) != 0) {
    cout << "NO";
  } else if (k2 % 2 != 0 && k1 % 2 == 0) {
    if (k1 >= 2) {
      cout << "YES";
    } else {
      cout << "NO";
    }
  } else
    cout << "NO";
  v.clear();
}
