#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 110;
int main(int argc, char const *argv[]) {
  char s[MAX_N];
  int n;
  int eight = 0;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> s[i];
    if (s[i] == '8') eight++;
  }
  cout << min(eight, n / 11) << endl;
  return 0;
}
