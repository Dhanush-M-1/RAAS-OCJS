#include <bits/stdc++.h>
using namespace std;
int main() {
  string st1, st2;
  cin >> st1 >> st2;
  int a;
  cin >> a;
  string n[a], m[a];
  for (int i = 0; i < a; i++) {
    cin >> n[i] >> m[i];
  }
  cout << st1 << " " << st2 << endl;
  for (int i = 0; i < a; i++) {
    if (n[i] == st1) {
      cout << st2 << " " << m[i] << endl;
      st1 = m[i];
    } else {
      cout << st1 << " " << m[i] << endl;
      st2 = m[i];
    }
  }
  return 0;
}
