#include <bits/stdc++.h>
using namespace std;
int n;
string s;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> s >> n;
  for (auto i : s) {
    if (int(tolower(i) - 'a') < n)
      cout << char(toupper(i));
    else
      cout << char(tolower(i));
  }
  return 0;
}
