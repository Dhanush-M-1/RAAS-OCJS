#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int x = count(s.begin(), s.end(), '8');
  cout << min(x, n / 11);
}
