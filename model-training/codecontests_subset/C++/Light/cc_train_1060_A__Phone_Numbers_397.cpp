#include <bits/stdc++.h>
using namespace std;
long long int const MOD = 1000000007;
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  long long int n;
  cin >> n;
  string str;
  cin >> str;
  long long int eightcount = 0;
  for (int i = 0; i < str.size(); i++) {
    if (str[i] == '8') {
      eightcount++;
    }
  }
  cout << min(eightcount, n / 11) << endl;
  return 0;
}
