#include <bits/stdc++.h>
using namespace std;
int n, l;
string s;
int main() {
  cin >> n >> s;
  for (int i = 0; i < s.size(); i++)
    if (s[i] == '8') l++;
  cout << min(n / 11, l);
}
