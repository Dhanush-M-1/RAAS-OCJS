#include <bits/stdc++.h>
using namespace std;
const int NMAX = 200005;
int n;
char str[NMAX];
int in, allin;
int main() {
  ios_base ::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  cin >> str;
  for (int i = 0; i < n; ++i)
    if (str[i] == 'A')
      ++allin;
    else if (str[i] == 'I')
      ++in;
  if (!in)
    cout << allin << "\n";
  else
    cout << (in == 1 ? 1 : 0) << "\n";
  return 0;
}
