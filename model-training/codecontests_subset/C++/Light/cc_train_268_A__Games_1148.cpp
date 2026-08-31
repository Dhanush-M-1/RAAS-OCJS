#include <bits/stdc++.h>
using namespace std;
int main() {
  cout << setprecision(10);
  long long int n, i, l, k, j, a = 0, f = 0, c = 0, b = 0, x = 1000000007, d, y;
  string s, w;
  vector<long long int> vc, vct;
  vector<string> ch;
  double num, nr, radi;
  cin >> x;
  for (i = 0; i < x; i++) {
    cin >> a >> b;
    vc.push_back(a);
    vct.push_back(b);
  }
  for (i = 0; i < x; i++) {
    for (j = 0; j < x; j++) {
      if (vc[i] == vct[j]) c++;
    }
  }
  cout << c << endl;
}
