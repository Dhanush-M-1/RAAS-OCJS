#include <bits/stdc++.h>
using namespace std;
vector<int> v;
int main() {
  int n;
  cin >> n;
  string str;
  cin >> str;
  int cnti = 0, cnta = 0;
  for (int i = 0; i < ((int)(str).size()); i++) {
    cnti += str[i] == 'I';
    cnta += str[i] == 'A';
  }
  if (cnti > 1)
    cout << 0;
  else if (cnti == 1)
    cout << 1;
  else
    cout << cnta;
  return 0;
}
