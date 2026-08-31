#include <bits/stdc++.h>
using namespace std;
int main() {
  long int n;
  string name1, name2, name3, name4;
  cin >> name1 >> name2;
  cin >> n;
  for (int i = 0; i <= n; i++) {
    cout << name1 << " " << name2 << endl;
    cin >> name3 >> name4;
    if (name1.compare(name3) == 0) {
      name1 = name4;
    } else if (name2.compare(name3) == 0) {
      name2 = name4;
    }
  }
  return 0;
}
