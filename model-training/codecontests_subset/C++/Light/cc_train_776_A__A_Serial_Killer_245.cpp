#include <bits/stdc++.h>
using namespace std;
int main() {
  string name1, name2;
  cin >> name1 >> name2;
  int n;
  cin >> n;
  cout << name1 << " " << name2 << endl;
  for (int i = 1; i <= n; i++) {
    string temp1, temp2;
    cin >> temp1 >> temp2;
    if (temp1 == name1)
      name1 = temp2;
    else
      name2 = temp2;
    cout << name1 << " " << name2 << endl;
  }
  return 0;
}
