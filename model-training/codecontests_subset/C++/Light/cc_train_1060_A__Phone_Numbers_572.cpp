#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, c = 0;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == '8') c++;
  }
  cout << min(n / 11, c) << endl;
}
