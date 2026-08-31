#include <bits/stdc++.h>
using namespace std;
int main() {
  string a;
  cin >> a;
  int l = a.length();
  int p = (l - 1) / 2;
  int n = p + 1;
  sort(a.begin(), a.end());
  a.erase(0, p);
  for (int i = n - 1; i > 0; i = i - 1) {
    a.insert(i, "+");
  }
  cout << a << endl;
}
