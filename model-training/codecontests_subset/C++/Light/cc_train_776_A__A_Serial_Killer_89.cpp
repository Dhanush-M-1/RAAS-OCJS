#include <bits/stdc++.h>
using namespace std;
string name1, name2;
void print() {
  cout << name1 << " " << name2 << endl;
  return;
}
int main() {
  int n;
  string k, r;
  cin >> name1 >> name2;
  cin >> n;
  print();
  for (int i = 0; i < n; i++) {
    cin >> k >> r;
    if (k == name1)
      name1 = r;
    else if (k == name2)
      name2 = r;
    print();
  }
  return 0;
}
