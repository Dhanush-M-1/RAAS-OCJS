#include <bits/stdc++.h>
using namespace std;
int main() {
  int l[101], r[101], n, a, b;
  cin >> n;
  for (int i = 0; i < 101; i++) {
    l[i] = 0;
    r[i] = 0;
  }
  for (int i = 1; i <= n; i++) {
    cin >> a >> b;
    l[a]++;
    r[b]++;
  }
  int count = 0;
  for (int i = 0; i < 101; i++) count = count + (l[i] * r[i]);
  cout << count << endl;
  return 0;
}
