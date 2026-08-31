#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, count = 1;
  cin >> n;
  int coord[n];
  long long ht[n];
  for (int i = 0; i < n; i++) {
    cin >> coord[i] >> ht[i];
  }
  for (int i = 1; i < n - 1; i++) {
    if (coord[i] - ht[i] > coord[i - 1])
      count++;
    else if (coord[i] + ht[i] < coord[i + 1]) {
      count++;
      coord[i] = coord[i] + ht[i];
    }
  }
  if (n > 1) count++;
  cout << count;
}
