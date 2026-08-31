#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, i;
  string Str;
  cin >> Str;
  cin >> x;
  for (i = 0; i < Str.size(); i++) Str[i] = tolower(Str[i]);
  for (i = 0; i < Str.size(); i++)
    if (Str[i] < x + 'a') Str[i] = toupper(Str[i]);
  cout << Str << endl;
  return 0;
}
