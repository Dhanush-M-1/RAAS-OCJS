#include <bits/stdc++.h>
using namespace std;
int n, eight;
string s;
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> s;
  for (char c : s) eight += (c == '8');
  cout << min(n / 11, eight) << endl;
}
