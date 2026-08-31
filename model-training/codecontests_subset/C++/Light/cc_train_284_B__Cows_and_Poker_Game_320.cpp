#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, res = 0, countOfI = 0;
  cin >> n;
  string str;
  cin >> str;
  for (int i = 0; i < str.length(); i++) {
    if (str[i] == 'A') {
      res++;
    } else if (str[i] == 'I') {
      countOfI++;
    }
  }
  res = countOfI > 1 ? 0 : (countOfI == 0 ? res : countOfI);
  cout << res << '\n';
}
