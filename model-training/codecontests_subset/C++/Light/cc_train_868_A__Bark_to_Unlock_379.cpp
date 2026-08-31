#include <bits/stdc++.h>
using namespace std;
int main() {
  string a;
  int k;
  bool a1 = false;
  bool a2 = false;
  cin >> a;
  cin >> k;
  for (int i = 0; i < k; i++) {
    string n;
    cin >> n;
    if (n == a) {
      a1 = true;
      a2 = true;
    }
    if (n[0] == a[1]) a1 = true;
    if (n[1] == a[0]) a2 = true;
  }
  if (a1 == true && a2 == true)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
