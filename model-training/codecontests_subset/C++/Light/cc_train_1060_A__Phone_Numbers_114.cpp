#include <bits/stdc++.h>
using namespace std;
int n;
string s;
int main() {
  cin >> n >> s;
  int x = count(s.begin(), s.end(), '8');
  cout << min(n / 11, x);
}
