#include <bits/stdc++.h>
using namespace std;
int main(int argc, char* const argv[]) {
  ios_base::sync_with_stdio(0);
  string a, b;
  cin >> a >> b;
  int n;
  cin >> n;
  string old, newguy;
  for (int x = 0; x < (n); ++x) {
    cin >> old >> newguy;
    cout << a << " " << b << endl;
    if (a == old)
      a = newguy;
    else
      b = newguy;
  }
  cout << a << " " << b << endl;
  ;
  return 0;
}
