#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, s = 0;
  cin >> n;
  long long g[n], h[n];
  for (int i = 0; i < n; i++) {
    cin >> h[i];
    cin >> g[i];
  }
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      if (h[i] == g[j]) s++;
  cout << s;
}
