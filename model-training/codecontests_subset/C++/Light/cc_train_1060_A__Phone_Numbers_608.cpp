#include <bits/stdc++.h>
using namespace std;
const long long int MOD = 1e9 + 7;
const long long int MAXN = 1e6 + 1;
const long double PI = acos(-1);
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  ;
  int counter = 0;
  for (int i = 0; i < (n); ++i) {
    char x;
    cin >> x;
    if (x == '8') counter++;
  }
  cout << min(n / 11, counter);
  return 0;
}
